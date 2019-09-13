package algo.ds.dp;

/**

Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
Examples :

Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
Output : 5
The longest common substring is “Geeks” and is of length 5.

Input : X = “abcdxyz”, y = “xyzabcd”
Output : 4
The longest common substring is “abcd” and is of length 4.

Input : X = “zxabcdezy”, y = “yzabcdezx”
Output : 6
The longest common substring is “abcdez” and is of length 6.

 * Ref: https://www.geeksforgeeks.org/longest-common-substring-dp-29/
 * 
 * @author m0k00i6
 *
 */
public class LongestCommonSubstring {

	public static void main(String[] args) {
		String s1 = "abcdaf";
		String s2 = "zbcdf";

		System.out.println("Length : " + lcs(s1, s2));
	}

	private static int lcs(String s1, String s2) {
		int[][] lcs = new int[s1.length() + 1][s2.length() + 1];

		int max = 0;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = 0;
				}

				max = Math.max(max, lcs[i][j]);
			}
		}

		displayLCS(s1, lcs, max);
		return max;
	}

	private static void displayLCS(String s1, int[][] lcs, int max) {
		String str = "";
		for (int i = lcs.length - 1; i >= 0; i--) {
			for (int j = lcs[0].length - 1; j >= 0; j--) {
				if (lcs[i][j] == max && max > 0) {
					str = s1.charAt(j - 1) + str;
					max--;
				}
			}
		}

		System.out.println("Longest Common substring: " + str);
	}

}
