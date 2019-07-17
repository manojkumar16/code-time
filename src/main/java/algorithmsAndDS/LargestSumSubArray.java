package algorithmsAndDS;

/*
 * Largest Sum Contiguous Subarray  [http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/]
 * Maximum subarray problem [http://en.wikipedia.org/wiki/Maximum_subarray_problem]
 *
 * Kadane’s Algorithm:
 * 
 * The maximum sum subarray problem is the task of finding the contiguous subarray within a one-dimensional array of numbers
 * which has the largest sum. For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; 
 * the contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.
 * 
  def max_subarray(A):
    max_ending_here = max_so_far = A[0]
    for x in A[1:]:
        max_ending_here = max(x, max_ending_here + x)
        max_so_far = max(max_so_far, max_ending_here)
    return max_so_far
 */
public class LargestSumSubArray {

    public static void main( String[] args ) {
        //int[] a = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
        new LargestSumSubArray().process( a );
    }

    private void process( int[] A ) {
        int max_ending_here = A[0];
        int max_so_far = A[0];
        for ( int i = 1; i < A.length; i++ ) {
            max_ending_here = max( A[i], max_ending_here + A[i] );
            max_so_far = max( max_so_far, max_ending_here );
        }

        System.out.println( max_so_far );
    }

    private int max( int x, int y ) {
        return x > y ? x : y;
    }
}
