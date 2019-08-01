package algo.ds;

public class Trying {

	public static void main(String[] args) {
		new Trying().start();

	}

	private void start() {
		// Node root = buildTree1();
		Node<Integer> root = buildTree2();

		int height = printHeight(root, 0);
		System.out.println(height);
		System.out.println("==========");
		for (int i = 1; i <= height; i++) {
			printGivenLevel(root, i);
			System.out.println();
		}
		
		System.out.println("==========");
		for (int i = 1; i <= height; i++) {
			printLeftView(root, i, false);
			System.out.println();
		}
	}

	private int printHeight(Node<Integer> root, int height) {
		if (root == null) {
			return height;
		}

		int leftHeight = printHeight(root.left, height + 1);
		int rightHeight = printHeight(root.right, height + 1);

		return leftHeight > rightHeight ? leftHeight : rightHeight;

	}

	private void printGivenLevel(Node root, int level) {
		if (root == null) {
			return;
		}

		if (level == 1) {
			System.out.print(root.data + "  ");
		}

		printGivenLevel(root.left, level - 1);
		printGivenLevel(root.right, level - 1);

	}

	private void printLeftView(Node<Integer> root, int level, boolean bprint) {
		if(root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(root.data + "  ");
		}

		printLeftView(root.left, level - 1, false);
		printLeftView(root.right, level - 1, false);
	}
	
	private Node buildTree1() {
		Node<Integer> root = new Node<>(1);
		root.right = newNode(3);
		root.right.left = newNode(6);
		root.right.right = newNode(7);
		return root;
	}

	private Node buildTree2() {
		Node<Integer> root = new Node<>(1);
		root.left = newNode(2);
		root.left.left = newNode(4);
		root.left.left.right = newNode(8);
		root.left.left.right.right = newNode(4);
		root.left.left.right.right.left = newNode(6);

		root.right = newNode(3);
		root.right.left = newNode(6);
		root.right.right = newNode(7);
		return root;
	}

	private class Node<T> {
		private T data;
		private Node<T> left, right; // Left and Right subtrees

		public Node(T data) {
			this.data = data;
		}
	}

	private Node<Integer> newNode(Integer data) {
		Node<Integer> node = new Node<>(data);
		node.left = null;
		node.right = null;
		return node;
	}
}
