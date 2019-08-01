package algo.ds;

// WRONG
public class BinarySearchTreeProblems {

    public static void main( String[] args ) {
        buildMinimumHeight();
    }

    /**
     * You are given a sorted skewed binary tree. How can you create a binary search tree of minimum height from it?
     */
    private static void buildMinimumHeight() {
        int arr[] = { 4, 5, 6, 7, 8, 9, 10 };
        int mid = arr.length / 2;
        NewNode root = new NewNode( arr[mid] );
        NewNode head = minimumHeightTree( root, arr, mid, 0, arr.length - 1 );
        inorder( head );
    }

    private static void inorder( NewNode head ) {
        if ( head == null ) {
            return;
        }
        inorder( head.left );
        System.out.print( head.key + "  " );
        inorder( head.right );
    }

    private static NewNode minimumHeightTree( NewNode root, int[] arr, int mid, int start, int end ) {
        if ( mid <= start ) {
            return root;
        }

        root.left = minimumHeightTree( new NewNode( arr[( mid + start - 1 ) / 2] ), arr, ( mid + start - 1 ) / 2,
            start, mid - 1 );
        root.right = minimumHeightTree( new NewNode( arr[( mid + end - 1 ) / 2] ), arr, ( mid + end - 1 ) / 2,
            mid + 1, end );
/*        root.left = minimumHeightTree( new NewNode( arr[( mid - start - 1 ) / 2] ), arr, ( mid - start - 1 ) / 2,
            start, mid - 1 );
        root.right = minimumHeightTree( new NewNode( arr[( mid + end + 1 ) / 2] ), arr, ( mid + end + 1 ) / 2,
            mid + 1, end );*/

        return root;
    }
}
