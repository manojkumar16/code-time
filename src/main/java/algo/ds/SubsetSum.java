package algo.ds;

import java.util.Arrays;

/**
 * Backtracking Subset sum problem is to find subset of elements that are selected from a given set whose sum adds up to
 * a given number K. We are considering the set contains non-negative values. It is assumed that the input set is unique
 * (no duplicates are presented).
 * 
 * Algorithm:
 * if(subset is satisfying the constraint)
    print the subset
    exclude the current element and consider next element
else
    generate the nodes of present level along breadth of tree and
    recur for next levels
    
 * @author mkprasad
 * 
 * link: http://www.geeksforgeeks.org/backttracking-set-4-subset-sum/
 */
public class SubsetSum {

    public static void main( String[] args ) {
        SubsetSumExhaustive.start();
        System.out.println("------------------------------------------");
        /**
         * The power of backtracking appears when we combine explicit and implicit constraints, and we stop generating
         * nodes when these checks fail. We can improve the above algorithm by strengthening the constraint checks and
         * presorting the data. By sorting the initial array, we need not to consider rest of the array, once the sum so
         * far is greater than target number. We can backtrack and check other possibilities.
         * 
         * Similarly, assume the array is presorted and we found one subset. We can generate next node excluding the
         * present node only when inclusion of next node satisfies the constraints. Given below is optimized
         * implementation (it prunes the subtree if it is not satisfying contraints).
         */
        SubsetSumDP.start();
    }
}

class SubsetSumExhaustive {
    public static void start(){
        System.out.println("Exhaustive subset sum:");
        new SubsetSumExhaustive().exhaustiveSearchSubsetSum();
    }
    
    private void exhaustiveSearchSubsetSum() {
        int weights[] = { 10, 7, 5, 18, 12, 20, 15 };
        int[] tuplet_vector = new int[weights.length];
        subset_sum( weights, tuplet_vector, weights.length, 0, 0, 0, 35 );
    }

    /**
     * @param s         -   set vector
     * @param t         -   tuplet vector
     * @param s_size    -   set size
     * @param t_size    -   tuplet size so far
     * @param sum       -   sum so far
     * @param ite       -   nodes count
     * @param target_sum-   sum to be found
     */
    private void subset_sum( int[] s, int[] t, int s_size, int t_size, int sum, int ite, int target_sum ) {
        if ( target_sum == sum ) {
            // We found subset
            printSubset( t, t_size );

            // Exclude previously added item and consider next candidate
            if ( ite + 1 < s_size ) {
                subset_sum( s, t, s_size, t_size - 1, sum - s[ite], ite + 1, target_sum );
            }
            return;
        } else {
            // generate nodes along the breadth
            for ( int i = ite; i < s_size; i++ ) {
                t[t_size] = s[i];
                // consider next level node (along depth)
                subset_sum( s, t, s_size, t_size + 1, sum + s[i], i + 1, target_sum );
            }
        }
    }

    private void printSubset( int[] t, int t_size ) {
        for ( int i = 0; i < t_size; i++ ) {
            System.out.print( t[i] + ", " );
        }
        System.out.println();
    }
}


class SubsetSumDP {
    public static void start() {
        System.out.println("Optimized version of subset sum:");
        new SubsetSumDP().dpSubsetSum();
    }

    private void dpSubsetSum() {
        int weights[] = { 10, 7, 5, 18, 12, 20, 15 };
        int target_sum = 35;
        Arrays.sort( weights );
        int total = 0;
        for ( int i = 0; i < weights.length; i++ ) {
            total = total + weights[i];
        }

        if ( weights[0] <= target_sum && total >= target_sum ) {
            int[] tuplet_vector = new int[weights.length];
            subset_sum( weights, tuplet_vector, weights.length, 0, 0, 0, target_sum );
        }

    }

    /**
     * @param s - set vector
     * @param t - tuplet vector
     * @param s_size - set size
     * @param t_size - tuplet size so far
     * @param sum - sum so far
     * @param ite - nodes count
     * @param target_sum- sum to be found
     */
    private void subset_sum( int[] s, int[] t, int s_size, int t_size, int sum, int ite, int target_sum ) {
        if ( target_sum == sum ) {
            // we found sum
            printSubset( t, t_size );

            // Constraint check
            if ( ite + 1 < s_size && sum - s[ite] + s[ite + 1] <= target_sum ) {
                // Exclude previous added item and consider next candidate
                subset_sum( s, t, s_size, t_size - 1, sum - s[ite], ite + 1, target_sum );
            }
            return;
        } else {
            // Constraint check
            if ( ite < s_size && sum + s[ite] <= target_sum ) {
                // generate nodes along the breadth
                for ( int i = ite; i < s_size; i++ ) {
                    t[t_size] = s[i];
                    if ( sum + s[i] <= target_sum ) {
                        subset_sum( s, t, s_size, t_size + 1, sum + s[i], i + 1, target_sum );
                    }
                }
            }
        }
    }

    private void printSubset( int[] t, int t_size ) {
        for ( int i = 0; i < t_size; i++ ) {
            System.out.print( t[i] + ", " );
        }
        System.out.println();
    }
}


