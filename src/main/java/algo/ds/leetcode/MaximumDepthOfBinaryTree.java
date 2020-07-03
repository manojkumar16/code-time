package algo.ds.leetcode;

import algo.ds.TreeNode;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/555/
 * 
 * @author mk
 *
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree();
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(root));;
    }

    public int maxDepth(TreeNode root) {

        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int level) {
        if (root == null) {
            return level;
        } else {
            return Integer.max(maxDepth(root.left, level + 1), maxDepth(root.right, level + 1));
        }
    }

}
