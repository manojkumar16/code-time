package etc;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GZIPExample {

    public static void main( String[] args ) {
        String file = "/home/mkprasad/Projects/fewExamples/temp2.txt";
        String gzipFile = "/home/mkprasad/Projects/fewExamples/temp2.txt.rmp";
        String newFile = "/home/mkprasad/Projects/fewExamples/temp2.txt_newdecompressed";

        compressGzipFile( file, gzipFile );

        decompressGzipFile( gzipFile, newFile );

    }

    private static void decompressGzipFile( String gzipFile, String newFile ) {
        try {
            FileInputStream fis = new FileInputStream( gzipFile );
            GZIPInputStream gis = new GZIPInputStream( fis );
            FileOutputStream fos = new FileOutputStream( newFile );
            byte[] buffer = new byte[1024];
            int len;
            while ( ( len = gis.read( buffer ) ) != -1 ) {
                fos.write( buffer, 0, len );
            }
            // close resources
            fos.close();
            gis.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

    private static void compressGzipFile( String file, String gzipFile ) {
        try {
            FileInputStream fis = new FileInputStream( file );
            FileOutputStream fos = new FileOutputStream( gzipFile );
            GZIPOutputStream gzipOS = new GZIPOutputStream( fos );
            byte[] buffer = new byte[1024];
            int len;
            while ( ( len = fis.read( buffer ) ) != -1 ) {
                gzipOS.write( buffer, 0, len );
            }
            // close resources
            gzipOS.close();
            fos.close();
            fis.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

}