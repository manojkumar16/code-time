package algo.ds.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO Not yet implemented
 * 
 * https://leetcode.com/problems/lru-cache/
 * 
 * Solution Ref: https://www.youtube.com/watch?v=R0GTqg3pJKg
 * 
 * @author manoj
 *
 */
public class LRUCache {

	int capacity;
	int size = 0;

	Map<Integer, DLL> hm = new HashMap<>();

	private DLL head;

	private DLL tail;

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
		// cache.test();
		//testCache(cache);
		
		cache.put(2, 1);
		System.out.println(cache.get(2));
		cache.put(3,2);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
	}
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (hm.containsKey(key)) {
			// Move this key to tail
			DLL node = hm.get(key);
			// System.out.println("Refreshing node by placing to tail: " + node.value);
			moveNodeToTail(node);
			hm.put(key, node);
			return hm.get(key).value;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (size >= capacity) {
			// Evict head
			// System.out.println("Evicting node: " + head.value);
			int k = head.key;
			remove(head);
			hm.remove(k);
		} else {
			size++;
		}

		DLL node = new DLL(key, value);
		// Add to tail
		add(node);
		hm.put(key, node);
	}

	/**
	 * Remove node and return head
	 */
	public void remove(DLL node) {
		if (node == null || head == null) {
			return;
		}
		
		if(node.key == head.key) {
			head = head.next;
			if(head == null) {
				tail = null;
			}
			
			return;
		}
		
		if (node.prev == null) { // It's head
			head = node.next;
			head.prev = null;
			return;
		}

		if (node.next == null) { // It's tail
			tail = tail.prev;
			tail.next = null;
		}

		DLL prev = node.prev;
		DLL next = node.next;

		prev.next = node.next;
		next.prev = node.prev;

		return;
	}

	/**
	 * Do it when get called
	 * 
	 * @param node
	 * @param tail
	 */
	public void moveNodeToTail(DLL node) {
		if (node == null) {
			return;
		}
		
		if(node.next == null && node.key == tail.key && node.prev == tail.prev) {
			//System.out.println("Already at tail. Do nothing.");
			return;
		}
		
		remove(node);

		// Reset next and prev pointer before adding node to tail
		node.prev = null;
		node.next = null;
		add(node);
	}

	/**
	 * Add node to the tail
	 * 
	 * @param node
	 * @return
	 */
	public void add(DLL node) {
		if (node == null) {
			return;
		}

		if (head == null) {
			head = tail = node;
			return;
		}

		if (tail == null) {
			tail = node;
			return;
		}

		tail.next = node;
		node.prev = tail;
		tail = tail.next;

	}

	class DLL {
		int key;
		int value;
		DLL next;
		DLL prev;

		public DLL(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public String toString() {
			DLL temp = this;
			StringBuilder sb = new StringBuilder();
			while (temp != null) {
				sb.append(temp.key).append(" -> ");
				temp = temp.next;
			}
			return sb.toString();
		}
	}

	private static void testCache(LRUCache cache) {
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4); // 1,2,3,4

		cache.put(5, 5); // 2,3,4,5

		System.out.println(cache.get(3)); // 2,4,5,3

		cache.put(8, 8); // 4,5,3,8

		cache.remove(5); // 4,3,8

		cache.put(9, 9); // 4,3,8,9
		cache.put(10, 10); // 3,8,9,10
	}

	private void test() {
		head = buildDLL(); // 1,2,3,4

		DLL rn = hm.get(3);
		remove(rn); // 1,2,4

		DLL n = new DLL(8, 8);
		add(n); // 1,2,4,8

		moveNodeToTail(hm.get(2)); // 1,4,8,2

		// System.out.println(head);
	}

	/**
	 * 1 - 2 - 3 - 4
	 * 
	 * @return
	 */
	private DLL buildDLL() {
		DLL n1 = new DLL(1, 1);
		DLL n2 = new DLL(2, 2);
		DLL n3 = new DLL(3, 3);
		DLL n4 = new DLL(4, 4);

		n1.prev = null;
		n1.next = n2;

		n2.prev = n1;
		n2.next = n3;

		n3.prev = n2;
		n3.next = n4;

		n4.prev = n3;
		n4.next = null;

		hm.put(1, n1);
		hm.put(2, n2);
		hm.put(3, n3);
		hm.put(4, n4);

		head = n1;
		tail = n4;

		return head;
	}

	private int remove(int key) {
		if (size <= 0) {
			// System.out.println("Cache is empty");
			return -1;
		}

		if (hm.containsKey(key)) {
			int value = hm.get(key).value;
			remove(hm.get(key));
			hm.remove(key);
			size--;
			return value;
		} else {
			// System.out.println("Key not found...");
			return -1;
		}
	}
}
