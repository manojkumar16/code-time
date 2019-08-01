package algo.ds;

/**
 * Print Leaves of Binary Tree
 * 
 * Take DFS approach to print leaves of Binary Tree
 *
 * @author m0k00i6
 *
 */
public class PrintLeavesOfBTree {

	public static void main(String[] args) {
		new PrintLeavesOfBTree().start();

	}

	private void start() {

		LNode root = buildTree1();

		printLeavesOfBinaryTree(root);

		System.out.println("\n\n");

	}

	private void printLeavesOfBinaryTree(LNode node) {

		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			System.out.print(node.data + "  ");
		}

		printLeavesOfBinaryTree(node.left);
		printLeavesOfBinaryTree(node.right);

	}

	private LNode buildTree1() {
		LNode n = newNode(10);
		n.left = newNode(11);
		n.left.left = newNode(7);

		n.right = newNode(9);
		n.right.left = newNode(15);
		n.right.right = newNode(8);
		return n;
	}

	private LNode buildTree2() {
		LNode n = newNode(4);
		n.left = newNode(5);
		n.right = newNode(2);
		n.right.right = newNode(1);
		n.right.left = newNode(3);
		n.right.left.left = newNode(6);
		n.right.left.right = newNode(7);
		return n;
	}

	/**
	 * 
	 *  1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
	 * 
	 * @return
	 */
	private LNode buildTree3() {
		LNode n = newNode(1);
		n.right = newNode(3);
		n.left = newNode(2);
		n.left.right = newNode(4);
		n.left.right.right = newNode(5);
		n.left.right.right.right = newNode(6);

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
