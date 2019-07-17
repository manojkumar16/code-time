package algorithmsAndDS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
// http://www.geeksforgeeks.org/practice-questions-for-recursion-set-2/
// http://www.geeksforgeeks.org/data-structures-and-algorithms-set-1/
/**
 * 
 * 
 *         1
         /    \
        /       \
       2         3
     /   \     /   \
    4     5    6    7 
   / \     \       / \
  8   12    9     10  11
       \
       13
       /
      14 
Inorder:   8 4 12 14 13 2 5 9 1 6 3 10 7 11
Postorder: 8 14 13 12 4 9 5 2 6 10 11 7 3 1 
Preorder:  1 2 4 8 12 13 14 5 9 3 6 7 10 11

Preorder Tree traversal without recursion:
1) Create an empty stack S and push root node to stack.
2) Do following while S is not empty.
    a) Pop an item from stack and print it.
    b) Push right child of popped item to stack 
    c) Push left child of popped item to stack

==========================================================================

Postorder Tree traversal without recursion:
1. Push root to first stack.
2. Loop while first stack is not empty
   a) Pop a node from first stack and push it to second stack
   b) Push left and right children of the popped node to first stack
3. Print contents of second stack
==========================================================================
Inorder Tree Traversal without recursion and without stack:
1. Initialize current as root 
2. While current is not NULL
   If current does not have left child
      a) Print current’s data
      b) Go to the right, i.e., current = current->right
   Else
      a) Make current as right child of the rightmost node in current's left subtree
      b) Go to this left child, i.e., current = current->left
      

 */
public class BinaryTree<Key> {
    Stack<Node> stack = new Stack<Node>();
    
    public void start() {
        // Let us construct a binary tree
        Node root = newNode( 1 );
        root.left = newNode( 2 );
        root.right = newNode( 3 );
        root.left.left = newNode( 4 );
        root.left.right = newNode( 5 );
        root.right.left = newNode( 6 );
        root.right.right = newNode( 7 );
        root.left.left.left = newNode( 8 );
        root.left.left.right = newNode( 12 );
        root.left.left.right.right = newNode( 13 );
        root.left.left.right.right.left = newNode( 14 );
        root.left.right.right = newNode( 9 );
        root.right.right.left = newNode( 10 );
        root.right.right.right = newNode( 11 );

        System.out.println("\n===================================================================");
        InorderWithoutRecursion(root);
        System.out.println("\n===================================================================");
        PostorderWithoutRecursion(root);
        System.out.println("\n===================================================================");
        PreorderWithoutRecursion(root);
        System.out.println("\n===================================================================");
        
        // Print nodes at k distance from root
        System.out.print("Keys at a distance of 3 are:  ");
        printKDistance(root, 3);
        System.out.println("\n===================================================================");
        System.out.println( "\nFollowing are all keys and their ancestors\n" );
        for ( int key = 1; key <= 10; key++ ) {
            System.out.print( "key: " + key + " -> ");
            printAncestors( root, key );
            System.out.println();
        }
        System.out.println("\n===================================================================");
        int key = 13;
        int level = getLevelOfKey(root, key, 1);
        System.out.print( "Level of key " + key + ": " + level );
        
        System.out.println("\n===================================================================");
        // Check if a binary tree is subtree of another binary tree
        // Construct a subtree
        Node subtree = newNode( 7 );
        subtree.left = newNode(10);
        subtree.right = newNode(11);
        System.out.print( "Is tree a subtree of another binary tree : " + isSubtree( root, subtree ) );
        
        System.out.println("\n===================================================================");
        System.out.print("Befor mirror:    ");
        InorderWithoutRecursion( root );
        System.out.println();
        mirror(root);
        System.out.print("After mirror:    ");
        InorderWithoutRecursion( root );
        System.out.println();
        System.out.print("After re-mirror: ");
        mirror(root);
        InorderWithoutRecursion( root );
        System.out.println();
    
        System.out.println("\n===================================================================");
        System.out.println( "Size of tree : " + sizeOfTree( root ) );
        
        System.out.println("\n===================================================================");
        printPaths(root);
    }

    private void printPaths( Node root ) {
        List<Integer> ls = new ArrayList<Integer>();
        int path[] = new int[1000];

        printPathsRecursion(root, path, 0, ls);
    }

