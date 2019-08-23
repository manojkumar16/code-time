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

		// System.out.println(longestPalindromeBF("kfabad"));
		// System.out.println(longestPalindromeBF("bb"));
		// System.out.println(longestPalindromeBF("abcda"));
		// System.out.println(longestPalindromeBF("babadada"));
		System.out.println("With Brute force approah: " + longestPalindromeBF("abacdfgdcaba"));

		System.out.println("With DP approah: " + longestPalindromeDP("abacdfgdcaba"));
	}

	/**
	 * Not working. Loot at https://www.youtube.com/watch?v=Fi5INvcmDos
	 * 
	 * @param s
	 * @return
	 */
	private static String longestPalindromeDP(String s) {
		String res = "";
		int n = s.length();
		boolean[][] cache = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					cache[i][j] = true;
				} else {
					cache[i][j] = false;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if (((i + 1 < j - 1) && (cache[i + 1][j - 1] == true)) || (i == (j - 1))) {
						cache[i][j] = true;
						String temp = s.substring(i, j);
						res = res.length() < temp.length() ? res : temp;
					}
				}
			}
		}
		return res;
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
