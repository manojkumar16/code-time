package algo.ds;

/**
 * Given an input array of integers where each integer represent the maximum amount of jump a frog 
 * can take.Frog has to reach the end of the array in minimum number of jumps. 
 * Example:[1 5 4 6 9 3 0 0 1 3] answer is 3 for this. [2 8 3 6 9 3 0 0 1 3] answer is 2 for this.
 * 
 * @author mkprasad
 * 
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * 
 */
public class FrogJump {

    private static final int INT_MAX = Integer.MAX_VALUE;

    public static void main( String[] args ) {
        // int[] arr = new int[] { 1, 5, 4, 4, 9, 3, 4, 0, 1, 3 };
        //int[] arr = new int[] {1, 5, 4, 6, 9, 3, 0, 0, 1, 3};
        //int[] arr = new int[]{2, 8, 3 ,6, 9, 3, 0, 0, 1, 3};
        //int[] arr = new int[]{1, 5, 4, 6, 9, 3, 0, 0, 1, 3, 1,3};
        int[] arr = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        
        System.out.println(minJumps(arr, arr.length) + " hops.");
        System.out.println(jumpfrog(arr) + " hops.");
    }

    /**
     * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/#
     * 
     * we build a jumps[] array from left to right such that jumps[i] indicates the minimum number of jumps needed to
     * reach arr[i] from arr[0]. Finally, we print jumps[n-1].
     * 
     * @param arr
     * @param length
     */
    private static int minJumps( int[] arr, int n ) {
        int []jumps = new int[n];  // jumps[n-1] will hold the result
     
        if (n == 0 || arr[0] == 0)
            return INT_MAX;
     
        jumps[0] = 0;
     
        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (int i = 1; i < n; i++)
        {
            jumps[i] = INT_MAX;
            for (int j = 0; j < i; j++)
            {
                if (i <= j + arr[j] && jumps[j] != INT_MAX)
                {
                     jumps[i] = jumps[j] + 1;
                     break;
                }
            }
        }
        return jumps[n-1];
    }

    /**
     * The second approach is to use BFS with weighted graph, where node value is current index of array, and value is weighted edge.
     * say we have an array { 1, 5, 4, 4, 9, 3, 4, 0, 1, 3 }. If current index is 2, then node value will be '2'(index), and total number of
     * outgoing nodes will be '4' (value at arr[2]). Weight of each edge will start from 1 to 4. And value of each weight will allow frog to
     * jump from current index to [index + weight]. Here, 
     * weight 1 will take frog from index 2 to index 3.
     * weight 2 will take frog from index 2 to index 4.
     * weight 3 will take frog from index 2 to index 5. etc...
     * @param arr 
     */
    private static int jumpfrog(int[] arr) {

        int count = 0;
        int jumpcountInd = 0;
        int jump = 0;

        /**
         * 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9
         */
        for ( int i = 0; i < arr.length - 1; i++ ) {
            // Frog can reach to the end in one shot, If frog current jump value is crossing total array length.
            if ( ( arr[jump] + i ) >= arr.length ) {
                // we found solution. return count;
                return count+1;
            }
            
            if ( arr[i] > arr[jump] && jumpcountInd <= arr[jump] ) { // If current index value is greater than 
                //stored previous jump value, then set new jump index. And also keep checking that frog should not jump more than last jump value set.
                jump = i;
                jumpcountInd = 1;
                count++;
            } else if ( jumpcountInd > arr[jump] ) { // if last jump value set is reached then reset this value to 1;
                jumpcountInd = 1;
            } else { // If none of the above criteria meets, it means frog is jumping by one every time
                jumpcountInd++;
            }
        }

        return count;
    }

}
