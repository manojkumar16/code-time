package algo.ds;

import java.util.Scanner;

public class Solution2 {
    /* Write your custom functions here */
    static int diameterOfTree( Node root ) {
        /*
        * For your reference class Node { Node left, right; int data; Node(int newData) { left = right = null; data =
         * newData; } }
         */
         /* base case where tree is empty */
         if (root == null)
           return 0;
       
        /* get the height of left and right sub-trees */
        int lheight = height(root.left);
        int rheight = height(root.right);
       
        /* get the diameter of left and right sub-trees */
        int ldiameter = diameterOfTree(root.left);
        int rdiameter = diameterOfTree(root.right);
       
        /* Return max of following three
         1) Diameter of left subtree
         2) Diameter of right subtree
         3) Height of left subtree + height of right subtree + 1 */
        return max(lheight + rheight + 1, max(ldiameter, rdiameter));
    }

    public static int height(Node node)
    {
        if(node == null)
            return 0;
      
        /* If tree is not empty then height = 1 + max of left 
           height and right heights */   
        return 1 + max(height(node.left), height(node.right));
     }
    
    public static int max(int a, int b)
    {
      return (a >= b)? a: b;
    }
    
    public static void main( String[] args ) {
        Scanner in = new Scanner( System.in );
        Node _root;
        int root_i = 0, root_cnt = 0, root_num = 0;
        _root = null;
        int isBst = in.nextInt();
        root_cnt = in.nextInt();
        for ( root_i = 0; root_i < root_cnt; root_i++ ) {
            root_num = in.nextInt();
            if ( isBst == 0 ) {
                _root = addRandomElement( _root, root_num, root_i );
            } else {
                _root = insert( _root, root_num );
            }
        }
        System.out.println( diameterOfTree( _root ) );

        return;
    }

    private static class Node {
        Node left, right;

        int data;

        Node( int newData ) {
            left = right = null;
            data = newData;
        }
    }

    private static Node insert( Node node, int data ) {
        if ( node == null ) {
            node = new Node( data );
        } else {
            if ( data < node.data ) {
                node.left = insert( node.left, data );
            } else {
                node.right = insert( node.right, data );
            }
        }
        return ( node );
    }

    private static Node addRandomElement( Node node, int data, int index ) {
        if ( node == null ) {
            node = new Node( data );
        } else {
            if ( index <= 2 ) {
                node.left = addRandomElement( node.left, data, index );
            } else {
                node.right = addRandomElement( node.right, data, index );
            }

        }
        return ( node );
    }
}
