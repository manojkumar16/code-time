package algo.ds.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algo.ds.leetcode.BinaryTreeZigzagLevelOrderTraversal.TreeNode;

/**
 * 
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children.
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * 
 * Ref:
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * @author m0k00i6
 *
 */
public class PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {
		PopulatingNextRightPointersInEachNode ob = new PopulatingNextRightPointersInEachNode();
		Node root = ob.buildTree();
		//Node node1 = ob.connectWithExtraSpace(root);
		Node node2 = ob.connect(root);
		System.out.println(node2);
	}

	/**
	 * Recursive approach
	 * 
	 * Ref: https://www.geeksforgeeks.org/connect-nodes-at-same-level/
	 * 
	 * @param root
	 * @return
	 */
	private Node connect(Node root) {
		if(root == null) {
			return root;
		}
		root.next = null;
		connectRecursion(root);
		return root;
	}




	/**
	 * Use pre-order traversal
	 * 
	 * @param root
	 */
	private void connectRecursion(Node root) {
		if (root == null) {
			return;
		}

		if (root.left != null) {
			root.left.next = root.right;
		}

		if (root.right != null) {
			root.right.next = root.next != null ? root.next.left : null;
		}

		connectRecursion(root.left);
		connectRecursion(root.right);
	}

	public Node connectWithExtraSpace(Node root) {
		List<List<Node>> res = new ArrayList<>();

		if (root == null) {
			return null;
		}
		// Take BFS approach
		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			// declare level list and size from q
			List<Node> level = new ArrayList<>();

			int size = q.size();

			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				level.add(node);

				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}
			}
			res.add(level);
		}

		for (int i = 0; i < res.size(); i++) {
			List<Node> levelList = res.get(i);
			for (int j = 0; j < levelList.size() - 1; j++) {
				levelList.get(j).next = levelList.get(j + 1);
			}
		}

		return root;
	}

	/**
     			1  -> null
     		  /   \
     		2   ->  3 -> null
     	  /  \      / \
         4 -> 5 -> 6 ->7 -> null
	 * @return
	 */
	private Node buildTree() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.right.right = new Node(7);
		return root;
	}

	class Node {
		int val;
		Node left;
		Node right;
		public Node next;

		Node(int x) {
			val = x;
		}
	}
}
