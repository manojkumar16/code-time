package algo.ds;

/**
 * 
Foldable Binary Trees
Question: Given a binary tree, find out if the tree can be folded or not.
Ref: 
https://www.geeksforgeeks.org/foldable-binary-trees/
https://www.youtube.com/watch?v=9jH2L2Ysxko

A tree can be folded if left and right subtrees of the tree are structure wise mirror image of each other. An empty tree is considered as foldable.

Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.

(a)
       10
     /    \
    7      15
     \    /
      9  11

(b)
        10
       /  \
      7    15
     /      \
    9       11

(c)
        10
       /  \
      7   15
     /    /
    5   11

(d)

         10
       /   \
      7     15
    /  \    /
   9   10  12
   
    http://www.geeksforgeeks.org/foldable-binary-trees/
    *
 */
public class BinaryTreeFoldable {

    public static void main( String[] args ) {
        new BinaryTreeFoldable().process();

    }

    private void process() {
 /* The constructed binary tree is
        1
      /   \
     2     3
     \    /
      4  5
 */
        Node root = newNode(1);
        root.left        = newNode(2);
        root.right       = newNode(3);
        root.right.left  = newNode(4);
        root.left.right = newNode(5);
        
        if(isFoldable(root)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    /**
1) If tree is empty, then return true.
2) Convert the left subtree to its mirror image
    mirror(root->left);
3) Check if the structure of left subtree and right subtree is same
   and store the result.
    res = isStructSame(root->left, root->right); 
//isStructSame() recursively compares structures of two subtrees and returns true if structures are same 
4) Revert the changes made in step (2) to get the original tree.
    mirror(root->left);
5) Return result res stored in step 2.
     * 
     */
    private boolean isFoldable( Node root ) {
        boolean res = false;
        //base case
        if(root == null){
            return true;
        }
        
        //convert left subtree to its mirror
        mirror( root.left );

        /* Compare the structures of the right subtree and mirrored
          left subtree */
        res = isStructureSame(root.left, root.right);
        
        /* Get the original tree back */
        mirror(root.left);
        return res;
    }

    private boolean isStructureSame( Node a, Node b ) {
        if ( a == null && b == null ) {
            return true;
        }

        if ( a == null || b == null ) {
            return false;
        }

        if ( ( a != null && b != null ) && isStructureSame( a.left, b.left ) && isStructureSame( a.right, b.right ) ) {
            return true;
        }
        return false;
    }

    private void mirror( Node node ) {
        if(node == null) {
            return;
        }
        /* do the subtrees */
        mirror(node.left);
        mirror(node.right);
        
        /* swap the pointers in this node */
        Node t = node.left;
        node.left = node.right;
        node.right = t;
    }

    private Node newNode( int item ) {
        Node n = new Node();
        n.data = item;
        return n;
    }

    private class Node {
        int data;

        Node left, right;
    }
}
