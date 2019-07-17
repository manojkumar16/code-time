package algorithmsAndDS;

/**
 * https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
 * 
 * @author m0k00i6
 *
 */
public class BinaryTree_LeftView {

	public static void main(String[] args) {
		BinaryTree_LeftView ob = new BinaryTree_LeftView();
		ob.buildTree1();
		System.out.println("\n=======");
		ob.buildTree2();
		System.out.println("\n=======");
		ob.buildTree3();
	}

	private void leftView(Node root, Integer level, Holder maxLevel) {
		if (root == null) { // Base case
			return;
		}

		if (maxLevel.get() < level) {
			System.out.print(root.data);
			System.out.print(" ");
			maxLevel.set(level);
		}

		leftView(root.left, level + 1, maxLevel);
		leftView(root.right, level + 1, maxLevel);
	}

	private Node newNode(int data) {
		Node n = new Node(data);
		n.left = null;
		n.right = null;
		return n;
	}

	private class Node<Key> {
		private Key data;
		private Node left, right; // left and right subtrees

		public Node(Key key) {
			this.data = key;
		}
	}

	private void buildTree3() {
		Node<Integer> root = newNode(1);

		root.left = newNode(2);
		root.right = newNode(3);
		root.left.left = newNode(4);
		root.left.right = newNode(5);
		root.left.right.left = newNode(6);

		Holder maxLevel = new Holder(0);
		Integer level = new Integer(1);
		leftView(root, level, maxLevel);
	}

	private void buildTree2() {
		Node root = newNode(1);

		root.right = newNode(2);
		root.right.right = newNode(3);
		root.right.right.left = newNode(4);
		root.right.right.right = newNode(5);

		Holder maxLevel = new Holder(0);
		Integer level = new Integer(1);
		leftView(root, level, maxLevel);
	}

	private void buildTree1() {
		Node root = newNode(10);
		root.left = newNode(20);
		root.right = newNode(30);
		root.left.left = newNode(40);
		root.left.right = newNode(60);

		Holder maxLevel = new Holder(0);
		Integer level = new Integer(1);
		leftView(root, level, maxLevel);
	}

	private class Holder {
		private int data;

		public Holder(int data) {
			data = data;
		}

		public int get() {
			return data;
		}

		public void set(int data) {
			this.data = data;
		}
	}
}
