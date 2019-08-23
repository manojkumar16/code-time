package algo.ds.leetcode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * @author m0k00i6
 *
 */
public class SwapNodesInPairs {

	public static void main(String[] args) {
		SwapNodesInPairs obj = new SwapNodesInPairs();
		ListNode h = obj.buildList();
		ListNode res1 = obj.swapPairs(h);
		System.out.println(res1);

		ListNode res2 = obj.swapPairsRecursive(res1);
		System.out.println(res2);

	}

	public ListNode swapPairsRecursive(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode temp = head.next;
		head.next = swapPairsRecursive(head.next.next);
		temp.next = head;
		return temp;
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode d = new ListNode(0);
		d.next = head;
		ListNode k = d;
		ListNode first = d;

		while (first != null && first.next != null && first.next.next != null) {
			k = first;

			ListNode t = k.next;
			k.next = t.next;
			t.next = k.next.next;
			k.next.next = t;

			first = first.next.next;
		}

		return d.next;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return val + " -> " + next;
		}

	}

	/**
	 * Result: 2 -> 1 -> 4 -> 3 -> 5 -> null
	 * 
	 * @return
	 */
	private ListNode buildList2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		return head;
	}

	/**
	 * Result: 2 -> 1 -> 3 -> null
	 * 
	 * @return
	 */
	private ListNode buildList3() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		return head;
	}

	/**
	 * Result: 2 -> 1 -> null
	 * 
	 * @return
	 */
	private ListNode buildList4() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		return head;
	}

	/**
	 * Result: 1 -> null
	 * 
	 * @return
	 */
	private ListNode buildList5() {
		ListNode head = new ListNode(1);
		return head;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	private ListNode buildList() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		return head;
	}
}
