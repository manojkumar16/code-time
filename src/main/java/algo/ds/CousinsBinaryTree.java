package algo.ds;

/**
 *Check if two nodes are cousins in a Binary Tree
Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.

Two nodes are cousins of each other if they are at same level and have different parents.

Example

     6
   /   \
  3     5
 / \   / \
7   8 1   3
Say two node be 7 and 1, result is TRUE.
Say two nodes are 3 and 5, result is FALSE.
Say two nodes are 7 and 5, result is FALSE.

 http://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/
 *
 */
public class CousinsBinaryTree {

    public static void main( String[] args ) {

        new CousinsBinaryTree().process();
    }

    private void process() {
        Node root = newNode( 1 );
        root.left = newNode( 2 );
        root.right = newNode( 3 );
        root.left.left = newNode( 4 );
        root.left.right = newNode( 5 );
        root.left.right.right = newNode( 15 );
        root.right.left = newNode( 6 );
        root.right.right = newNode( 7 );
        root.right.left.right = newNode( 8 );

        Node n1 = root.left.left;
        Node n2 = root.right.right;
        if ( isCousin( root, n1, n2 ) ) {
            System.out.println( "Yes" );
        } else {
            System.out.println( "No" );
        }        
    }

    public boolean isCousin( Node root, Node a, Node b ) {
        if ( level( root, a,1 ) == level( root, b,1 ) && !isSibling( root, a, b ) ) {
            return true;
        }
        return false;
    }

    private boolean isSibling( Node root, Node a, Node b ) {
        // base case
        if ( root == null )
            return false;

        if ( ( root.left == a && root.right == b ) || ( root.left == b && root.right == b ) ) {
            return true;
        }
        return isSibling( root.left, a, b ) || isSibling( root.right, a, b );
    }

    private int level( Node root, Node key, int lvl ) {
        // base cases
        if ( root == null ) {
            return 0;
        }
        if ( root == key ) {
            return lvl;
        }

        int level = level( root.left, key, lvl + 1 );
        if ( level != 0 )
            return level;

        //else search in right subtree
        return level( root.right, key, lvl + 1 );

    }
    private Node newNode(int item) {
        Node n = new Node();
        n.data = item;
        return n;
    }    
    private class Node {
        int data;
        Node left,right;
    }
}