    private void printPathsRecursion( Node root, int[] path, int len, List<Integer> ls ) {
        if ( root == null )
            return;

        // Append this node to the path array
        path[len] = (Integer)root.key;
        ls.add( len, (Integer)root.key);
        len++;
        //ls.add( (Integer)root.key );

        if ( root.left == null && root.right == null ) {
            printList( path, len, ls );
            System.out.println();
        } else {
            printPathsRecursion( root.left, path, len, ls );
            System.out.println("MKPP - "+len+"  --  "+ls.size()+ "  key:"+(Integer)root.key);
            printPathsRecursion( root.right, path, len, ls );
        }
    
    }

    private void printList( int[] path, int len, List<Integer> ls ) {
        for ( int i = 0; i < len; i++ ) {
            System.out.print( path[i] + " " );
        }
        System.out.println();
        System.out.print( "ArrayList..." );
        for ( int i = 0; i < len; i++ )
            System.out.print( ls.get( i ) + " " );
        System.out.println( "\n" );
    }

    /*
    size(tree)
    1. If tree is empty then return 0
    2. Else
         (a) Get the size of left subtree recursively  i.e., call 
              size( tree->left-subtree)
         (a) Get the size of right subtree recursively  i.e., call 
              size( tree->right-subtree)
         (c) Calculate size of the tree as following:
                tree_size  =  size(left-subtree) + size(right-
                                   subtree) + 1
         (d) Return tree_size
    */     
    private int sizeOfTree( Node root ) {
        if ( root == null )
            return 0;
        else {
            return ( sizeOfTree( root.left ) + sizeOfTree( root.right ) + 1 );
        }
    }

    /**
     * change a tree so that the roles of the  left and 
     * right pointers are swapped at every node.
     */
    private void mirror( Node root ) {
        if ( root == null )
            return;
        else {
            // Do the subtree
            mirror(root.left);
            mirror(root.right);
            
            Node temp = new Node<Key>( null );
            temp = root.left;
            root.left = root.right;
            root.right = temp;
            
        }
    }

    /**
     * Traverse the tree root in preorder fashion. For every visited node in the traversal, 
     * see if the subtree rooted with this node is identical to S.
     */
    /* This function returns true if subtree is a subtree of root, otherwise false */
    private boolean isSubtree( Node root, Node subtree ) {
        if ( subtree == null )
            return true;
        if ( root == null )
            return false;

        if ( isIdentical( root, subtree ) )
            return true;

        /* If the tree with root as current node doesn't match then
        try left and right subtrees one by one */
        return isSubtree( root.left, subtree ) || isSubtree( root.right, subtree );

    }
    
    /* A utility function to check whether trees with roots as root1 and
    root2 are identical or not */
    /*
    sameTree(tree1, tree2)
    1. If both trees are empty then return 1.
    2. Else If both trees are non -empty
         (a) Check data of the root nodes (tree1->data ==  tree2->data)
         (b) Check left subtrees recursively  i.e., call sameTree( 
              tree1->left_subtree, tree2->left_subtree)
         (c) Check right subtrees recursively  i.e., call sameTree( 
              tree1->right_subtree, tree2->right_subtree)
         (d) If a,b and c are true then return 1.
    3  Else return 0 (one is empty and other is not)
      */  
    private boolean isIdentical(Node root1, Node root2) {
        if ( root1 == null && root2 == null )
            return true;
        if ( root1 == null || root2 == null )
            return false;

        /* Check if the data of both roots is same and data of left and right
        subtrees are also same */
        return ((Integer)root1.key == (Integer)root2.key) && isIdentical(root1.left, root2.left) && isIdentical( root1.right, root2.right );
    }

    /**
     * The idea is to start from the root and level as 1. If the key matches with root’s data, 
     * return level. Else recursively call for left and right subtrees with level as level + 1.
     */
    private int getLevelOfKey( Node root, int key, int level ) {
        if ( root == null ) return 0;
        if ( (Integer) root.key == key ) {
            return level;

        } else {
            return getLevelOfKey( root.left, key, level + 1 ) |
            getLevelOfKey( root.right, key, level + 1 );
        }
    }

    /*
    Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root.

    For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
                1
              /   \
            2      3
          /  \    /
        4     5  8 
      */  
    private void printKDistance( Node root, int k ) {

        if ( root == null || k < 0 )
            return;
        if ( k == 0 ) {
            System.out.print( root.key + "  " );
        } else {
            printKDistance( root.left, k - 1 );
            printKDistance( root.right, k - 1 );
        }
    }

    /**
    Preorder Tree traversal without recursion:
        1) Create an empty stack S and push root node to stack.
        2) Do following while S is not empty.
            a) Pop an item from stack and print it.
            b) Push right child of popped item to stack 
            c) Push left child of popped item to stack
     */
    private void PreorderWithoutRecursion( Node root ) {
        Stack<Node> st = new Stack<Node>();
        List<Node> ls = new ArrayList<Node>();
        st.push( root );
        while ( st.size() > 0 ) {
            Node t = st.pop();
            ls.add( t );
            if ( t.right != null )
                st.push( t.right );
            if ( t.left != null )
                st.push( t.left );
        }

        System.out.print( "Preorder  == " );
        for ( Node n : ls ) {
            System.out.print( n.key + "  " );
        }
    }

