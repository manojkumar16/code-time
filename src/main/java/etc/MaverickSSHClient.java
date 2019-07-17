package etc;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.util.Properties;

import com.ibm.b2b.testclient.interfaces.TestClient;
import com.ibm.b2b.testclient.run.TestClientPerf;
import com.maverick.events.defaultlogger.J2SSHLoggingListener;
import com.maverick.sftp.SftpStatusException;
import com.maverick.sftp.TransferCancelledException;
import com.maverick.ssh.ChannelOpenException;
import com.maverick.ssh.HostKeyVerification;
import com.maverick.ssh.SshAuthentication;
import com.maverick.ssh.SshClient;
import com.maverick.ssh.SshConnector;
import com.maverick.ssh.SshException;
import com.maverick.ssh.components.SshPublicKey;
import com.maverick.ssh2.Ssh2Client;
import com.maverick.ssh2.Ssh2Context;
import com.sshtools.net.SocketTransport;
import com.sshtools.sftp.SftpClient;

/**
 * Performance testing for Maverick client
 * @author mkprasad
 *
 */
public class MaverickSSHClient implements TestClient {
    
    private boolean bAuthenticate;
    private Properties props;
    private String remoteHost;
    private int remotePort;
    private String remoteUser;
    private String remotePassword;
    private SshClient ssh;
    private Ssh2Client ssh2;
    
    private String cipher = "aes128-cbc";
    private String mac = "hmac-sha1";
    private String kexAlgorithm = "diffie-hellman-group1-sha1";
    private String compression = "none";
    
    public static void main(String args[]) {
        TestClientPerf sc = new TestClientPerf();
        sc.begin(args, "MaverickSSHClient");
    }
    
    public void login(Properties properties) {
        this.props = properties;
        remoteHost = props.getProperty( "REMOTE_HOST" );
        remotePort = Integer.parseInt( props.getProperty( "REMOTE_PORT" ) );
        remoteUser = props.getProperty( "REMOTE_USER" );
        remotePassword = props.getProperty( "REMOTE_PASSWORD" );

        
        try {
            SshConnector.addEventListener( "MaverickSSHClientTemp", new J2SSHLoggingListener() );
            SshConnector con = SshConnector.getInstance();
            Ssh2Context ssh2Context = (Ssh2Context) con.getContext( SshConnector.SSH2 );
            
            ssh2Context.setPreferredCipherCS( cipher );
            ssh2Context.setPreferredCipherSC( cipher );
            
            ssh2Context.setPreferredCompressionCS( compression  );
            ssh2Context.setPreferredCompressionSC( compression  );
            
            ssh2Context.setPreferredMacCS( mac );
            ssh2Context.setPreferredMacSC( mac );
            
            ssh2Context.setPreferredKeyExchange( kexAlgorithm );
            
            HostKeyVerification verify = new HostKeyVerification() {
                @Override
                public boolean verifyHost( String arg0, SshPublicKey arg1 ) throws SshException {
                    // TODO Auto-generated method stub
                    return true;
                }
            };
            ssh2Context.setHostKeyVerification( verify );
            ssh2Context.setPreferredPublicKey( Ssh2Context.PUBLIC_KEY_SSHDSS );

            SocketTransport t = new SocketTransport( remoteHost, remotePort );
            t.setTcpNoDelay( true );
            ssh = con.connect( t, remoteUser );
            ssh2 = (Ssh2Client) ssh;

            /**
             * Authenticate the user using password authentication
             */
            com.maverick.ssh.PasswordAuthentication pwd = new com.maverick.ssh.PasswordAuthentication();
            do {
                pwd.setPassword( remotePassword );
            } while ( ssh2.authenticate( pwd ) != SshAuthentication.COMPLETE && ssh.isConnected() );
            
            if(ssh2.isAuthenticated()) {
                bAuthenticate = true;
            } else {
                bAuthenticate = false;
            }
        } catch ( SocketException e ) {
            e.printStackTrace();
        } catch ( SshException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public boolean put(String src, String dest) {
        try {
            SftpClient sftp = new SftpClient( ssh2 );
            sftp.put( src, dest );
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
            return false;
        } catch ( SftpStatusException e ) {
            e.printStackTrace();
            return false;
        } catch ( SshException e ) {
            e.printStackTrace();
            return false;
        } catch ( ChannelOpenException e ) {
            e.printStackTrace();
            return false;
        } catch ( TransferCancelledException e ) {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    public boolean get(String src, String dest) {
        try {
            SftpClient sftp = new SftpClient( ssh2 );
            sftp.get( src, dest );
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
            return false;
        } catch ( SftpStatusException e ) {
            e.printStackTrace();
            return false;
        } catch ( SshException e ) {
            e.printStackTrace();
            return false;
        } catch ( ChannelOpenException e ) {
            e.printStackTrace();
            return false;
        } catch ( TransferCancelledException e ) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
    
    public void disconnect() {
        ssh.disconnect();
    }
    public boolean isAuthenticated() {
        return bAuthenticate;
    }
}
