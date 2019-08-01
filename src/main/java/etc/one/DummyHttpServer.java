package etc.one;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;

public class DummyHttpServer {
    private static final int MAX_REQUEST_SIZE = 1024 * 1024;

    private final Map<Pattern, String> responseFormatByRequestPattern = new HashMap<Pattern, String>();

    private Thread serverThread = null;

    boolean running = false;

    ServerSocketChannel serverSocketChannel = null;

    private final CountDownLatch boundLatch = new CountDownLatch( 1 );

    private final AtomicInteger badRequestCount = new AtomicInteger( 0 );

    private final AtomicInteger goodRequestCount = new AtomicInteger( 0 );

    private int port = 0;

    /**
     * Adds a request pattern and associate to a response format where response parameters align with request pattern
     * matching groups.
     * 
     * @param requestPattern the required request regex, for example "^GET /testServer HTTP/1.1(.*)$"
     * @param responseFormat the response format, for example "HTTP/1.1 200 OK\r\n{0}"
     */
    public void addRequestResponsePair( String requestPattern, String responseFormat ) {
        responseFormatByRequestPattern.put( Pattern.compile( requestPattern, Pattern.DOTALL ), responseFormat );
    }

    public static void main( String[] args ) throws InterruptedException, Exception {
        new DummyHttpServer().start();
    }

