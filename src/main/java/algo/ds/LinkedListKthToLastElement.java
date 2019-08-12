package algo.ds;

/**
 * Return Kth to Last: Implement an algorithm to find the kth to last element of
 * a singly linked list.
 * 
 * This is recursive approach and takes O(n) space and time complexity.
 * Iterative approach is more optimal but less straightforward. 
 * Iterative approach takes O(n) time and O(1) space.
 * Iterative approach:
 * Use two pointers, pi and p2. We place them k nodes apart in the
 * linked list by putting p2 at the beginning and moving pi k nodes into the
 * list. Then, when we move them at the same pace, pi will hit the end of the
 * linked list after LENGTH - k steps. At that point, p2 will be LENGTH - k
 * nodes into the list, or k nodes from the end.
 * 
 * Ref: From cracking the coding interview...
 * 
 * @author m0k00i6
 *
 */
public class LinkedListKthToLastElement {

	public static void main(String[] args) {
		new LinkedListKthToLastElement().start();

	}

	private void start() {
		LinkedListNode head = buildList();
		Index idx = new Index();
		LinkedListNode kthNode = kthToLast(head, 5, idx);

		if (kthNode == null) {
			System.out.println("kth index is out of range...");
		} else {
			System.out.println(kthNode.data);
		}
	}

	private LinkedListNode kthToLast(LinkedListNode head, int k, Index idx) {
		if (head == null) {
			return null;
		}

		LinkedListNode node = kthToLast(head.next, k, idx);
		idx.value = idx.value + 1;
		if (idx.value == k) {
			return head;
		}
		return node;
	}

	private class Index {
		public int value = 0;
	}

	/**
	 * 10 -> 15 -> 7 -> 9 -> 8 -> 90 -> 4
	 * 
	 * @return
	 */
	private LinkedListNode buildList() {
		LinkedListNode head = new LinkedListNode(10);
		head.next = new LinkedListNode(15);
		head.next.next = new LinkedListNode(7);
		head.next.next.next = new LinkedListNode(9);
		head.next.next.next.next = new LinkedListNode(8);
		head.next.next.next.next.next = new LinkedListNode(90);
		head.next.next.next.next.next.next = new LinkedListNode(4);
		return head;
	}

	private class LinkedListNode {
		LinkedListNode next;
		int data;

		public LinkedListNode(int data) {
			this.data = data;
		}
	}
}
