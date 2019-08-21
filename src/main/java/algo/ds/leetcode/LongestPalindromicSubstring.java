package algo.ds.leetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * 
 * Ref: https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * @author mkprasad
 *
 */
public class LongestPalindromicSubstring {

	public static void main(String args[]) throws Exception {
		
		System.out.println(longestPalindromeBF("kfabad"));
		System.out.println(longestPalindromeBF("bb"));
		System.out.println(longestPalindromeBF("abcda"));
		System.out.println(longestPalindromeBF("babadada"));
		System.out.println(longestPalindromeBF("abacdfgdcaba"));
	}

	public static String longestPalindromeBF(String s) {
		int n = s.length();

		if (n == 0 || n == 1) {
			return s;
		}

		String res = "";

		for (int k = n - 1; k >= 0; k--) {
			int end = k;
			for (int start = 0; start < k; start++) {
				char ch = s.charAt(start);
				if (ch == s.charAt(end)) {
					// We reach at two end where there is possibility of having palindrome
					String pal = checkPalindrome(s, start, end);

					if (pal != null) {
						res = res.length() < pal.length() ? pal : res;
						break;// Break start and Increment k
					} else {
						// Not palidrome... Increment start.
					}
				}
			}
		}

		res = res.length() > 1 ? res : s.charAt(0) + "";
		return res;
	}

	private static String checkPalindrome(String s, int start, int end) {
		int i = start;
		int j = end;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				break;
			} else {
				start++;
				end--;
			}
		}

		if (start >= end) {
			// it's palindrome
			return s.substring(i, j + 1);
		} else {
			// not palindrome
			return null;
		}
	}
}