    /**
     * Start the server socket channel thread, begin accepting requests.
     * 
     * @param verbose true means log all input and output to System.out
     * @return the port it is listening on
     * @throws InterruptedException
     * @throws Exception
     */
    private void start() throws InterruptedException, Exception {
        /*addRequestResponsePair( "dummyhttpserver",
            getSuccessfulTestResponseMessage( "expectedResponsePayload", "expectedResponseAttachment" ) );*/
        addRequestResponsePair( "dummyhttpserver",getSOAPEnvelope() );
        addRequestResponsePair( "stop", "stop" );
        final boolean verbose = true;
        serverThread = new Thread( new Runnable() {

            @Override
            public void run() {
                System.out.println( "PatternHttpServer.start.run" );
                SocketChannel socketChannel = null;
                try {
                    serverSocketChannel = ServerSocketChannel.open();
                    if ( verbose ) {
                        System.out.println( "PatternHttpServer.start.run binding to null" );
                    }
                    SocketAddress isa = new InetSocketAddress( 20425 );
                    serverSocketChannel.socket().bind( isa );

                    running = true;
                    port = serverSocketChannel.socket().getLocalPort();
                    if ( verbose ) {
                        System.out.println( "PatternHttpServer.start.run bound to " + port );
                    }
                    boundLatch.countDown();
                    while ( running ) {
                        socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking( false );
                        ByteBuffer inByteBuffer = ByteBuffer.allocate( MAX_REQUEST_SIZE );
                        inByteBuffer.clear();
                        int lastRead = 1;
                        boolean hadLastChance = false;
                        while ( inByteBuffer.hasRemaining() && lastRead > 0 ) {
                            lastRead = socketChannel.read( inByteBuffer );
                            if ( lastRead == 0 && !hadLastChance ) {
                                lastRead = 1;
                                hadLastChance = true;
                                Thread.sleep( 2000 );
                            } else if ( lastRead > 0 ) {
                                hadLastChance = false;
                            }
                        }
                        inByteBuffer.flip();
                        String inString = new String( inByteBuffer.array(), inByteBuffer.arrayOffset()
                            + inByteBuffer.position(), inByteBuffer.remaining() );
                        inString = dechunk( inString );
                        if ( verbose ) {
                            System.out.println( "PatternHttpServer got request [" + inString + "]" );
                        }
                        String outString = lookupReplyByRequest( inString );
                        ByteBuffer outByteBuffer = ByteBuffer.wrap( outString.getBytes( "UTF-8" ) );
                        socketChannel.write( outByteBuffer );
                        socketChannel.close();
                        socketChannel = null;
                    }
                } catch ( Exception e ) {
                    if ( running ) {
                        System.out.println( "PatternHttpServer threw " + e );
                    }
                } finally {
                    if ( verbose ) {
                        System.out.println( "PatternHttpServer closing port " + port );
                    }
                    if ( socketChannel != null ) {
                        try {
                            socketChannel.close();
                        } catch ( IOException e ) {
                            e.printStackTrace();
                        }
                    }
                    if ( serverSocketChannel != null ) {
                        try {
                            serverSocketChannel.close();
                        } catch ( IOException e ) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            private String lookupReplyByRequest( String request ) {
                for ( Entry<Pattern, String> entry : responseFormatByRequestPattern.entrySet() ) {
                    Pattern requestPattern = entry.getKey();
                    Matcher matcher = requestPattern.matcher( request );
                    if ( matcher.find() ) {
                        String responseFormat = entry.getValue();
                        if ( responseFormat.equalsIgnoreCase( "stop" ) ) {
                            stop();
                            System.exit( 0 );
                        }
                        int groupCount = matcher.groupCount();
                        Object[] groupArray = new String[groupCount];
                        for ( int i = 0; i < groupCount; i++ ) {
                            groupArray[i] = matcher.group( i + 1 ); // matcher reserves #0 for whole match...
                        }
                        String response = MessageFormat.format( responseFormat, groupArray );
//                        if ( verbose ) {
//                            System.out.println( "PatternHttpServer matched request, response=[" + response + "]" );
//                        }
                        goodRequestCount.incrementAndGet();
                        return MessageFormat.format( responseFormat, groupArray );
                    }
                }
                badRequestCount.incrementAndGet();
                System.out.println( "PatternHttpServer did not match request" );
                return "HTTP/1.1 400 Bad Request\r\n\r\n";
            }
        } );
        serverThread.start();
        if ( !boundLatch.await( 10, TimeUnit.SECONDS ) ) {
            throw new Exception( "Server thread timed out trying to bind socket." );
        }
        // return port;

    }

    /**
     * Stop the listening thread, cleanup.
     */
    public void stop() {
        System.out.println( "PatternHttpServer stopping on port " + port );
        running = false;
        if ( serverSocketChannel != null ) {
            try {
                serverSocketChannel.close();
            } catch ( IOException e ) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return number of bad (non matching) requests seen
     */
    public int getBadRequestCount() {
        return badRequestCount.get();
    }

    /**
     * @return number of good (matching) requests seen
     */
    public int getGoodRequestCount() {
        return goodRequestCount.get();
    }

    private String dechunk( String inString ) {
        inString = inString.replaceAll( "\r\n[0123456789abcdefABCDEF]+\r\n", "" );
        return inString;
    }

    private String getSuccessfulTestResponseMessage( final String expectedResponsePayload,
        final String expectedResponseAttachment ) {
        return "HTTP/1.1 200 OK\r\n"+ "<soapenv:Body>" + "<wsrm:CreateSequenceResponse>"
            + "<wsrm:Identifier>http://Business456.com/RM/ABC</wsrm:Identifier>"
            + "</wsrm:CreateSequenceResponse>" + "</soapenv:Body>";
    }

    private String getSOAPEnvelope() {
        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace wsa = factory.createOMNamespace( "http://www.w3.org/2005/08/addressing", "wsa" );
        OMNamespace wsrm = factory.createOMNamespace( "http://docs.oasis-open.org/ws-rx/wsrm/200702", "wsrm" );
        OMElement CreateSequenceResponse = factory.createOMElement( "CreateSequenceResponse", wsrm );

        OMElement Identifier = factory.createOMElement( "Identifier", wsrm );
        Identifier.setText( "urn:uuid:656652b8-9af2-4e94-9d07-2dc21c05ed27" );

        OMElement IncompleteSequenceBehavior = factory.createOMElement( "IncompleteSequenceBehavior", wsrm );
        IncompleteSequenceBehavior.setText( "DiscardFollowingFirstGap" );

        OMElement Accept = factory.createOMElement( "Accept", wsrm );
        OMElement AcksTo = factory.createOMElement( "AcksTo", wsrm );
        OMElement Address = factory.createOMElement( "Address", wsa );
        Address.setText( "http://localhost:20424/dummyhttpserver" );

        AcksTo.addChild( Address );
        Accept.addChild( AcksTo );
        CreateSequenceResponse.addChild( Identifier );
        CreateSequenceResponse.addChild( IncompleteSequenceBehavior );
        CreateSequenceResponse.addChild( Accept );

        SOAPFactory soapFactory = OMAbstractFactory.getSOAP12Factory();
        // get the default envelope
        SOAPEnvelope env = soapFactory.getDefaultEnvelope();
        env.getBody().addChild( CreateSequenceResponse );

        OMElement Action = factory.createOMElement( "Action", wsa );
        Action.setText( "http://docs.oasis-open.org/ws-rx/wsrm/200702/CreateSequenceResponse" );

        OMElement RelatesTo = factory.createOMElement( "RelatesTo", wsa );
        RelatesTo.setText( "urn:uuid:B8AA50FE602294313D1389025686111" );

        OMElement To = factory.createOMElement( "To", wsa );
        To.setText( "http://docs.oasis-open.org/ws-rx/wsmc/200702/anonymous?id=urn:uuid:B8AA50FE602294313D1389025686106" );

        env.getHeader().addChild( Action );
        env.getHeader().addChild( RelatesTo );
        env.getHeader().addChild( To );
        
        System.out.println(env);
        //return "HTTP/1.1 200 OK\r\n"+env.toString();
        return "HTTP/1.1 200 OK\r\n";
    }

}
