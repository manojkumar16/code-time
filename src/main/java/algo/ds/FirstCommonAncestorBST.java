package algo.ds;

/**
 * Design an algorithm and write code to find the first common ancestor of two
 * nodes in a binary search tree.
 * 
 * @author m0k00i6
 *
 */
public class FirstCommonAncestorBST {

	public static void main(String[] args) {
		new FirstCommonAncestorBST().start();

	}

	private void start() {
		TreeNode node = buildTree2();
		TreeNode anc = ancestor(node, 5, 10);
		System.out.println("Ancestor node is: " + anc.d);
	}

	private TreeNode ancestor(TreeNode node, int i, int j) {
		if (node == null) {
			return null;
		}

		if (node.d > i && node.d < j) {
			return node;
		}

		TreeNode nleft = ancestor(node.l, i, j);
		TreeNode nright = ancestor(node.r, i, j);

		return nleft == null ? nright : nleft;

	}

	// Ancestor node is 100 for 70, 110
	private TreeNode buildTree1() {
		TreeNode n = newNode(10);
		n.l = newNode(8);
		n.l.l = newNode(7);
		n.l.r = newNode(9);

		n.r = newNode(100);
		n.r.l = newNode(60);
		n.r.l.r = newNode(70);
		n.r.r = newNode(110);
		return n;
	}

	// Ancestor node is 6 for 5,10
	// Ancestor node is 43 for 31, 49
	private TreeNode buildTree2() {
		TreeNode n = newNode(11);
		n.l = newNode(6);
		n.l.l = newNode(4);

		n.l.r = newNode(8);
		n.l.r.r = newNode(10);

		n.r = newNode(19);
		n.r.r = newNode(43);
		n.r.r.r = newNode(49);
		n.r.l = newNode(17);
		n.r.r.l = newNode(31);

		return n;
	}

	private TreeNode newNode(int d) {
		TreeNode n = new TreeNode(d);
		return n;
	}

	private class TreeNode {
		int d;
		TreeNode l;
		TreeNode r;

		public TreeNode(int data) {
			this.d = data;
		}

	}
}
