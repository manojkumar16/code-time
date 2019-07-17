package algorithmsAndDS;

/**
 * Majority Element: A majority element in an array A[] of size n is an element that appears more than n/2 times (and
 * hence there is at most one such element).
 * 
 * Write a function which takes an array and emits the majority element (if it exists), otherwise prints NONE as
 * follows:
 * 
 * I/P : 3 3 4 2 4 4 2 4 4 O/P : 4
 * 
 * I/P : 3 3 4 2 4 4 2 4 O/P : NONE
 * 
 * http://www.geeksforgeeks.org/majority-element/
 * 
 * @author mkprasad
 * 
 */
public class MajorityElementMooreVoting {

    public static void main( String[] args ) {
        new MajorityElementMooreVoting().start();
    }

    /**
     * METHOD 1 (Basic) The basic solution is to have two loops and keep track of maximum count for all different
     * elements. If maximum count becomes greater than n/2 then break the loops and return the element having maximum
     * count. If maximum count doesn’t become more than n/2 then majority element doesn’t exist.
     * 
     * Time Complexity: O(n*n). Auxiliary Space : O(1).
     * 
     * 
     * 
     * METHOD 2 (Using Binary Search Tree)
     * 
     * Node of the Binary Search Tree (used in this approach) will be as follows.
     * 
     * struct tree { int element; int count; }BST; Insert elements in BST one by one and if an element is already
     * present then increment the count of the node. At any stage, if count of a node becomes more than n/2 then return.
     * The method works well for the cases where n/2+1 occurrences of the majority element is present in the starting of
     * the array, for example {1, 1, 1, 1, 1, 2, 3, 4}.
     * 
     * Time Complexity: If a binary search tree is used then time complexity will be O(n^2). If a
     * self-balancing-binary-search tree is used then O(nlogn) Auxiliary Space: O(n)
     * 
     * 
     * 
     * METHOD 3 (Using Moore’s Voting Algorithm)
     * 
     * This is a two step process. 
     * 1. Get an element occurring most of the time in the array. This phase will make sure
     *      that if there is a majority element then it will return that only. 
     * 2. Check if the element obtained from above
     *      step is majority element.
     * 
     * 1. Finding a Candidate: The algorithm for first phase that works in O(n) is known as Moore’s Voting Algorithm.
     * Basic idea of the algorithm is if we cancel out each occurrence of an element e with all the other elements that
     * are different from e then e will exist till end if it is a majority element.
     * 
     *
findCandidate(a[], size)
1.  Initialize index and count of majority element
     maj_index = 0, count = 1
2.  Loop for i = 1 to size – 1
    [ If a[maj_index] == a[i]
            count++
       Else
        count--;
     If count == 0
        maj_index = i;
        count = 1
    ]
3.  Return a[maj_index]
     */
    private void start() {
        int[] a = new int[] { 3, 3, 4, 2, 4, 4, 2, 4, 4, };
       // int[] a = new int[] {3, 3, 4, 2, 4, 4, 2, 4};
      //  int[] a = new int[]{1, 3, 3, 1, 2};
        int candidate = findCandidate( a, a.length );
        System.out.println( isMajority(candidate, a) == true ? "Majority element is " + candidate : "There is no majority element." );
    }

    private int findCandidate( int[] a, int length ) {
        int maj_index = 0;
        int count = 1;
        for ( int i = 1; i < length - 1; i++ ) {
            if ( a[maj_index] == a[i] ) {
                count++;
            } else {
                count--;
            }

            if ( count == 0 ) {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    private boolean isMajority( int candidate, int[] a ) {
        int count = 0;
        for ( int i = 0; i < a.length; i++ ) {
            if ( a[i] == candidate ) {
                count++;
            }
        }
        if ( count > a.length / 2 ) {
            return true;
        }
        return false;
    }
    
}
