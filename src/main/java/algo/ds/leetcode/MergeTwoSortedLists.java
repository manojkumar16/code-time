package algo.ds.leetcode;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/2382/
 * 
 * Solution: https://leetcode.com/problems/merge-two-sorted-lists/solution/
 */
public class MergeTwoSortedLists {

	public static void main(String[] args) {

	}

	public ListNode mergeTwoLists_myapproach(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode l = null;

		if (l1.val < l2.val) {
			l = new ListNode(l1.val);
			l1 = l1.next;
		} else {
			l = new ListNode(l2.val);
			l2 = l2.next;
		}

		ListNode head = l;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				l.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				l.next = new ListNode(l2.val);
				l2 = l2.next;
			}

			l = l.next;
		}

		if (l1 == null) {
			while (l2 != null) {
				l.next = new ListNode(l2.val);
				l2 = l2.next;
				l = l.next;
			}
		}

		if (l2 == null) {
			while (l1 != null) {
				l.next = new ListNode(l1.val);
				l1 = l1.next;
				l = l.next;
			}
		}

		return head;
	}

	// Recursive approach
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}

	}

	public ListNode mergeTwoLists_iterative(ListNode l1, ListNode l2) {

		ListNode prehead = new ListNode(-1);
		ListNode prev = prehead;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				prev.next = l1;
				l1 = l1.next;
			} else {
				prev.next = l2;
				l2 = l2.next;
			}
			prev = prev.next;
		}

		prev.next = l1 == null ? l2 : l1;

		return prehead.next;
	}
}
