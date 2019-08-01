package etc.one;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.UserInfo;

public class JschChannelExec {

    private static Session session;
    private static Channel channel;
    private static ChannelExec c;

    public static void main( String[] args ) {
        try {
            JSch jsch = new JSch();
            String host = "blrgislin10";
            int port = 8239;
            String user = "admin";
            String password = "password";
            session = jsch.getSession( user, host, port );
            // username and password will be given via UserInfo interface.
            UserInfo ui = new MyUserInfo();
            session.setUserInfo( ui );
            session.setPassword( password );
            
            session.connect(40000);

            channel = session.openChannel( "exec" );
            ((ChannelExec)channel).setCommand("ls");
            channel.setInputStream(null);
            ((ChannelExec)channel).setErrStream(System.err);

            InputStream in=channel.getInputStream();

            channel.connect();
            
            c = (ChannelExec) channel;
            c.connect( 40000 );

            //executeLIST( );
        } catch ( JSchException je ) {
            je.printStackTrace();
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            System.out.println( "Disconnecting channel..." );
            if ( session != null ) {
                session.disconnect();
            }
            if ( c != null ) {
                c.disconnect();
            }

        }
    }

    private static void executeLIST() throws JSchException {

        c.setCommand( "ls" );
        c.start();
        String path = ".";
/*        try {
            Vector vv = c.ls( path );
            if ( vv != null ) {
                for ( int ii = 0; ii < vv.size(); ii++ ) {
                    // out.println(vv.elementAt(ii).toString());

                    Object obj = vv.elementAt( ii );
                    if ( obj instanceof com.jcraft.jsch.ChannelSftp.LsEntry ) {
                        System.out.println( ( (com.jcraft.jsch.ChannelSftp.LsEntry) obj ).getLongname() );
                    }
                }
            }
        } catch ( SftpException e ) {
            System.out.println( e.toString() );
        }*/

    }

    public static class MyUserInfo implements UserInfo {
        public String getPassword() {
            return null;
        }

        public boolean promptYesNo( String str ) {
            return true;
        }

        public String getPassphrase() {
            return null;
        }

        public boolean promptPassphrase( String message ) {
            return true;
        }

        public boolean promptPassword( String message ) {
            return true;
        }

        public void showMessage( String message ) {

        }
    }
}
