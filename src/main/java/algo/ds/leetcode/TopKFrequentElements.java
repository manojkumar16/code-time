package algo.ds.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/articles/top-k-frequent-elements/
 * 
 * @author manoj
 *
 */
public class TopKFrequentElements {

	public static void main(String[] args) {
		TopKFrequentElements ob = new TopKFrequentElements();

		List<Integer> res = ob.topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2);

		System.out.println(res);

	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> count = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
		}

		PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));

		for (int n : count.keySet()) {
			heap.add(n);

			if (heap.size() > k) {
				heap.poll();
			}
		}

		List<Integer> res = new ArrayList<>();
		while (!heap.isEmpty()) {
			res.add(heap.poll());
		}

		Collections.reverse(res);
		return res;
	}
}
