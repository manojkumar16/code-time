package etc;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ibm.b2b.comms.sftpclient.SftpClientParameters;
import com.ibm.b2b.comms.sftpclient.services.BeginSessionResponse;
import com.ibm.b2b.comms.sftpclient.services.GetResponse;
import com.ibm.b2b.comms.sftpclient.services.PutResponse;

public class ConSftpCall {

    private ExecutorService ex;

    private Properties props;

    public ConSftpCall( Properties sftpProps ) {
        this.props = sftpProps;
    }

    public void callSftpClientInParallel() {
        int file_transfer_count = Integer.parseInt( props.getProperty( "FILE_TRANSFER_COUNT" ) );

        try {
            int POOL_SIZE = Integer.parseInt( props.getProperty( "NUM_OF_THREADS" ) );
            ex = Executors.newFixedThreadPool( POOL_SIZE );

            ExecutorCompletionService<String> ecs = new ExecutorCompletionService<String>( ex );

            for ( int i = 0; i < file_transfer_count; i++ ) {
                ecs.submit( new Invoker( props ) );
            }

            for ( int j = 0; j < file_transfer_count; j++ ) {
                String res = ecs.take().get();
            }

            System.out.println( "MKP_Result:" + Invoker.getAverageFileTrasferRate() );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        } catch ( ExecutionException e ) {
            e.printStackTrace();
        } finally {
            ex.shutdown();
        }

    }
}

class Invoker implements Callable<String> {

    private Properties properties;

    private long start_time;

    private long end_time;

    private long exec_time;

    private String execution_time;

    private static ArrayList<Long> avg_exec_time = new ArrayList<Long>();

    private static ArrayList<Long> fileTransferredSize = new ArrayList<Long>();

    public Invoker( Properties prop ) {
        this.properties = prop;
    }

    @Override
    public String call() throws Exception {
        System.out.println( "Thread spawned..." );

        executeSFTPCommand( properties );
        
        return "DONE";
    }

    private void executeSFTPCommand( Properties properties2 ) {

        try {
            String remoteHost = properties2.getProperty( "REMOTE_HOST" );
            int remotePort = Integer.parseInt( properties2.getProperty( "REMOTE_PORT" ) );
            String remoteUser = properties2.getProperty( "REMOTE_USER" );
            String remotePassword = properties2.getProperty( "REMOTE_PASSWORD" );
            String cmd = properties2.getProperty( "SFTP_COMMAND" );

            Long fsize = Long.parseLong( properties.getProperty( "CONCURRENT_FILE_SIZE" ) );
            String src = properties.getProperty( "CLIENT_LOCAL_FOLDER_LOCATION_CON" );
            src = createTempFile( src, fsize );

            String dest = properties2.getProperty( "SERVER_REMOTE_FOLDER_LOCATION_CON" );

            System.out.println( "SFTP SERVER DETAILS: host:" + remoteHost + "  port:" + remotePort + "  user:"
                + remoteUser + "  password:" + remotePassword );


            // perform basic sftp client operation
            if ( cmd.equalsIgnoreCase( "put" ) ) {
                start_time = System.currentTimeMillis();
//                PutResponse putRes = sftpclient.put( src, dest );
                Process pr = Runtime.getRuntime().exec( "/ais_local/share/abajpai/mkpp/sftpclient/collect/sftp.sh "+src+" "+dest );
                end_time = System.currentTimeMillis();
                File f = new File( src );
                fsize = f.length();
                System.out.println( "put file size in bytes:" + fsize );
                fileTransferredSize.add( fsize );
            } else if ( cmd.equalsIgnoreCase( "get" ) ) {
                start_time = System.currentTimeMillis();
//                GetResponse getRes = sftpclient.get( src, dest );
                Process pr = Runtime.getRuntime().exec( "/ais_local/share/abajpai/mkpp/sftpclient/collect/sftp.sh "+src+" "+dest );
                end_time = System.currentTimeMillis();
                File f = new File( dest );
                fsize = f.length();
                fileTransferredSize.add( fsize );
            }

            exec_time = end_time - start_time;
            execution_time = SftpTimeTracker.parseTime( exec_time );
            System.out.println( "Time taken : " + execution_time );
            avg_exec_time.add( exec_time );
        
        
        } catch ( NumberFormatException e ) {
            e.printStackTrace();
        } finally {
            sftpclient.endSession();
        }
    }

    public static String getAverageFileTrasferRate() {
        double total_size = 0;
        double total_time = 0;
        for ( int i = 0; i < avg_exec_time.size(); i++ ) {
            total_time = total_time + avg_exec_time.get( i );
        }

        for ( int i = 0; i < fileTransferredSize.size(); i++ ) {
            total_size = total_size + fileTransferredSize.get( i );
        }

        total_time = total_time / 1000; // In seconds
        System.out.println( "Total time:" + total_time );
        System.out.println( "Total size:" + total_size );
        double avgSpeedInBytes = total_size / total_time;
        double avgSpeedInKB = total_size / ( total_time * 1024 );
        double avgSpeedInMB = total_size / ( total_time * 1024 * 1024 );

        String avgSpeedInBytesStr = avgSpeedInBytes + " Bytes/sec";
        String avgSpeedInKBStr = avgSpeedInKB + " KiloBytes/sec";
        String avgSpeedInMBStr = avgSpeedInMB + " MegaBytes/sec";
        return "[" + avgSpeedInBytesStr + ", " + avgSpeedInKBStr + ", " + avgSpeedInMBStr + "]";
    }

    private String createTempFile( String src, Long fsize ) {
        Random rn = new Random();
        String fileName = "Temp_" + System.currentTimeMillis() + "_" + rn.nextInt();
        String fname = src + fileName;
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(fname, "rw");
            raf.setLength( fsize*1024 );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf != null) {
                try {
                    raf.close();
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
        }
        return fname;
    }
}