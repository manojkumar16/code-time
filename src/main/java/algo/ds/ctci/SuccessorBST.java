package algo.ds.ctci;

public class SuccessorBST {

	public static void main(String[] args) {
		SuccessorBST ob = new SuccessorBST();
		TreeNode n = ob.buildTree();
		TreeNode res = ob.inorderSucc(n.left);
		System.out.println(res.data);
	}

	TreeNode inorderSucc(TreeNode n) {
		if (n == null) {
			return null;
		}
		/* Found right children -> return leftmost node of right subtree. */
		if (n.right != null) {
			return leftMostChild(n.right);
		} else {
			TreeNode x = n.parent;
			while (x != null && x.data < n.data) {
				x = x.parent;
			}
			return x;
		}
	}

	private TreeNode leftMostChild(TreeNode n) {
		if (n == null) {
			return null;
		}
		while (n.left != null) {
			n = n.left;
		}
		return n;
	}

	private TreeNode buildTree() {
		TreeNode n = newNode(10, null);
		n.left = newNode(8, n);
		n.left.left = newNode(7, n.left);
		n.left.right = newNode(9, n.left);

		n.right = newNode(100, n);
		n.right.left = newNode(60, n.right);
		return n;
	}

	private TreeNode newNode(int d, TreeNode parent) {
		TreeNode n = new TreeNode(d, parent);
		return n;
	}

	private class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode parent;

		public TreeNode(int data, TreeNode parent) {
			this.data = data;
			this.parent = parent;
		}

	}
}
