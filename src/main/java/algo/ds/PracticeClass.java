package algo.ds;

import java.util.HashMap;
import java.util.Map;

public class PracticeClass {

    public static void main(String[] args) {
        System.out.println("Hello world");
        PracticeClass ob = new PracticeClass();
        TreeNode root = ob.buildTree();

        printLeaves(root);
    }

    private static void printLeaves(TreeNode root) {
        Map<Integer, Boolean> visited = new HashMap<>();

        visited.put(root.data, true);

        dfs(root, visited);

    }

    private static void dfs(TreeNode root, Map<Integer, Boolean> visited) {
        if (root.left != null) {
            visited.put(root.left.data, true);
            dfs(root.left, visited);
        }
        if (root.right != null) {
            visited.put(root.right.data, true);
            dfs(root.right, visited);
        } 

        if(root.left == null && root.right == null){
            System.out.print(root.data + "  ");
            return;
        }
    }

    /**
     * 3 20 9 15 7 8 6 17 11
     * 
     * 3 --- 0
     * / \
     * 9 20 --- 1
     * / \
     * 15 7 --- 2
     * / \ / \
     * 11 17 6 8 --- 3
     * 
     * @return
     */
    private TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.left.left = new TreeNode(11);
        root.left.left.right = new TreeNode(17);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(8);

        return root;
    }

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

}
