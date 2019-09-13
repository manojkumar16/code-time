package algo.ds;

/*
 * Convert a Binary Tree into its Mirror Tree
 * 
 *  Change a tree so that the roles of the  left and 
    right pointers are swapped at every node.
 
 So the tree...
       4
      / \
     2   5
    / \
   1   3
 
 is changed to...
       4
      / \
     5   2
        / \
       3   1
 */
public class MirrorBinayTree {
	public void mirror(Node root) {
		if (root == null) {
			return;
		}
		mirror(root.left);
		mirror(root.right);

		Node temp = root.left;
		root.left = root.right;
		root.right = temp;

	}
    
    public static void main( String[] args ) {
        new MirrorBinayTree().process();
    }
    private void process() {
/*        Node root = newNode( 4 );
        root.left = newNode( 2 );
        root.right = newNode( 5 );
        root.left.left = newNode( 1 );
        root.left.right = newNode( 3 );*/
        
        Node root = newNode(1);
        root.left        = newNode(2);
        root.right       = newNode(3);
        root.left.left  = newNode(4);
        root.left.right = newNode(5); 
        
        /* Print inorder traversal of the input tree */
        System.out.print( "Inorder traversal of the constructed tree is: " );
        inOrder( root );

        /* Convert tree to its mirror */
        mirror( root );

        /* Print inorder traversal of the mirror tree */
        System.out.print( "\nInorder traversal of the mirror tree is: " );
        inOrder( root );
    }

    /*
     * Helper function to test mirror(). Given a binary search tree, print out its data elements in increasing sorted
     * order.
     */
    private void inOrder( Node root ) {
        if ( root == null ) {
            return;
        }

        inOrder( root.left );
        System.out.print( root.data +" ");
        inOrder( root.right );
    }

    private class Node {
        int data;
        Node left,right;
    }
    private Node newNode(int item){
        Node n = new Node();
        n.data = item;
        return n;
    }
}
