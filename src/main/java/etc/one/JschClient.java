package etc.one;


import java.util.Properties;

import com.ibm.b2b.comms.sftpclient.SftpClientParameters;
import com.ibm.b2b.comms.sftpclient.impl.SftpClientImpl;
import com.ibm.b2b.comms.sftpclient.services.BeginSessionResponse;
import com.ibm.b2b.comms.sftpclient.services.GetResponse;
import com.ibm.b2b.comms.sftpclient.services.PutResponse;
import com.ibm.b2b.testclient.interfaces.TestClient;
import com.ibm.b2b.testclient.run.TestClientPerf;

/**
 * Performance testing for JSCH Client
 * @author mkprasad
 *
 */
public class JschClient implements TestClient {

    private boolean bAuthenticate;

    private SftpClientImpl sftpclient;

    public static void main( String args[] ) {
        TestClientPerf sc = new TestClientPerf();
        sc.begin( args, "com.ibm.b2b.testclient.impl.JschClient" );
    }

    @Override
    public void login( Properties props ) {

        sftpclient = new SftpClientImpl();
        try {
            String remoteHost = props.getProperty( "REMOTE_HOST" );
            int remotePort = Integer.parseInt( props.getProperty( "REMOTE_PORT" ) );
            String remoteUser = props.getProperty( "REMOTE_USER" );
            String remotePassword = props.getProperty( "REMOTE_PASSWORD" );

            Properties sftpProps = new Properties();
            sftpProps.setProperty( SftpClientParameters.REMOTE_HOST, remoteHost );
            sftpProps.setProperty( SftpClientParameters.REMOTE_PORT, remotePort + "" );
            sftpProps.setProperty( SftpClientParameters.REMOTE_USER, remoteUser );
            sftpProps.setProperty( SftpClientParameters.REMOTE_PASSWORD, remotePassword );

            BeginSessionResponse response = sftpclient.beginSession( sftpProps );

            if ( response.isSuccess() ) {
                bAuthenticate = true;
            } else {
                bAuthenticate = false;
            }

        } catch ( NumberFormatException e ) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean put( String src, String dest ) {
        PutResponse putRes = sftpclient.put( src, dest );
        if ( putRes.isSuccess() ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean get( String src, String dest ) {
        GetResponse getRes = sftpclient.get( src, dest );
        if ( getRes.isSuccess() ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void disconnect() {
        sftpclient.endSession();
        sftpclient = null;
    }

    @Override
    public boolean isAuthenticated() {
        return bAuthenticate;
    }
}
