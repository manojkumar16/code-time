package algo.ds.leetcode;

/**
 * https://leetcode.com/articles/odd-even-linked-list/
 * 
 * @author m0k00i6
 *
 */
public class OddEvenLinkedList {

	public static void main(String[] args) {
		OddEvenLinkedList ob = new OddEvenLinkedList();
		ob.start();
	}

	private void start() {
		ListNode head = buildList();

		System.out.println(head);

		ListNode res = oddEvenList(head);
		System.out.println(res);
	}

	public ListNode oddEvenList(ListNode head) {

		if (head == null) {
			return null;
		}
		ListNode odd = head, even = head.next, evenHead = even;
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = evenHead;
		return head;
	}

	private ListNode buildList() {
		ListNode head = new ListNode(1);
		ListNode node = head;
		for (int i = 2; i <= 10; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}

		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder("" + val);
			ListNode temp = next;
			while (temp != null) {
				sb.append(" -> " + temp.val);
				temp = temp.next;
			}
			return sb.toString();
		}
	}
}
