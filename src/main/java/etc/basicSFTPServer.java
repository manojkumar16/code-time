package etc;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.apache.sshd.SshServer;
import org.apache.sshd.common.NamedFactory;
import org.apache.sshd.common.util.OsUtils;
import org.apache.sshd.server.Command;
import org.apache.sshd.server.ForwardingFilter;
import org.apache.sshd.server.PasswordAuthenticator;
import org.apache.sshd.server.PublickeyAuthenticator;
import org.apache.sshd.server.command.ScpCommandFactory;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.session.ServerSession;
import org.apache.sshd.server.sftp.SftpSubsystem;
import org.apache.sshd.server.shell.ProcessShellFactory;


public class basicSFTPServer {
    public static void main(String args[]) throws IOException{
        String host = "localhost";
        int port = 8039;
        String enabledProtocol = "BOTH"; //BOTH, scp, sftp
        
        SshServer sshd = SshServer.setUpDefaultServer();
        sshd.setPort( port );
        
        sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider("key.ser"));
        
        List<NamedFactory<Command>> factories = new ArrayList<NamedFactory<Command>>();
        if ("BOTH".equalsIgnoreCase(enabledProtocol)) {
            factories.add(new SftpSubsystem.Factory());
            sshd.setCommandFactory(new ScpCommandFactory());
        } else if ("scp".equalsIgnoreCase(enabledProtocol)) {
            sshd.setCommandFactory(new ScpCommandFactory());
        } else {
            factories.add(new SftpSubsystem.Factory());
        }
        sshd.setSubsystemFactories(factories);
        
        if (OsUtils.isUNIX()) {
            sshd.setShellFactory(new ProcessShellFactory(new String[] {
                    "/bin/sh", "-i", "-l" }, EnumSet
                    .of(ProcessShellFactory.TtyOptions.ONlCr)));
        } else {
            sshd.setShellFactory(new ProcessShellFactory(
                    new String[] { "cmd.exe " }, EnumSet.of(
                            ProcessShellFactory.TtyOptions.Echo,
                            ProcessShellFactory.TtyOptions.ICrNl,
                            ProcessShellFactory.TtyOptions.ONlCr)));
        }
        
        sshd.setPasswordAuthenticator(new PasswordAuthenticator() {
            public boolean authenticate(String username, String password, ServerSession session) {
                return username != null && username.equals(password);
            }
        });
        sshd.setPublickeyAuthenticator(new PublickeyAuthenticator() {
            public boolean authenticate(String username, PublicKey key, ServerSession session) {
                //File f = new File("/Users/" + username + "/.ssh/authorized_keys");
                return true;
            }
        });
        
        sshd.setForwardingFilter(new ForwardingFilter() {
            public boolean canForwardAgent(ServerSession session) {
                return true;
            }

            public boolean canForwardX11(ServerSession session) {
                return true;
            }

            public boolean canListen(InetSocketAddress address, ServerSession session) {
                return true;
            }

            public boolean canConnect(InetSocketAddress address, ServerSession session) {
                return true;
            }
        });
        
        sshd.start();
        System.out.println("SSHD Server started at "+port);
    }
}
