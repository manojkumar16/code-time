package algo.ds;

import java.util.ArrayList;
import java.util.List;

/*
 * Bucket sort is mainly useful when input is uniformly distributed over a range. For example, consider the following
 * problem. Sort a large set of floating point numbers which are in range from 0.0 to 1.0 and are uniformly distributed
 * across the range. How do we sort the numbers efficiently?
 * 
 * Algorithm:
 * bucketSort(arr[], n)
1) Create n empty buckets (Or lists).
2) Do following for every array element arr[i].
.......a) Insert arr[i] into bucket[n*array[i]]
3) Sort individual buckets using insertion sort.
4) Concatenate all sorted buckets.

http://www.geeksforgeeks.org/bucket-sort-2/
 */
public class BucketSort {

    public static void main( String[] args ) {
        float arr[] = { 0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f };
        display( arr );
        bucketSort( arr );
        display( arr );
    }

    private static void display( float[] arr ) {
        for ( int i = 0; i < arr.length; i++ ) {
            System.out.print( arr[i] + "  " );
        }
        System.out.println();
    }

    private static void bucketSort( float[] a ) {
        // Create n empty buckets
        List<Float>[] b = (ArrayList<Float>[]) new ArrayList[a.length];
        for ( int i = 0; i < b.length; i++ ) {
            b[i] = new ArrayList<Float>();
        }

        // Insert array elements in different buckets
        for ( int i = 0; i < a.length; i++ ) {
            int ind = (int) ( a[i] * a.length );
            b[ind].add( a[i] );
        }

        // Sort individual buckets using insertion sort
        for ( int i = 0; i < b.length; i++ ) {
            if ( b[i].size() > 1 ) {
                b[i] = sort( b[i] );
            }
        }

        // Concatenate all sorted buckets
        int j = 0; // from 0 to n elements
        for ( int i = 0; i < b.length; i++ ) { // iterate bucket elements
            for ( int k = 0; k < b[i].size(); k++ ) { // each bucket contents. There may be more than 1 elements
                a[j++] = b[i].get( k );
            }
        }
    }

    private static List<Float> sort( List<Float> ls ) {
        //Create array out of list
        float[] f = new float[ls.size()];
        for ( int i = 0; i < f.length; i++ ) {
            f[i] = ls.get( i );
        }

        for ( int i = 1; i < f.length; i++ ) {
            int j = i;
            while ( j > 0 && f[j] < f[j - 1] ) {
                swap( f, j, j - 1 );
                j--;
            }
        }
        
        //Create new list and fill it with sorted float array
        ls = new ArrayList<Float>();
        for ( int i = 0; i < f.length; i++ ) {
            ls.add( f[i] );
        }
        
        //return list
        return ls;
    }

    private static void swap( float[] f, int i, int j ) {
        float t = f[i];
        f[i] = f[j];
        f[j] = t;
    }
}
