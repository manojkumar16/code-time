package etc.one;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedOutputStream;

public class TeePipedOutputStream extends PipedOutputStream {

    private OutputStream tee;

    public TeePipedOutputStream( OutputStream tee ) {
        this.tee = tee;
    }

    @Override
    public void write( int b ) throws IOException {
        super.write( b );
        tee.write( b );
    }

    @Override
    public void write( byte[] b, int off, int len ) throws IOException {
        super.write( b, off, len );
        tee.write( b, off, len );
    }

}
