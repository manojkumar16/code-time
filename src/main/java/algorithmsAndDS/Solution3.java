package algorithmsAndDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    public static void main( String[] args ) throws Exception {
        Solution3 ob = new Solution3();
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

        int n = Integer.parseInt( reader.readLine() );
       // String[] tokens = reader.readLine().split( " " );

        int ind=0;
        while ( ind != n ) {
            Integer.parseInt( reader.readLine() );
            n--;
        }
        int[] d = { 1, 3, 2, 3, 4, 1 };
        String str1 = "";
        String str2 = "";
        for ( int i = 0; i < d.length; i++ ) {
            boolean b1 = find( d[i], d, 0, i );
            boolean b2 = find( d[i], d, i + 1, d.length );
            if ( b1 ) {
                str1 = str1 + "1";
            } else {
                str1 = str1 + "0";
            }

            if ( b2 ) {
                str2 = str2 + "1";
            } else {
                str2 = str2 + "0";
            }

        }
        System.out.println( str1 );
        System.out.println( str2 );

    }

    private static boolean find( int key, int[] d, int s, int e ) {
        for ( int i = s; i < e; i++ ) {
            if ( key == d[i] ) {
                return true;
            }
        }
        return false;
    }

}
