package algo.ds;

import java.util.Arrays;

/**
 * Given Two separate integer arrays, find the combined median of the two arrays without using any extra array
 * 
 * @author mkprasad
 * 
 */
public class CombinedMedian {

    public static void main( String[] args ) {
        new CombinedMedian().start();
    }

    /**
     * The working Algorithm goes as: 
     * 1. Sort both the arrays in place (using Quick Sort or any other of your choice) 
     * 2.Calculate total length of the arrays. 
     *      If (len1 + len2) is odd Median will be element at Pos = totalLen /2 +1
     *          assuming we are taking two arrays as continuous memory locations 
     *      If (len1 + len2) is even median will be 1/2 of sum of elements at Pos(totalLen/2) + Pos = totalLen /2 +1
     * 
     * Implementation for step 2 will be by taking two pointers on the start element of both the sorted arrays and keep
     * moving them one by one for the smaller element of two. Once that iteration is reached to the Pos as applicable
     * return.
     */
    private void start() {
        int[] a1 = new int[] {2, 4, 6, 8, 11, 17,7,5};
        int[] a2 = new int[] {1, 3, 5, 10, 14, 16, 23};
        int[] a3 = new int[] {2, 4, 6, 8, 11, 17,7,5,1, 3, 5, 10, 14, 16, 23};
        sort( a1 );
        sort( a2 );
        sort( a3 );
        display( a1 );
        display( a2 );
        display( a3 );
        System.out.println(a3.length);
        int total_len = a1.length + a2.length;
        int result = 0;
        int count = 1;
        int i = 0, j = 0;
        while ( count < total_len / 2 ) {
            if ( a1[i] < a2[j] ) {
                i++;
                result = a1[i];
            } else {
                j++;
                result = a2[j];
            }
            count++;
        }
        System.out.println(i+","+j);
        if ( total_len % 2 == 0 ) {
            // even length
            if ( a1[i] < a2[j] ) {
                result = ( a1[i] + a1[i + 1] ) / 2;
            } else {
                result = ( a1[i] + a2[j] ) / 2;
            }
        }
        System.out.println( "Result: " + result );
    }

    private void display( int[] a ) {
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    private void sort( int[] a ) {
        Arrays.sort( a );
    }

}
