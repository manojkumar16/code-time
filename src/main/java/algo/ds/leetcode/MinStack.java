package algo.ds.leetcode;

public class MinStack {

	public Node top;

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());;  // --> Returns -3.
		minStack.pop();
		System.out.println(minStack.top());      //--> Returns 0.
		System.out.println(minStack.getMin());   //--> Returns -2.
	}

	/** initialize your data structure here. */
	public MinStack() {

	}

	public void push(int x) {
		if (top == null) {
			Node n = new Node(x, x);
			top = n;
		} else {
			Node n = new Node(x, Math.min(x, top.min));
			n.next = top;
			top = n;
		}
	}

	public void pop() {
		if (top == null) {
			return;
		}

		top = top.next;
	}

	public int top() {
		if (top == null) {
			return -1;
		}
		return top.value;
	}

	public int getMin() {
		if (top == null) {
			return -1;
		}
		return top.min;
	}

	class Node {
		int value;
		int min;
		Node next;

		public Node(int x, int min) {
			this.value = x;
			this.min = min;
		}
	}
}
