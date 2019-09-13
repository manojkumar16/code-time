package algo.ds;

import java.util.LinkedList;
import java.util.Queue;

public class MainDriver {

	public static void main(String[] args) {
		new MainDriver().start();
	}

	private void start() {
		LNode root = buildTree();
		//levelOrderTraversal(root);
		//printLeafNode(root);
		mirror(root);
	}

	private void mirror(LNode root) {
		if (root == null) {
			return;
		}
		mirror(root.left);
		mirror(root.right);
		LNode temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

	private void printLeafNode(LNode root) {
		if(root == null) {
			return;
		}
		
		if(root.left == null && root.right == null) {
			System.out.print(root.data + "  ");
		}
		printLeafNode(root.left);
		printLeafNode(root.right);
	}

	private void levelOrderTraversal(LNode root) {
		if(root == null) {
			return;
		}
		Queue<LNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			LNode node = q.remove();
			System.out.print(node.data+"   ");
			if(node.left!= null) {
				q.add(node.left);
			}
			if(node.right!=null) {
				q.add(node.right);
			}
		}
	}

	public LNode buildTree() {
		LNode root = new LNode(20);
		root.left = new LNode(10);
		root.left.left = new LNode(15);
		root.left.right = new LNode(12);
		
		root.right = new LNode(60);
		root.right.left = new LNode(30);
		root.right.right = new LNode(40);
		
		root.right.right.left = new LNode(50);
		root.right.right.right = new LNode(8);
		return root;
	}
	
	class LNode {
		int data;
		LNode left;
		LNode right;
		public LNode(int d) {
			this.data = d;
		}
	}
}
