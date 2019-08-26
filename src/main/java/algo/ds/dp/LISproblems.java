package algo.ds.dp;


public class LISproblems {

    public static void main( String[] args ) {
        new LISproblems().LIS();
    }

    /**
     * The longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given
     * sequence such that all elements of the subsequence are sorted in increasing order. For example, length of LIS for
     * { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}. 
     * { 8, 7, 5, 6, 10, 11, 12, 9 } is 5 and LIS Is {5,6,10,11,12}.
     * 
     * Ref: https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
     */
    private void LIS() {
       // int[] a = new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        // int[] a = new int[] {10, 11, 12, 9, 8, 7, 5, 6 };
        // int[] a = new int[] { 8, 7, 5, 6, 10, 11, 12, 9 };
        int[] a = new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
    		//int[]a = new int[] {3, 10, 2, 1, 20}; // 3
       // int[] a = new int[] {10,22,9,33,21,50,41,60,80};
        System.out.println( "DP - " + lisDP( a, a.length ) );
       // System.out.println( "Brute - " + lisBruteForce( a ) );
    }

    private int lisDP( int[] arr, int n ) {
        int i, j, max = 0;
        int[] lis = new int[n];
        // Initialize LIS values for all indexes
        for ( i = 0; i < n; i++ ) {
            lis[i] = 1;
        }
        // Compute optimized LIS values in bottom up manner
		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}
        // Pick maximum of all LIS values
        for ( i = 0; i < n; i++ ) {
            if ( max < lis[i] ) {
                max = lis[i];
            }
        }
        return max;
    }

    // { 8, 7, 5, 6, 10, 11, 12, 9 } is 5 and LIS Is {5,6,10,11,12}.
    //{ 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 }
    private int lisBruteForce( int[] a ) {
        int max = 0;
        int[] lis = new int[a.length];
        for ( int i = 0; i < a.length; i++ ) {
            lis[i] = 1;
        }

        for ( int i = 1; i < a.length; i++ ) {
            for ( int j = 0; j < i; j++ ) {
                if ( a[i] > a[j] ) {
                    lis[i] = 1 + max( lis, j, a, i );
                }
            }
        }

     // Pick maximum of all LIS values
        for ( int i = 0; i < a.length; i++ ) {
            if ( max < lis[i] ) {
                max = lis[i];
            }
        }
        return max;
    }

    private int max( int[] lis, int j, int[] a, int k ) {
        int m = 0;
        for ( int i = 0; i <= j; i++ ) {
            if ( m < lis[i] && a[k] > a[i]) {
                m = lis[i];
            }
        }
        return m;
    }
}
