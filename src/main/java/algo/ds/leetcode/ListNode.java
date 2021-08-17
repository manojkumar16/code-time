package algo.ds.leetcode;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
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
