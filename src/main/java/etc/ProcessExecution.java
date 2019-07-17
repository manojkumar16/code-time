package etc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessExecution {

    public static void main( String[] args ) {
        
        executeCMD();
    }

    private static void executeCMD() {
        try {
            Process pr = Runtime.getRuntime().exec( "/ais_local/share/abajpai/mkpp/sftpclient/collect/sftp.sh" );

            int exitVal = pr.waitFor();
            System.out.println( "Exited with error code: " + exitVal );

            // Get input streams
            BufferedReader stdInput = new BufferedReader( new InputStreamReader( pr.getInputStream() ) );
            BufferedReader stdError = new BufferedReader( new InputStreamReader( pr.getErrorStream() ) );

            // Read command standard output
            String s;
            System.out.println( "Standard output: " );
            while ( ( s = stdInput.readLine() ) != null ) {
                System.out.println( s );
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }
}
