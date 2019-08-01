package algo.ds;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

// http://www.geeksforgeeks.org/level-order-tree-traversal/
public class LevelOrderTreeTraversal {
    public static void main( String[] args ) {
        tnode root = createTree();
        System.out.println( "Level Order traversal of binary tree" );
        printLevelOrderUsingRecursion( root );
        // printLevelOrderUsingQueueBFS(root);
    }

    private static void printLevelOrderUsingQueueBFS( tnode root ) {
        Queue<tnode> q = new LinkedBlockingDeque<tnode>();
        q.add( root );
        while ( !q.isEmpty() ) {
            tnode node = q.poll();
            System.out.print( node.data + ", " );
            tnode left = node.left;
            tnode right = node.right;
            if ( left != null ) {
                q.add( left );
            }
            if ( right != null ) {
                q.add( right );
            }
        }
    }

    /* Function to print level order traversal a tree */
    private static void printLevelOrderUsingRecursion( tnode root ) {
        int h = height( root );
        System.out.println( "Height of tree : " + h );
        for ( int i = 1; i <= h; i++ ) {
            System.out.print( "Node at level " + i + " : " );
            printGivenLevel( root, i );
            System.out.println();
        }
    }

    /* Print nodes at a given level */
    private static void printGivenLevel( tnode root, int level ) {
        if ( root == null ) {
            return;
        }
        if ( level == 1 ) {
            System.out.print( root.data + " " );
        } else if ( level > 1 ) {
            printGivenLevel( root.left, level - 1 );
            printGivenLevel( root.right, level - 1 );
        }

    }

    /*
     * Compute the "height" of a tree -- the number of nodes along the longest path from the root node down to the
     * farthest leaf node.
     */
    private static int height( tnode root ) {
        if ( root == null ) {
            return 0;
        }
        /* compute the height of each subtree */
        int lheight = height( root.left );
        int rheight = height( root.right );
        /* use the larger one */
        if ( lheight > rheight ) {
            return lheight + 1;
        } else {
            return rheight + 1;
        }
    }

    private static tnode createTree() {
        tnode root = newNode( 1 );
        root.left = newNode( 2 );
        root.right = newNode( 3 );
        root.left.left = newNode( 4 );
        root.left.right = newNode( 5 );
        root.right.left = newNode( 6 );
        root.right.right = newNode( 7 );
        root.right.right.right = newNode( 8 );
        return root;
    }

    public static tnode newNode( int data ) {
        tnode t = new tnode();
        t.data = data;
        return t;
    }
}

class tnode {
    int data;

    tnode left;

    tnode right;

    @Override
    public boolean equals( Object o ) {
        return data == ( (tnode) o ).data;
    }
}
