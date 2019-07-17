package etc;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.apache.sshd.ClientChannel;
import org.apache.sshd.ClientSession;
import org.apache.sshd.SshClient;
import org.apache.sshd.common.util.NoCloseOutputStream;

public class SshClientTest {
    public static void main(String[] args) throws Exception {
        //SshClient.main(args);
        testClient();
    }
    public static void testClient() throws Exception {
        SshClient client = SshClient.setUpDefaultClient();
        client.start();
        ClientSession session = client.connect("localhost", 4000).await().getSession();
        session.authPassword("lee", "password").await().isSuccess();
        //ClientChannel channel = session.createChannel(ClientChannel.CHANNEL_EXEC, "pwd\n");
        ClientChannel channel = session.createChannel(ClientChannel.CHANNEL_SHELL);

        
        ByteArrayOutputStream sent = new ByteArrayOutputStream();
        PipedOutputStream pipedIn = new TeePipedOutputStream(sent);
        channel.setIn(new PipedInputStream(pipedIn));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        channel.setOut(out);
        channel.setErr(err);
        channel.open();

        pipedIn.write("ls\n".getBytes());
        pipedIn.flush();
        
        System.out.println(new String(out.toByteArray()));
        
        pipedIn.write("exit\n".getBytes());
        pipedIn.flush();

        channel.waitFor(ClientChannel.CLOSED, 0);

        channel.close(false);
        client.stop();

        System.out.println(new String(sent.toByteArray()));
        System.out.println("============");
        System.out.println(new String(out.toByteArray()));
    }

    public void testClientClosingStream() throws Exception {
        SshClient client = SshClient.setUpDefaultClient();
        client.start();
        ClientSession session = client.connect("localhost", 4000).await().getSession();
        session.authPassword("lee", "password").await().isSuccess();
        ClientChannel channel = session.createChannel(ClientChannel.CHANNEL_SHELL);


        ByteArrayOutputStream sent = new ByteArrayOutputStream();
        PipedOutputStream pipedIn = new TeePipedOutputStream(sent);
        channel.setIn(new PipedInputStream(pipedIn));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        channel.setOut(out);
        channel.setErr(err);
        channel.open();

        pipedIn.write("this is my command\n".getBytes());
        pipedIn.flush();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append("0123456789");
        }
        sb.append("\n");
        pipedIn.write(sb.toString().getBytes());

        pipedIn.close();

        channel.waitFor(ClientChannel.CLOSED, 0);

        channel.close(false);
        client.stop();

    }

    public void testClientWithLengthyDialog() throws Exception {
        SshClient client = SshClient.setUpDefaultClient();
        // Reduce window size and packet size
//        client.getProperties().put(SshClient.WINDOW_SIZE, Integer.toString(0x20000));
//        client.getProperties().put(SshClient.MAX_PACKET_SIZE, Integer.toString(0x1000));
//        sshd.getProperties().put(SshServer.WINDOW_SIZE, Integer.toString(0x20000));
//        sshd.getProperties().put(SshServer.MAX_PACKET_SIZE, Integer.toString(0x1000));
        client.start();
        ClientSession session = client.connect("localhost", 4000).await().getSession();
        session.authPassword("lee", "smx");
        ClientChannel channel = session.createChannel(ClientChannel.CHANNEL_SHELL);
        ByteArrayOutputStream sent = new ByteArrayOutputStream();
        PipedOutputStream pipedIn = new TeePipedOutputStream(sent);
        channel.setIn(new PipedInputStream(pipedIn));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        channel.setOut(out);
        channel.setErr(err);
        channel.open().await();

        long t0 = System.currentTimeMillis();

        int bytes = 0;
        for (int i = 0; i < 10000; i++) {
            byte[] data = "01234567890123456789012345678901234567890123456789\n".getBytes();
            pipedIn.write(data);
            pipedIn.flush();
            bytes += data.length;
            if ((bytes & 0xFFF00000) != ((bytes - data.length) & 0xFFF00000)) {
                System.out.println("Bytes written: " + bytes);
            }
        }
        pipedIn.write("exit\n".getBytes());
        pipedIn.flush();

        long t1 = System.currentTimeMillis();

        System.out.println("Sent " + (bytes / 1024) + " Kb in " + (t1 - t0) + " ms");

        System.out.println("Waiting for channel to be closed");

        channel.waitFor(ClientChannel.CLOSED, 0);

        channel.close(false);
        client.stop();

    }
}