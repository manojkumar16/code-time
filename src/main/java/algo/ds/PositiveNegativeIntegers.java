package algo.ds;

import java.util.Arrays;

/**
 * Give you an array which has n integers,it has both positive and negative integers.Now you need sort this array in a
 * special way.After that,the negative integers should be in the front, and the positive integers should be in the
 * back.Also the relative position should not be changed. eg. -1 1 3 -2 2 ans: -1 -2 1 3 2. o(n)time complexity and o(1)
 * space complexity is perfect.
 * 
 * @author mkprasad
 * 
 */
public class PositiveNegativeIntegers {
    public static void main( String[] args ) {
        int[] a1 = { -1, 1, 3, -2, 2 };
        int[] a2 = { 100, -1, 5, 4, -7, 11, 12, 0, -2, -1, -10, 11, -2 };
        int[] a3 = { -1, 1, 3, -2, 2, 5, -7, -6 };
        PositiveNegativeIntegers ob = new PositiveNegativeIntegers();
        ob.start( a1 );
        ob.start( a2 );
        ob.start( a3 );
    }

    private void start( int[] a ) {
        int n = -1, p = -1; // set positive and negative count

        for ( int i = 0; i < a.length; i++ ) {
            if ( a[i] < 0 ) {
                n = i;
                if ( n > p && p >= 0 ) {
                    move( a, p, n );

                    p++; // increment positive index which will be used for next negative value set.
                }
            } else if ( p <= 0 ) { // get first positive number index
                p = i;
            }
        }
        System.out.println( Arrays.toString( a ) );
    }

    /**
     * replace first positive number with negative number. and then move remaining positive numbers by 1 towards right.
     * For { -1, 1, 3, -2, 2 }, s=1, and e=3, replace a[s] with a[e], and set a[s+1] with a[s], increment s by 1. do it
     * until u reach end 'e'
     * 
     * @param s start index
     * @param e end index
     */
    private static void move( int[] a, int s, int e ) {
        int temp = a[s];
        a[s] = a[e];
        for ( int i = s + 1; i <= e; i++ ) {
            int t2 = a[i];
            a[i] = temp;
            temp = t2;
        }
    }
}
