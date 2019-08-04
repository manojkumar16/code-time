package algo.ds;

/**
 * 
 * Size of Binary tree
 * 
 * https://www.youtube.com/watch?v=NA8B84DZYSA&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu&index=5
 * 
 * @author m0k00i6
 *
 */
public class BinaryTreeSize {

	public static void main(String[] args) {
		new BinaryTreeSize().start();
	}

	private void start() {
		LNode root = buildTree2();

		int size = size(root);

		System.out.println("Size of Binary tree is " + size);
	}

	private int size(LNode node) {
		if (node == null) {
			return 0;
		}

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;
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
