package algo.ds;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Given a binary tree and a key, insert the key into the binary tree at first
 * position available in level order.
 * 
 * Ref: https://www.geeksforgeeks.org/insertion-in-a-binary-tree-in-level-order/
 * 
 * @author m0k00i6
 *
 */
public class InsertNode {

	public static void main(String[] args) {
		new InsertNode().start();
	}

	boolean isAdded = false; // Used in Recursion
	
	private void start() {

		LNode root = buildTree();
		LNode t = newNode(12);

		printInorder(root);
		
		insertIterative(root, t);
		
		//insertRecursive(root, t);

		System.out.println("\n\n");
		printInorder(root);

	}

	/**
	 * Using Recursion
	 *
	 * @param node
	 * @param t
	 */
	private void insertRecursive(LNode node, LNode t) {
		if (node == null) {
			return;
		}
		if (node.left == null && !isAdded) {
			node.left = t;
			isAdded = true;
			return;
		} else if (node.right == null && !isAdded) {
			node.right = t;
			isAdded = true;
			return;
		}

		insertRecursive(node.left, t);
		insertRecursive(node.right, t);

	}

	/**
	 * Iterative approach
	 *
	 * 1. Perform Level Order traversal from Left to Right,
	 * 2. Insert node into Queue,
	 * 3. If left node of current node is NULL then Insert node here,
	 * 4. If right node of current node is NULL then Insert node here,
	 * 5. Else, put both left and right nodes into Queue and keep traversing.
	 * 
	 * @param node
	 * @param t
	 */
	private void insertIterative(LNode node, LNode t) {

		if (node == null) {
			return;
		}

		Queue<LNode> q = new LinkedBlockingDeque<>();
		q.add(node);

		while (!q.isEmpty()) {
			LNode n = q.poll();

			if (n.left == null) {
				n.left = t;
				break;
			} else if (n.right == null) {
				n.right = t;
				break;
			} else {
				q.add(n.left);
				q.add(n.right);
			}
		}
	}

	private LNode buildTree() {
		LNode n = newNode(10);
		n.left = newNode(11);
		n.left.left = newNode(7);

		n.right = newNode(9);
		n.right.left = newNode(15);
		n.right.right = newNode(8);
		return n;
	}

	private LNode newNode(int d) {
		LNode n = new LNode(d);
		return n;
	}

	private void printInorder(LNode root) {
		if (root == null) {
			return;
		}

		printInorder(root.left);
		System.out.print(root.data + "  ");
		printInorder(root.right);

	}

	private class LNode {
		int data;
		LNode left;
		LNode right;

		public LNode(int data) {
			super();
			this.data = data;
		}

	}
}
