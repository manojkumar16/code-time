package etc.one;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class TestMain2 {

	public static void main(String[] args) throws Exception {
		new TestMain2().start();

	}

	private void start() throws IOException {

		LNode root = buildTree();
		LNode t = newNode(12);

		insert(root, t);

		inorder(root);

		System.out.println("\n\n");
		for (int i = 0; i < 6; i++) {
			printLevelNode(root, i);
		}
	}

	private void inorder(LNode root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + "  ");
		inorder(root.right);

	}

	private void insert(LNode node, LNode t) {

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

	private void printLevelNode(LNode node, int level) {
		if (node == null) {
			return;
		}

		if (level == 0) {
			System.out.print(node.data + "  ");
		}
		printLevelNode(node.left, level - 1);
		printLevelNode(node.right, level - 1);
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