    private void PostorderWithoutRecursion( Node root ) {
        Stack<Node> reverseStack = new Stack<Node>();
        Stack<Node> st = new Stack<Node>();

        st.push( root );
        while ( st.size() > 0 ) {
            Node t = st.pop();
            reverseStack.push( t );
            if ( t.left != null )
                st.push( t.left );

            if ( t.right != null )
                st.push( t.right );
        }

        System.out.print( "Postorder == " );

        while ( reverseStack.size() > 0 ) {
            System.out.print( reverseStack.pop().key + "  " );
        }
    }

    private void InorderWithoutRecursion( Node root ) {
        List<Node> ls = new ArrayList<Node>();
        Stack<Node> st = new Stack<Node>();
        Node cur = root;
        boolean done = false;

        while ( !done ) {
            if ( cur != null ) {
                st.push( cur );
                cur = cur.left;
            } else if ( st.size() > 0 ) {
                Node t = st.pop();
                ls.add( t );
                cur = t.right;
            } else { // Stack is empty.
                done = true;
            }
        }
        System.out.print("Inorder   == ");
        for( Node n : ls) {
            System.out.print(n.key+"  ");
        }

    }

    /*
           1
         /    \
        /       \
       2         3
     /   \     /   \
    4     5    6    7 
   / \     \       / \
  8   12    9     10  11
  
  
 Input Key    List of Ancestors 
-------------------------
 1            
 2            1
 3            1
 4            2 1
 5            2 1
 6            3 1
 7            3 1
 8            4 2 1
 9            5 2 1
10            7 3 1

Postorder: 8 12 4 9 5 2 6 10 11 7 3 1

Postorder Tree traversal without recursion:
1. Push root to first stack.
2. Loop while first stack is not empty
   a) Pop a node from first stack and push it to second stack
   b) Push left and right children of the popped node to first stack
3. Print contents of second stack

It is clear that we need to use a stack based iterative traversal of the Binary Tree. The idea is to have all 
ancestors in stack when we reach the node with given key. Once we reach the key, all we have to do is, print 
contents of stack. How to get all ancestors in stack when we reach the given node? We can traverse all nodes 
in Postorder way. If we take a closer look at the recursive postorder traversal, we can easily observe that, 
when recursive function is called for a node, the recursion call stack contains ancestors of the node. So idea 
is do iterative Postorder traversal and stop the traversal when we reach the desired node.

     */
    private void printAncestors( Node root, int key ) {
        Stack<Node> st = new Stack<Node>();
        while ( true ) {
            // Traverse the left side. While traversing, push the nodes into
            // the stack so that their right subtrees can be traversed later
            while ( root != null && (Integer) root.key != key ) {
                st.push( root ); // push current node
                root = root.left; // move to next node
            }

            // If the node whose ancestors are to be printed is found,
            // then break the while loop.
            if ( root != null && (Integer) root.key == key )
                break;

            // Check if right sub-tree exists for the node at top
            // If not then pop that node because we don't need this
            // node any more.
            if ( st.peek().right == null ) {
                root = st.pop();

                // If the popped node is right child of top, then remove the top
                // as well. Left child of the top must have processed before.
                // Consider the following tree for example and key = 3.  If we
                // remove the following loop, the program will go in an
                // infinite loop after reaching 5.
                //          1
                //        /   \
                //       2     3
                //         \
                //           4
                //             \
                //              5
                while ( st.size() > 0 && st.peek().right == root )
                    root = st.pop();
            }

            // if stack is not empty then simply set the root as right child
            // of top and start traversing right sub-tree.
            root = st.size() == 0 ? null : st.peek().right;
        }

        // If stack is not empty, print contents of stack
        // Here assumption is that the key is there in tree
        while ( st.size() > 0 )
            System.out.print( st.pop().key + " " );
    }

    public static void main( String args[] ) {
        BinaryTree<Integer> obj = new BinaryTree<Integer>();
        obj.start();
    }

    private Node newNode( int i ) {
        Node n = new Node( i );
        n.left = null;
        n.right = null;
        return n;
    }

    private class Node<Key> {
        private Key key;
        private Node left, right; // left and right subtrees
        public Node( Key key ) {
            this.key = key;
        }
    }
}
