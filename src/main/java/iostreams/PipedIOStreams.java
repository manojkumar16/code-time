package iostreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedIOStreams {

    public static void main( String[] args ) throws IOException {
        final PipedInputStream pis = new PipedInputStream( 2048 );
        final PipedOutputStream pos = new PipedOutputStream();
        pos.connect( pis );

        new Thread() {
            public void run() {
                try {
                    for ( int i = 0; i < 10000; i++ ) {
                        pos.write( i );
                    }
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    new A().printItOut( pis );
                } catch ( IOException e ) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

class A {
    public void printItOut( InputStream is ) throws IOException {
        while ( is.available() > 0 )
            System.out.println( is.read() );
    }
}