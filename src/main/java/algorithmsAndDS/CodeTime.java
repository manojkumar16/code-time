package algorithmsAndDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeTime {

	public static void main(String[] args) {
		new CodeTime().start();

	}

	private void start() {

		
		
		
		
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
	
	public Map<Integer, List<Integer>> buildGraph() {
		Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
		hm.put(0, Arrays.asList(1, 5));
		hm.put(2, Arrays.asList(0, 3));
		hm.put(3, Arrays.asList(2, 5));
		hm.put(4, Arrays.asList(2, 3));
		hm.put(5, Arrays.asList(4));
		hm.put(6, Arrays.asList(0, 4, 9, 8));
		hm.put(7, Arrays.asList(6, 9));
		hm.put(8, Arrays.asList(6));
		hm.put(9, Arrays.asList(10, 11));
		hm.put(10, Arrays.asList(12));
		hm.put(11, Arrays.asList(12));
		hm.put(12, Arrays.asList(9));

		hm.put(1, new ArrayList<Integer>());

		// buildNode( hm, 0, 1, 5 );
		// buildNode( hm, 6, 0, 4, 9, 8 );

		return hm;
	}
}
