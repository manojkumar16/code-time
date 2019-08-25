package algo.ds.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * @author m0k00i6
 *
 */
public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		BinaryTreeInorderTraversal ob = new BinaryTreeInorderTraversal();

		TreeNode root = ob.buildTree();
		System.out.println(ob.inorderTraversalIterative(root));
		// System.out.println(ob.inorderTraversalRecursive(root));
	}

	private List<Integer> inorderTraversalIterative(TreeNode root) {
		List<Integer> r = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		TreeNode cur = root;

		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.add(cur);
				cur = cur.left;
			}

			cur = stack.pop();

			r.add(cur.val);
			cur = cur.right;
		}

		return r;
	}

	public List<Integer> inorderTraversalRecursive(TreeNode root) {

		List<Integer> res = new ArrayList<>();
		inorderTraversalUtil(root, res);

		return res;
	}

	private void inorderTraversalUtil(TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		inorderTraversalUtil(root.left, result);
		result.add(root.val);
		inorderTraversalUtil(root.right, result);
	}

	private TreeNode buildTree() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
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
