package algorithmsAndDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SumOfSubset {
//    static int[] w = { 10, 7, 5, 18, 12, 20, 15 };
    static int[] w = {3, 34, 4, 12, 5, 2};
    static int close_max = 0;

    static int[] x = new int[w.length];

    static Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();

    static List<Integer> ls = new ArrayList<Integer>();

    static int m = 35;

    public static void main( String[] args ) {
        Arrays.sort( w );
        int r = sum( w );

        sumOfSubset( 0, 0, r );

        System.out.println( "----------" );

        List<Integer> optimalList = findOptimalList( hm );
        for ( Integer i : optimalList ) {
            System.out.print( w[i] + "  " );
        }
    }

    private static List<Integer> findOptimalList( Map<Integer, List<Integer>> hm2 ) {
        if ( hm.containsKey( m ) ) {
            return hm.get( m );
        }
        int optimalsum = 0;
        Iterator<Integer> iter = hm.keySet().iterator();
        while ( iter.hasNext() ) {
            int temp = iter.next();
            if ( temp >= optimalsum ) {
                optimalsum = temp;
            }
        }
        return hm.get( optimalsum );
    }

    private static void sumOfSubset( int s, int k, int r ) {
        x[k] = 1;
        if ( s + w[k] == m ) {
            displayX( 0, k );
            return;
        }
        
        if ( ( s + w[k] + w[k + 1] ) <= m ) {
            sumOfSubset( s + w[k], k + 1, r - w[k] );
        }
        if ( ( ( s + r - w[k] ) >= m ) && ( ( s + w[k + 1] ) <= m ) ) {
            x[k] = 0;
            sumOfSubset( s, k + 1, r - w[k] );
        }
    }

    private static void putX( int start, int end ) {
        List<Integer> l = new ArrayList<Integer>();
        int sum = 0;
        for ( int i = start; i <= end; i++ ) {
            if ( x[i] == 1 ) {
                l.add( i );
                sum = sum + w[i];
            }
        }
        hm.put( sum, l );
    }

    private static void displayX( int start, int end ) {
        hm.put( m, new ArrayList<Integer>() );
        for ( int i = start; i <= end; i++ ) {
            if ( x[i] == 1 ) {
                System.out.print( w[i] + "  " );
                hm.get( m ).add( i );
            }
        }
        System.out.println();
    }

    private static int sum( int[] arr ) {
        int sum = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            sum = sum + arr[i];
        }
        return sum;
    }

}
