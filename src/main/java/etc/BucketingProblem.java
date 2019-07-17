package etc;

public class BucketingProblem implements Comparable<BucketingProblem>{
	private Node head;
	private int digitLength;
	
	public BucketingProblem(int dLength){
		this.digitLength = dLength;
	}
	
	public int getDigitLength(){
		return this.digitLength;
	}
	
	public void put(int s, int e) {
		head = put(head, s, e);
	}

	private Node put(Node x, int s, int e) {
		if (x == null)
			return new Node(s, e, 1);
		int cmp = x.s > s ? -1 : 1;
		if (cmp < 0) {
			x.left = put(x.left, s, e);
		} else if (cmp > 0) {
			x.right = put(x.right, s, e);
		} else {
			x.s = s;
			x.e = e;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	private int size(Node x) {
		if (x == null) {
			return 0;
		} else {
			return x.count;
		}
	}

	public Node search(Node node, int key) {
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
	
	public Node getHead(){
		return this.head;
	}
	
	public class Node {
		int s;
		int e;
		Node left, right; // left and right subtrees
		int count; // number of nodes in subtree

		public Node(int s, int e, int count) {
			this.s = s;
			this.e = e;
			this.count = count;
		}
		
		public String toString() {
			return "[s=" + s + ", e=" + e + "--> digitLength: "+count+"]";
		}
	}

	@Override
	public int compareTo(BucketingProblem o) {
		return this.getHead().count < o.getHead().count ? 1 : -1;
	}
	
	@Override
	public String toString(){
		return "{digit length-"+this.getDigitLength()+", size-"+ this.getHead().count+"}";
	}
	
}
