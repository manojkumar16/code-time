package algo.ds.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

 * https://leetcode.com/problems/group-anagrams/
 * 
 * @author manoj
 *
 */
public class GroupAnagrams {

	public static void main(String[] args) {
		GroupAnagrams ob = new GroupAnagrams();

		System.out.println("List is: " + ob.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));

	}

	public List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> hm = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			String res = sortIndividualString(strs[i]);
			System.out.println(res);
			List<String> glist = hm.get(res);
			if (glist == null) {
				glist = new ArrayList<>();
				hm.put(res, glist);
			}
			glist.add(strs[i]);
		}

		List<List<String>> result = new ArrayList<>();
		hm.forEach((k, v) -> result.add(v));
		return result;
	}

	/**
	 * Key-index count sorting
	 * 
	 * @param auxStrs
	 * 
	 * @param str
	 */
	private String sortIndividualString(String s) {
		int R = 256;
		int[] count = new int[R + 1];
		char[] aux = new char[s.length()];
		int n = s.length();

		// Get occurrence of chars
		for (int i = 0; i < n; i++) {
			count[s.charAt(i) + 1]++;
		}

		// Accumulate
		for (int i = 0; i < R; i++) {
			count[i + 1] = count[i + 1] + count[i];
		}

		// aux array
		for (int i = 0; i < n; i++) {
			aux[count[s.charAt(i)]++] = s.charAt(i);
		}

		return new String(aux);
	}

}
