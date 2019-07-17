package iostreams;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PushbackInputStream;
import java.io.Reader;
import java.io.Serializable;
import java.util.Scanner;

public class IOStreams implements Serializable {

    public static void main( String[] args ) throws IOException {
        ClassLoader cl = null;
        
        //Class.forName( "asd" );
        
        byte[] bytes = "hello world...".getBytes();
        BufferedInputStream bis = new BufferedInputStream( System.in );
        System.out.println(bis.read());
//        ByteArrayIOStreamSample( bytes );
 //       ObjectIOStreamSample();
//        FileIOStreamSample();
//        FileReaderWriterSample();

  //      PushbackIOStreamSample();
        
    }

    private static void ObjectIOStreamSample() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject( new IOStreams() );
        oos.close();
        System.out.println(bos.size());
    }

    private static void PushbackIOStreamSample() throws IOException {
        InputStream in = new FileInputStream( new File("/home/mkprasad/tests/temp.java") );
        PushbackInputStream input = new PushbackInputStream( in, 5 );
        
        int data = input.read();
        System.out.println((char)data);
     //   input.rea
    }

    private static void FileReaderWriterSample() throws IOException {
        Reader reader = new FileReader( "/home/mkprasad/Desktop/temp/sample.xml~" );
        int data = reader.read();
        while ( data != -1 ) {
            System.out.print( (char) data );
            data = reader.read();
        }
    }

    private static void FileIOStreamSample() throws IOException {
        OutputStream out = new FileOutputStream( "/home/mkprasad/tt22.txt" );
        PrintStream ps = new PrintStream( out );
        System.setOut( ps );

        System.out.println( "--Welcome to java world" );
        out.close();

        InputStream is = new FileInputStream( "/home/mkprasad/Desktop/temp/sample.xml~" );
        int data = is.read();
        while ( data != -1 ) {
            System.out.print( (char) data );
            data = is.read();
        }
    }

    private static void ByteArrayIOStreamSample( byte[] bytes ) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream( bytes );

        while ( bis.available() > 0 )
            System.out.println( bis.read() );
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write( bytes );
        bos.flush();
        bos.close();
        String str = new String( bos.toByteArray() );
        byte[] outbytes = bos.toByteArray();
        byte[] strbytes = str.getBytes();
        boolean equal = checkEqual( outbytes, strbytes );
        System.out.println( equal );
        System.out.println( new String( outbytes ) );
        System.out.println( new String( strbytes ) );
    }

    private static boolean checkEqual( byte[] outbytes, byte[] strbytes ) {
        if ( outbytes.length != strbytes.length )
            return false;
        for ( int i = 0; i < outbytes.length; i++ ) {
            if ( outbytes[i] != strbytes[i] )
                return false;
        }
        return true;
    }

}
