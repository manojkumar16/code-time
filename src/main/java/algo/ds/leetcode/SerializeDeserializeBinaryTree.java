package algo.ds.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
Serialization is the process of converting a data structure or object 
into a sequence of bits so that it can be stored in a file or memory 
buffer, or transmitted across a network connection link to be 
reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. 
There is no restriction on how your serialization/deserialization 
algorithm should work. You just need to ensure that a binary tree 
can be serialized to a string and this string can be deserialized 
to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode 
serializes a binary tree. You do not necessarily need to 
follow this format, so please be creative and come up 
with different approaches yourself.

Note: Do not use class member/global/static variables to store states. 
Your serialize and deserialize algorithms should be stateless.

 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * https://www.youtube.com/watch?v=suj1ro8TIVY
 * 
 * @author manoj
 *
 */
public class SerializeDeserializeBinaryTree {

	public static void main(String[] args) {
		SerializeDeserializeBinaryTree codec = new SerializeDeserializeBinaryTree();
		TreeNode root = codec.buildTree();
		codec.deserialize(codec.serialize(root));
	}

	// Encodes a tree to a single string.
	// PreOrder approach
	public String serialize(TreeNode root) {
		if (root == null) {
			return "X"+",";
		}
		return root.val + "," + serialize(root.left) + serialize(root.right);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		Queue<String> q = new LinkedList<>();
		q.addAll(Arrays.asList(data.split(",")));

		TreeNode res = deserializeHelper(q);

		return res;
	}

	private TreeNode deserializeHelper(Queue<String> q) {
		String value = q.poll();
		if (value.equals("X")) {
			return null;
		}

		TreeNode newNode = new TreeNode(Integer.valueOf(value));

		newNode.left = deserializeHelper(q);
		newNode.right = deserializeHelper(q);

		return newNode;
	}

	private TreeNode buildTree() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
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
