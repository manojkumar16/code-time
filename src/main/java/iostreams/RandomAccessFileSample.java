package iostreams;
import java.io.File;
import java.io.RandomAccessFile;


public class RandomAccessFileSample {

    public static void main( String[] args ) throws Exception {
        RandomAccessFile file = new RandomAccessFile("/home/mkprasad/tests/temp.java", "rw");

        file.seek(200);

        long pointer = file.getFilePointer();
        
        file.write( "hello world!!!RandomAccessFile file = new RandomAccessFile".getBytes() );
        file.write( "RRRRRRRRRRRRRRRRRRRRR".getBytes() );
        System.out.println(pointer);
        file.close();
        
    }

}
