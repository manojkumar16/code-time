package algo.ds;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a Binary Tree, print left view of it. Left view of a Binary Tree is set
 * of nodes visible when tree is visited from left side.
 * 
 *               1
               /   \
              2     3
             / \     \
            4   5     6  
            
 * Output : 1 2 4
 * 
 * https://www.geeksforgeeks.org/print-left-view-binary-tree/
 * 
 * @author m0k00i6
 *
 */
public class BinaryTreeLeftView {

	public static void main(String[] args) {
		new BinaryTreeLeftView().start();

	}
	Set<Integer> visited = new HashSet<>();
	private void start() {

		Node root = buildTree3();

		printLeftView(root, 0);

		System.out.println("\n\n");
	}

	private void printLeftView(Node node, int level) {
		if (node == null) {
			return;
		}

		if (!visited.contains(level)) {
			System.out.print(node.data + "  ");
			visited.add(level);
		}

		printLeftView(node.left, level + 1);
		printLeftView(node.right, level + 1);

	}

	private Node buildTree1() {
		Node n = newNode(10);
		n.left = newNode(11);
		n.left.left = newNode(7);

		n.right = newNode(9);
		n.right.left = newNode(15);
		n.right.right = newNode(8);
		return n;
	}

	private Node buildTree2() {
		Node n = newNode(4);
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
	private Node buildTree3() {
		Node n = newNode(1);
		n.right = newNode(3);
		n.left = newNode(2);
		n.left.right = newNode(4);
		n.left.right.right = newNode(5);
		n.left.right.right.right = newNode(6);

		
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
