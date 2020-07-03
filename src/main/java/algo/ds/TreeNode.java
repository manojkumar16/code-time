package algo.ds;

/**
 * Sample Binary Tree structure
 * @author mk
 *
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int v) {
        this.val = v;
    }

    public TreeNode(int v, TreeNode l, TreeNode r) {
        this.val = v;
        this.left = l;
        this.right = r;
    }

    private static TreeNode newNode(int i) {
        TreeNode n = new TreeNode(i);
        n.left = null;
        n.right = null;
        return n;
    }

    /**
           1
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
      
     * @return
     */
    public static TreeNode buildTree() {
        TreeNode root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.left.left.left = newNode(8);
        root.left.left.right = newNode(12);
        root.left.left.right.right = newNode(13);
        root.left.left.right.right.left = newNode(14);
        root.left.right.right = newNode(9);
        root.right.right.left = newNode(10);
        root.right.right.right = newNode(11);

        return root;
    }
    
    /**
           10
         /    \
        /       \
       8         17
     /   \         \
    4     9         27 
 
     * @return
     */
    public static TreeNode buildBST() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(9);
        
        root.right = new TreeNode(17);
        root.right.right = new TreeNode(27);
        return root;
    }
    
    public static TreeNode buildSmallBST() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        return root;
    }
}
