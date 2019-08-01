package algo.ds;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * A "zero-one" integer is one in which each digit is either a zero or a one
 * 
 * @author mkprasad
 *
 */
public class Solution {

    public static void main( String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
        int n = Integer.parseInt( reader.readLine() );
        int i = 2;
        int t = n;
        int zeroOne = t;
        while ( t > 0 ) {
            if ( t % 10 == 0 || t % 10 == 1 ) {
                // first index is either 0 or 1
                t = t / 10;
            } else {
                t = n * i;
                zeroOne = t;
                i++;
            }
        }
        System.out.println( zeroOne );
    }
}
