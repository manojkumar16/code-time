package algo.ds.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/625/
 * Inorder traversal implementation
 * 
 * @author mk
 *
 */
public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		ValidateBinarySearchTree ob = new ValidateBinarySearchTree();
		TreeNode root = ob.buildTree();
		System.out.println(ob.isValidBST(root));
	}

	private boolean isValidBST(TreeNode root) {

		List<Integer> inorder = new ArrayList<>();
		isValidBSTUtil(root, inorder);

		if (inorder.size() == 1) {
			return true;
		}

		for (int i = 0; i < inorder.size() - 1; i++) {
			if (inorder.get(i) > inorder.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	private void isValidBSTUtil(TreeNode root, List<Integer> inorder) {
		if (root == null) {
			return;
		}
		isValidBSTUtil(root.left, inorder);
		inorder.add(root.val);
		isValidBSTUtil(root.right, inorder);
	}

	private TreeNode buildTree() {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		return root;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
