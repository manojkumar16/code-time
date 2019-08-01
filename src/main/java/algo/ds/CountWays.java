package algo.ds;

/**
 * Q. A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 * 
 * S: We can approach this problem from the top down. On the very last hop, up to the nth step, the child could have
 * done either a single, double, or triple step hop.That is, the last move might have been a single step hop from step
 * n-1, a double step hop from step n-2, or a triple step hop from n-3.The total number of ways of reaching the last
 * step is therefore the sum of the number of ways of reaching each of the last three steps.
 * 
 * Ref: http://littletechnical.blogspot.in/2013/06/staircase-with-n-steps-problems.html
 */
public class CountWays {

    public static void main( String[] args ) {
        // Regardless of whether or not you use dynamic programming, note that the number of
        // ways will quickly overflow the bounds of an integer. By the time you get to just n = 37,
        // the result has already overflowed. Using a long will delay, but not completely solve,
        // this issue.
        int n = 4;
        // int ways = countWays(n);
        int ways = countWaysDP( n, new int[n + 1] );
        System.out.println( ways );
    }

    private static int countWaysDP( int n, int[] cache ) {
        if ( n < 0 )
            return 0;
        else if ( n == 0 )
            return 1;
        else if ( cache[n] > 0 )
            return cache[n];
        else {
            cache[n] = countWaysDP( n - 1, cache ) + countWaysDP( n - 2, cache ) + countWaysDP( n - 3, cache );
            return cache[n];
        }
    }

    private static int countWays( int n ) {
        if ( n < 0 )
            return 0;
        else if ( n == 0 )
            return 1;
        else {
            return countWays( n - 1 ) + countWays( n - 2 ) + countWays( n - 3 );
        }
    }

}
