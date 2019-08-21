package algo.ds.ctci;

/**
 * Implement a function to check if a binary tree is a binary search tree
 * Approach: Min/Max
 *
 * @author m0k00i6
 *
 */
public class ValidateBST {

	public static void main(String[] args) {
		new ValidateBST().start();
	}

	private void start() {
		Node root = buildTree2();
		boolean isBST = checkBST(root, null, null);
		System.out.println(isBST);
	}

	// Traverse inorder and validate if 
	private boolean checkBST(Node n, Integer min, Integer max) {
		if (n == null) {
			return true;
		}

		if( (min != null && min >= n.data) || (max != null && max < n.data)) {
			return false;
		}

		return checkBST(n.left, min, n.data) && checkBST(n.right, n.data, max);
	}

	// NOT BST
	private Node buildTree1() {
		Node n = newNode(10);
		n.left = newNode(11);
		n.left.left = newNode(7);

		n.right = newNode(9);
		n.right.left = newNode(15);
		n.right.right = newNode(8);
		return n;
	}

	// It is BST
	private Node buildTree2() {
		Node n = newNode(10);
		n.left = newNode(8);
		n.left.right = newNode(9);

		n.right = newNode(15);
		n.right.left = newNode(13);
		n.right.right = newNode(17);
		return n;
	}

	// NOT BST
	private Node buildTree3() {
		Node n = newNode(10);
		n.left = newNode(8);
		n.left.right = newNode(11);

		n.right = newNode(15);
		n.right.left = newNode(13);
		n.right.right = newNode(17);
		return n;
	}

	private Node newNode(int d) {
		Node n = new Node(d);
		return n;
	}

	private class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			super();
			this.data = data;
		}

	}
}
