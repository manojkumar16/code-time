package algo.ds.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * @author m0k00i6
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal ob = new BinaryTreeZigzagLevelOrderTraversal();
		TreeNode root = ob.buildTree();
		System.out.println(ob.zigzagLevelOrder(root));
		System.out.println(ob.zigzagLevelOrderUtilBFS(root));
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		Map<Integer, List<Integer>> map = new HashMap<>();
		zigzagLevelOrderUtil(root, 0, map);

		rearrange(map);

		for (int i = 0; i < map.size(); i++) {
			result.add(map.get(i));
		}

		return result;
	}

	private void zigzagLevelOrderUtil(TreeNode root, int level, Map<Integer, List<Integer>> map) {
		if (root == null) {
			return;
		}

		if (!map.containsKey(level)) {
			map.put(level, new ArrayList<>());
		}
		map.get(level).add(root.val);

		zigzagLevelOrderUtil(root.left, level + 1, map);
		zigzagLevelOrderUtil(root.right, level + 1, map);
		
	}

	private void rearrange(Map<Integer, List<Integer>> map) {
		int size = map.size();
		for (int i = 0; i < size; i++) {
			List<Integer> ls = map.get(i);
			if (i % 2 == 1) {
				// Swap every 2 elements
				List<Integer> rs = reverse(ls);
				map.put(i, rs);
			}
		}
	}

	private List<Integer> reverse(List<Integer> ls) {
		List<Integer> rs = new ArrayList<>();
		for(int i=ls.size()-1; i>=0; i--) {
			rs.add(ls.get(i));
		}
		return rs;
	}

	/**
	 * BFS approach
	 * Ref: https://medium.com/@harycane/binary-tree-zigzag-level-order-traversal-5b96a3e1b767
	 * 
	 * @param root
	 */
	public List<List<Integer>> zigzagLevelOrderUtilBFS(TreeNode root) {
		// return list of list
		List<List<Integer>> res = new ArrayList<>();

		if (root == null) {
			return res;
		}
		// Take BFS approach
		Queue<TreeNode> q = new LinkedList<>();

		q.add(root);

		// declare zig zag var
		boolean zigzag = false;

		while (!q.isEmpty()) {

			// declare level list and size from q
			List<Integer> level = new ArrayList<>();

			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();

				if (zigzag) {
					level.add(0, node.val);
				} else {
					level.add(node.val);
				}

				if (node.left != null) {
					q.add(node.left);
				}

				if (node.right != null) {
					q.add(node.right);
				}
			}
			res.add(level);
			zigzag = !zigzag;

		}
		return res;
	}

	/**
	 * 3 20 9 15 7 8 6 17 11
	 * 
	  3 --- 0 
	 / \ 
	 9 20 --- 1 
	/ \ 
	  15 7 --- 2 
	 / \   / \ 
	11 17  6  8 --- 3
	 * 
	 * @return
	 */
	private TreeNode buildTree() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.left.left = new TreeNode(11);
		root.right.left.right = new TreeNode(17);

		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(6);
		root.right.right.right = new TreeNode(8);
		return root;
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
