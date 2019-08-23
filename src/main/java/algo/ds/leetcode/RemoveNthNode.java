package algo.ds.leetcode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * @author m0k00i6
 *
 */
public class RemoveNthNode {

	public static void main(String[] args) {
		RemoveNthNode obj = new RemoveNthNode();
		ListNode head = obj.buildList();
		//head = obj.removeNthFromEnd(head, 2);
		head = obj.removeNthFromEndFirstPass(head, 2);
		
		display(head);
	}

	private static void display(ListNode head) {
		while(head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}

	private ListNode removeNthFromEndFirstPass(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode first = dummy;
		ListNode second = dummy;

		for (int i = 1; i <= n + 1; i++) {
			first = first.next;
		}

		while (first != null) {
			first = first.next;
			second = second.next;
		}

		second.next = second.next.next;

		return dummy.next;
	}

	/**
	 * It uses 2 pass 1st pass: Get size of list 2nd pass: remove node after (size -
	 * n) node
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {

		// Calculate size of list.
		int size = getSize(head);

		// Go to size - n index and remove next node
		if (head == null || n > size || (size == 1 && n == 1)) {
			return null;
		}

		ListNode first = head;
		int k = 1;
		int ith = size - n;
		if (ith == 0) { // Remove head
			return head.next;
		}
		while (k < ith) {
			first = first.next;
			k++;
		}

		first.next = first.next.next;

		return head;
	}

	public int getSize(ListNode node) {
		// ListNode node = head;
		if (node == null) {
			return 0;
		}
		int s = 0;
		while (node != null) {
			s++;
			node = node.next;
		}

		return s;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * Result: 2
	 * @return
	 */
	private ListNode buildList2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		return head;
	}

	/**
	 * Result: 1,2,3,5
	 * @return
	 */
	private ListNode buildList() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		return head;
	}

}
