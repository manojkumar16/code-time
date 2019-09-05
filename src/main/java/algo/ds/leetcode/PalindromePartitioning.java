package algo.ds.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Ref:
 * https://leetcode.com/problems/palindrome-partitioning/
 * https://www.youtube.com/watch?v=4ykBXGbonlA
 * https://www.youtube.com/watch?v=lDYIvtBVmgo
 * 
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * Input: "aab" Output: [ ["aa","b"], ["a","a","b"] ]
 * 
 * @author manoj
 *
 */
public class PalindromePartitioning {

	public static void main(String[] args) {
		PalindromePartitioning ob = new PalindromePartitioning();
		List<List<String>> out = ob.partition("aab");
		System.out.println(out);
	}

	private List<List<String>> partition(String s) {
		
		List<List<String>> validDecompositon = new ArrayList<>();
		List<String> decompInProgress = new ArrayList<>();
		
		decomposeString(s, 0, decompInProgress, validDecompositon);
		
		return validDecompositon;
	}

	private void decomposeString(String s, int i, List<String> decompInProgress, List<List<String>> validDecompositon) {
		// TODO Auto-generated method stub
		
	}

}
