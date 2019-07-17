package algorithmsAndDS;

public class Find3Numbers {

    public static void main( String[] args ) {
        new Find3Numbers().find3Numbers();
    }

    /**
     * Find a sorted subsequence of size 3 in linear time.
     *  http://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/
     * Given an array of n integers, find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time. If
     * there are multiple such triplets, then print any one of them.
     * 
     * Examples:
     * 
     * Input: arr[] = {12, 11, 10, 5, 6, 2, 30} Output: 5, 6, 30
     * 
     * Solution:
        1) Create an auxiliary array smaller[0..n-1]. smaller[i] should store the index of a number which is 
            smaller than arr[i] and is on left side of arr[i]. smaller[i] should contain -1 if there is no such element.
        2) Create another auxiliary array greater[0..n-1]. greater[i] should store the index of a number which 
            is greater than arr[i] and is on right side of arr[i]. greater[i] should contain -1 if there is no such element.
        3) Finally traverse both smaller[] and greater[] and find the index i for which both smaller[i] and greater[i] are not -1
    Considerations:
        There we are at arr[i] position, we need to be sure that element before arr[i] is less < arr[i] and element after arr[i] is larger than arr[i].
        so to keep it simple, we are using smaller[i] for 1st condition and greater[i] for 2nd condition for arr[i].
     */
    private void find3Numbers() {
        int arr[] = { 12, 11, 10, 5, 6, 2, 30 };
        find3Numbers( arr, arr.length );
    }

    private void find3Numbers( int[] arr, int n ) {
        int smaller[] = new int[n];
        int greater[] = new int[n];
        // Initialize with -1
        for ( int i = 0; i < n; i++ ) {
            smaller[i] = -1;
            greater[i] = -1;
        }

        int max = n - 1; // Index of maximum element from right side
        int min = 0; // Index of minimum element from left side
        for ( int i = 1; i < n; i++ ) {
            if ( arr[i] <= arr[min] ) {
                min = i;
                smaller[i] = -1;
            } else {
                smaller[i] = min;
            }
        }

        for ( int i = n - 2; i >= 0; i-- ) {
            if ( arr[i] >= arr[max] ) {
                max = i;
                greater[i] = -1;
            } else {
                greater[i] = max;
            }
        }

        for ( int i = 0; i < n; i++ ) {
            if ( smaller[i] != -1 && greater[i] != -1 ) {
                System.out.println( arr[smaller[i]] + ", " + arr[i] + ", " + arr[greater[i]] );
            }
        }
    }

}
