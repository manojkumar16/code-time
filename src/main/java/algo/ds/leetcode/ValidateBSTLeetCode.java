package algo.ds.leetcode;

import algo.ds.TreeNode;

/**
 * https://leetcode.com/articles/validate-binary-search-tree/
 * 
 * Approach 1: Recursion implementation
 * 
 * @author mk
 *
 */
public class ValidateBSTLeetCode {

    public static void main(String[] args) {
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(1);
        // root.right = new TreeNode(1);
        // TreeNode root = TreeNode.buildBST();
        // TreeNode root = TreeNode.buildSmallBST();
        TreeNode root = TreeNode.buildTree();
        System.out.println(new ValidateBSTLeetCode().isValidBST(root));
    }

    private boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        if (lower != null && node.val <= lower) {
            return false;
        }

        if (upper != null && node.val >= upper) {
            return false;
        }

        if (!helper(node.left, lower, node.val)) {
            return false;
        }

        if (!helper(node.right, node.val, upper)) {
            return false;
        }

        return true;
    }

}
