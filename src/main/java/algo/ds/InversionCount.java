package algo.ds;

import java.util.Arrays;

/**
 * Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already
 * sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. Formally
 * speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
 * 
 * Example: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 * 
 * @author mkprasad
 * 
 */
public class InversionCount {

    public static void main( String[] args ) {
       // int arr[] = { 1, 20, 6, 4, 5 };
        int arr[] = {2,4,1,3,5};
        // int arr[] = { 2, 4, 1, 3, 5 };
        // int arr[] = {4,5,6,1,2,3};
     //   new InversionCount().inversionCountBruteForce( arr );
        new InversionCount().inversionCountDisplacementMethod( arr );
      //  new InversionCount().inversionCountMergeSort( arr );
    }

    // 1, 20, 6, 4, 5
    // 1, 4, 5, 6, 20
    private void inversionCountDisplacementMethod( int[] arr ) {
        int[] sorted = new int[arr.length];
        for ( int i = 0; i < arr.length; i++ ) {
            sorted[i] = arr[i];
        }
        Arrays.sort( sorted );

        int inv_count = 0;
        for ( int i = 0; i < arr.length; i++ ) {
            if ( sorted[i] != arr[i] ) {
                inv_count += findIndex( arr, sorted[i], i + 1 ) - i;
            }
        }
        
        System.out.println( "Inversion count using displacement method: " + inv_count );
    }

    private int findIndex( int[] arr, int key, int start ) {
        for ( int i = start; i < arr.length; i++ ) {
            if ( arr[i] == key ) {
                return i;
            }
        }
        return 0;
    }

    private void inversionCountMergeSort( int[] arr ) {
        int[] temp = new int[arr.length];
        int inv_count = mergeSort( arr, temp, 0, arr.length - 1 );
        System.out.println( "Inversion count using Merge sort: " + inv_count );
    }

    private int mergeSort( int[] arr, int[] temp, int left, int right ) {
        int mid, inv_count = 0;
        if ( right > left ) {
            /*
             * Divide the array into two parts and call _mergeSortAndCountInv() for each of the parts
             */
            mid = ( right + left ) / 2;

            /*
             * Inversion count will be sum of inversions in left-part, right-part and number of inversions in merging
             */
            inv_count = mergeSort( arr, temp, left, mid );
            inv_count += mergeSort( arr, temp, mid + 1, right );

            /* Merge the two parts */
            inv_count += merge( arr, temp, left, mid + 1, right );
        }

        return inv_count;
    }

    private int merge( int[] arr, int[] temp, int left, int mid, int right ) {
        int i, j, k;
        int inv_count = 0;

        i = left; /* index for left subarray */
        j = mid; /* index for right subarray */
        k = left; /* index for resultant merged subarray */
        while ( ( i <= mid - 1 ) && ( j <= right ) ) {
            if ( arr[i] <= arr[j] ) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];

                /*
                 * this is tricky -- see [ http://www.geeksforgeeks.org/counting-inversions/ ] explanation/diagram for
                 * merge()
                 */
                inv_count = inv_count + ( mid - i );
            }
        }

        /*
         * Copy the remaining elements of left subarray (if there are any) to temp
         */
        while ( i <= mid - 1 )
            temp[k++] = arr[i++];

        /*
         * Copy the remaining elements of right subarray (if there are any) to temp
         */
        while ( j <= right )
            temp[k++] = arr[j++];

        /* Copy back the merged elements to original array */
        for ( i = left; i <= right; i++ )
            arr[i] = temp[i];

        return inv_count;
    }

    // Time Complexity: O(n^2)
    private void inversionCountBruteForce( int[] arr ) {
        int inv_count = 0;
        for ( int i = 0; i < arr.length - 1; i++ ) {
            for ( int j = i + 1; j < arr.length; j++ ) {
                if ( arr[i] > arr[j] ) {
                    inv_count++;
                }
            }
        }

        System.out.println( "Inversion count by Brute force: " + inv_count );
    }
}
