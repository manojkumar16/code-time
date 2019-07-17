package etc;

import java.util.Map;
import java.util.TreeMap;

public class BucketingProblemTest {

	public static void main(String[] args) {
		new BucketingProblem().start();
	}

	private void start() {
		Map<Integer, Node> hm = buildGrap();
 
		int k = 833;

		Node found = search(hm.get(3), getNumber(k,3));
		if (found == null) {
			found = search(hm.get(2), getNumber(k,2));
			if (found == null) {
				found = search(hm.get(1), getNumber(k,1));
			}
		}

		if (found != null) {
			System.out.println("We found the key: " + found);
		} else {
			System.out.println("key is not found");
		}
	}

	private Node search(Node node, int key) {
		if (node == null) {
			return null;
		}

		if (key >= node.s && key <= node.e) {
			return node;
		}
		if (node.s < key) {
			return search(node.right, key);
		} else {
			return search(node.left, key);
		}
	}

	private void buildGrapNode(Node head, Node node) {
		if (head.right == null && head.left == null) {
			if (head.s > node.s) {
				head.left = node;
				head.count = 1 + size(head.left) + size(head.right);
			} else {
				head.right = node;
				head.count = 1 + size(head.left) + size(head.right);
			}
			return;
		}

		if (head.right == null) {
			if (head.s < node.s) {
				head.right = node;
				head.count = 1 + size(head.left) + size(head.right);
				return;
			}
			buildGrapNode(head.left, node);
			return;
		}

		if (head.left == null) {
			if (head.s > node.s) {
				head.left = node;
				head.count = 1 + size(head.left) + size(head.right);
				return;
			}
			buildGrapNode(head.right, node);
			return;
		}

		if (head.s < node.s) {
			buildGrapNode(head.right, node);
		} else {
			buildGrapNode(head.left, node);
		}

	}

	private int size(Node x) {
		 if (x == null) return 0;
	        else return x.count;
	}

	private Map<Integer, Node> buildGrap() {
		Map<Integer, Node> hm = new TreeMap<>();
		// // for 1-digit
		Node head_1 = new Node(3, 5,1);
		Node n2_h1 = new Node(1, 2,1);
		Node n3_h1 = new Node(7, 9,1);
		
		buildGrapNode(head_1, n2_h1);
		buildGrapNode(head_1, n3_h1);

		// /// for 2-digits
		Node head_2 = new Node(50, 60,1);
		Node n2_h2 = new Node(30, 40,1);
		Node n3_h2 = new Node(70, 80,1);
		Node n4_h2 = new Node(10, 20,1);
		Node n5_h2 = new Node(21, 29,1);

		buildGrapNode(head_2, n2_h2);
		buildGrapNode(head_2, n3_h2);
		buildGrapNode(head_2, n4_h2);
		buildGrapNode(head_2, n5_h2);

		// //for 3-digits
		Node head_3 = new Node(700, 710,1);
		Node n2_h3 = new Node(600, 650,1);
		Node n3_h3 = new Node(300, 400,1);
		Node n4_h3 = new Node(420, 480,1);
		Node n5_h3 = new Node(100, 115,1);
		buildGrapNode(head_3, n2_h3);
		buildGrapNode(head_3, n3_h3);
		buildGrapNode(head_3, n4_h3);
		buildGrapNode(head_3, n5_h3);

		hm.put(1, head_1);
		hm.put(2, head_2);
		hm.put(3, head_3);

		return hm;
	}

	private int getNumber(int key, int d) {
		String str = key+"";
		String res = str.substring(0, d);
		
		return Integer.parseInt(res);
	}
}

private class Node {
	int length;
	int count;
	int s;
	int e;
	Object data;
	Node left;
	Node right;

	public Node(int s, int e, int count) {
		this.s = s;
		this.e = e;
		this.count = count;
	}

	public String toString() {
		return "[s=" + s + ", e=" + e + "]";
	}
}
