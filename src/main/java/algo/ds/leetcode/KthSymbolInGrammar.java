package algo.ds.leetcode;

/**
 * https://leetcode.com/explore/learn/card/recursion-i/253/conclusion/1675
 * 
 * Solution: https://www.youtube.com/watch?v=5P84A0YCo_Y&t=1s
 * 
 */
public class KthSymbolInGrammar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int kthGrammar(int n, int k) {

		if (n == 1 && k == 1) {
			return 0;
		}
		int mid = (int) (Math.pow(2, n - 1) / 2);
		if (k <= mid) {
			return kthGrammar(n - 1, k);
		} else {
			int ans = kthGrammar(n - 1, k - mid);
			return ans == 0 ? 1 : 0;
		}

	}

}
