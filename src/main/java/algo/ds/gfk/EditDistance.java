package algo.ds.gfk;

/**
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

 * https://leetcode.com/problems/edit-distance/
 * 
 * Ref: https://www.youtube.com/watch?v=We3YDTzNXEk
 * 
 * @author manoj
 *
 */
public class EditDistance {

	public static void main(String[] args) {
		System.out.println(new EditDistance().minDistance("horse", "ros"));
		System.out.println(new EditDistance().minDistance("intention", "execution"));
	}

	public int minDistance(String word1, String word2) {
		if (word1 == null || word1.isEmpty()) {
			return word2.length();
		}

		if (word2 == null || word2.isEmpty()) {
			return word1.length();
		}

		int[][] T = new int[word2.length() + 1][word1.length() + 1];

		for (int i = 0; i <= word1.length(); i++) {
			T[0][i] = i;
		}

		for (int j = 0; j <= word2.length(); j++) {
			T[j][0] = j;
		}

		for (int i = 1; i <= word2.length(); i++) {
			for (int j = 1; j <= word1.length(); j++) {
				if (word2.charAt(i-1) == word1.charAt(j-1)) {
					T[i][j] = T[i - 1][j - 1];
				} else {
					T[i][j] = min(T[i - 1][j - 1], T[i - 1][j], T[i][j - 1]) + 1;
				}
			}
		}
		return T[word2.length()][word1.length()];
	}

	private int min(int i, int j, int k) {
		int min = i < j ? i < k ? i : k : j < k ? j : k;
		return min;
	}
}
