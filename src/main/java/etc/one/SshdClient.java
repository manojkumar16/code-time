package etc.one;
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE
 * file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.sshd.ClientChannel;
import org.apache.sshd.ClientSession;
import org.apache.sshd.SshClient;
import org.apache.sshd.client.channel.ChannelExec;
import org.apache.sshd.client.channel.ChannelSubsystem;
import org.apache.sshd.client.future.ConnectFuture;
import org.apache.sshd.common.util.NoCloseOutputStream;

public class SshdClient extends SshClient {
    private static int port;

    private static String login;

    private static String host;

    private static String password;

    public static void main( String arg[] ) throws Exception {
        // blrgislin10 -vv -l mprasad -p 22
/*        host = "localhost";
        port = 4000;
        login = "lee";
        password = "password";
*/
        host = "blrgislin01";
        port = 22;
        login = "mprasad";
        password = "man83kumar";

        
        List<String> cmd = new ArrayList<String>();
        // cmd.add( "put log4j.properties" );
        cmd.add( "pwd" );
        // cmd.add( "get dumper.sh.in" );

        testSFTPCommand();

    }

    private static void testSFTPCommand() {
        SshClient client = null;
        //ClientChannel channel = null;

        List<String> commands = new ArrayList<String>();
        commands.add( "ls" );

        try {
            client = SshClient.setUpDefaultClient();
            client.start();
            ConnectFuture future = client.connect( host, port );
            future.await();
            ClientSession session = future.getSession();
            boolean auth = session.authPassword( login, password ).await().isSuccess();

        
            if ( auth ) {
                System.out.println( "Authenticated...." );
            } else {
                System.out.println( "Authentication failed...." );
            }

           //ClientChannel channel = session.createChannel( ClientChannel.CHANNEL_EXEC, "ls | wc -c" );
            ChannelSubsystem channel = session.createSubsystemChannel( "sftp" );
            //ClientChannel channel = session.createChannel( ClientChannel.CHANNEL_SUBSYSTEM, "subsystem");
            
            //InputStream in = new ByteArrayInputStream( "ls".getBytes() );
            
            channel.setIn( System.in  );
            channel.setOut( System.out );
            channel.setErr( System.err );
            
            channel.open().await();
            //channel.waitFor( ClientChannel.CLOSED, 0 ); // session.close(false);
        } catch ( Throwable t ) {
            t.printStackTrace();
            // System.exit( 1 );
        } finally {
            client.stop();
        }
    }
}
