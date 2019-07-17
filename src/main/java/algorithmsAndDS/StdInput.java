package algorithmsAndDS;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StdInput {

    static String line;

    static BufferedReader br;

    /**
     * Do not create object.
     */
    private StdInput() {

    }

    public static void sync( String path ) throws IOException {
        FileInputStream fstream = new FileInputStream( path );
        DataInputStream in = new DataInputStream( fstream );
        br = new BufferedReader( new InputStreamReader( in ) );
    }

    public static int readInt() throws NumberFormatException, IOException {
        return Integer.parseInt( line );
    }

    public static boolean isEmpty() throws IOException {
        return  ( line = br.readLine() ) == null ;
    }

    public static int readFirstInt() {
        String[] str = line.split( " " );
        return Integer.parseInt( str[0] );
    }

    public static int readSecondInt() {
        String[] str = line.split( " " );
        return Integer.parseInt( str[1] );
    }
}
