package algo.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Given an array of integers(+ve,-ve,0 or duplicates). Find n print all triplets such that a+b+c=0. 
 * e.g. Let A = -1 0 9 5 -5 2 3 
 * Then Answer = {0 5 -5} {-5 2 3}.
 * 
 * @author mkprasad
 * 
 */
public class ThreeSum {

    public static void main( String[] args ) {
       // int[] arr = new int[] {-1, 0, 9, 5, -5, 2, 3 };
        int[] arr = new int[]{1,5,-3,-5,-2,7,-1,0};
        System.out.println("Quadratic solution: ");
        quadraticSolution(arr);
        System.out.println("HashMap solution: ");
        hashMapSolution(arr);
    }

    private static void hashMapSolution( int[] arr ) {
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for ( int i = 0; i < arr.length; i++ ) {
            hm.put( arr[i], i );
        }
        for ( int i = 0; i < arr.length; i++ ) {
            for ( int j = i + 1; j < arr.length; j++ ) {
                int k = -( arr[i] + arr[j] );
                //if ( ( arr[i] + arr[j] + k ) == 0 && hm.get( k ) != null && hm.get( k ) > j ) {
                if ( hm.get( k ) != null && hm.get( k ) > j ) {
                    System.out.println( arr[i] + "," + arr[j] + "," + k );
                }
            }
        }
    }

    //N2 - N square
    private static void quadraticSolution( int[] arr ) {
        Arrays.sort( arr );
        for ( int i = 0; i < arr.length - 3; i++ ) {
            int a = arr[i];
            int k = i + 1;
            int l = arr.length - 1;
            while ( k < l ) {
                int b = arr[k];
                int c = arr[l];
                if ( a + b + c == 0 ) {
                    System.out.println( a + "," + b + "," + c );
                    k++;
                } else if ( ( a + b + c ) > 0 ) {
                    l--;
                } else {
                    k++;
                }
            }
        }
    }
}
