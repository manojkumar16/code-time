package algo.ds;

public class BST {
    private static int total = 0;
    public static void main( String[] args ) {
        NewNode root = new NewNode( 20, null, null );

        // Left subtree
        root.left = new NewNode( 15, null, null );
        root.left.left = new NewNode( 10, null, null );
        root.left.right = new NewNode( 17, null, null );

        // Right subtree
        root.right = new NewNode( 25, null, null );
        root.right.left = new NewNode( 24, null, null );
        root.right.left.left = new NewNode( 23, null, null );
        root.right.right = new NewNode( 28, null, null );
        root.right.right.left = new NewNode( 26, null, null );
        root.right.right.left.right = new NewNode( 27, null, null );
        root.right.right.right = new NewNode( 29, null, null );
        root.right.right.right.right = new NewNode( 30, null, null );

        replaceNodeValue( root, 25 );
    }

    /**
     * Given a BST , replace a node value with the sum of all the elements larger than the current node.
     */
    private static void replaceNodeValue( NewNode root, int key ) {
        NewNode cur = root;
        while ( cur != null ) {
            if ( key > (Integer)cur.getNodeElement() ) {
                // Right subtree
                cur = cur.right;
            } else if ( key < (Integer)cur.getNodeElement() ) {
                // Left subtree
                cur = cur.left;
            } else {
                // This is the key
                getSum( cur.right );
                System.out.println(total);
                // Replace current node value with sum value
                cur.key = total;
            }
        }
    }

    private static void getSum( NewNode cur ) {
        if(cur!=null) {
            total = total + (Integer)cur.getNodeElement();
            getSum(cur.left);
            getSum( cur.right);
        }
    }

}
