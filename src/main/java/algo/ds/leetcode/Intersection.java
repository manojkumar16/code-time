package algo.ds.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 
 * @author m0k00i6
 *
 */
public class Intersection {

	public static void main(String[] args) {
		Intersection ob = new Intersection();
		// int[] nums1 = new int[] { 4, 9, 5 };
		// int[] nums2 = new int[] { 9, 4, 9, 8, 4 };

		// int[] nums1 = new int[] { 1, 2, 2, 1 };
		// int[] nums2 = new int[] { 2, 2 };

		int[] nums1 = new int[] { 2, 1 };
		int[] nums2 = new int[] { 1, 2 };

		int[] result = ob.intersect(nums1, nums2);

		for (int n : result) {
			System.out.print(n + " ");
		}
	}

	/**
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	private int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> hm = new HashMap<>();
		int[] res = new int[nums1.length > nums2.length ? nums1.length : nums2.length];
		int index = 0;
		for (int num : nums1) {
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}

		for (int num : nums2) {
			if (hm.containsKey(num) && hm.get(num) > 0) {
				res[index++] = num;
				hm.put(num, hm.get(num) - 1);
			}
		}

		int[] r = new int[index];
		for (int i = 0; i < index; i++) {
			r[i] = res[i];
		}
		return r;
	}
}
