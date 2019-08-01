package algo.ds;

//import edu.princeton.cd.algs4.RedBlackBST;

public class MaximumOfSubArray {
    public static void main( String[] args ) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int n = arr.length;
        int k = 3;
        printKMax( arr, n, k );
    }

    // Use self-balancing BST - RedBlackBST
    private static void printKMax( int[] arr, int n, int k ) {
  /*
        1) Pick first k elements and create a Self-Balancing Binary Search Tree (BST) of size k.
        2) Run a loop for i = 0 to n – k
        …..a) Get the maximum element from the BST, and print it.
        …..b) Search for arr[i] in the BST and delete it from the BST.
        …..c) Insert arr[i+k] into the BST.
   */
    //    RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
        
    }
}
