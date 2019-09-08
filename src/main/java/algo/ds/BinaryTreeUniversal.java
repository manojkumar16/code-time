package algo.ds;

/**
 * 
 * https://www.dailycodingproblem.com/blog/unival-trees/
 * 
 * https://www.youtube.com/watch?v=7HgsS8bRvjo
 * https://www.youtube.com/watch?v=BkUEFJZpZRw
 * 
 * @author m0k00i6
 *
 */
public class BinaryTreeUniversal {

	public static void main(String[] args) {
		new BinaryTreeUniversal().start();
	}

	private void start() {

		Node tree = buildTree1();

		boolean isUnival = isUniversal(tree);

		System.out.println(isUnival);
	}

	private boolean isUniversal(Node node) {

		if (node == null) {
			return true;
		}

		if (node.left != null && node.data != node.left.data) {
			return false;
		}

		if (node.right != null && node.data != node.right.data) {
			return false;
		}

		return isUniversal(node.left) && isUniversal(node.right);

	}

	/**
	 * Not Universal
	 * 
	 * @return
	 */
	private Node buildTree1() {
		Node n = newNode(10);
		n.left = newNode(10);
		n.left.left = newNode(10);

		n.right = newNode(9);
		n.right.left = newNode(15);
		n.right.right = newNode(8);
		return n;
	}

	/**
	 * Universal
	 * 
	 * @return
	 */
	private Node buildTree2() {
		Node n = newNode(10);
		n.left = newNode(10);
		n.left.left = newNode(10);

		n.right = newNode(10);
		n.right.left = newNode(10);
		n.right.right = newNode(10);
		return n;
	}

	private Node newNode(int item) {
		Node n = new Node();
		n.data = item;
		return n;
	}

	private class Node {
		int data;
		Node left, right;

	}
}
