package algo.ds;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * Partition: Write code to partition a linked list around a value x, such that
 * all nodes less than x come before all nodes greater than or equal to x. lf x
 * is contained within the list, the values of x only need to be after the
 * elements less than x (see below). The partition element x can appear anywhere
 * in the "right partition"; it does not need to appear between the left and
 * right partitions. 
 * EXAMPLE 
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition = 5) 
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8 
 * Ref: Cracking the coding interview
 * 
 * @author m0k00i6
 *
 */
public class LinkedListPartition {

	public static void main(String[] args) {
		new LinkedListPartition().start();
	}

	private void start() {
		LinkedListNode head = buildList(Arrays.asList(3, 5, 8, 5, 10, 2, 1));

		LinkedListNode partNode = partition(head, 5);
		
		System.out.println(partNode);
	}

	private LinkedListNode partition(LinkedListNode node, int x) {
		LinkedListNode head = node;
		LinkedListNode tail = node;

		while (node != null) {
			LinkedListNode next = node.next;
			if (node.data < x) {
				// * Insert node at head. *1
				node.next = head;
				head = node;
			} else {
				// 1* Insert node at tail . *1
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;

		// II The head has changed, so we need to return it to the user.
		return head;
	}

	/**
	 * 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1
	 * 
	 * @param list
	 * 
	 * @return
	 */
	private LinkedListNode buildList(List<Integer> list) {
		LinkedListNode head = null;
		LinkedListNode node = null;
		for (Integer data : list) {
			if (node == null) {
				node = new LinkedListNode(data);
				head = node;
			} else {
				node.next = new LinkedListNode(data);
				node = node.next;
			}
		}
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
