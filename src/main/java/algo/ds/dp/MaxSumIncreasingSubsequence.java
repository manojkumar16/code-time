package algo.ds.dp;

/**
 * 
 * https://www.youtube.com/watch?v=99ssGWhLPUE
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MaximumSumSubsequence.java
 * 
 * Given an array of "n" positive integers. Write a program to find the sum of
 * maximum sum subsequence of the given array such that the integers in the
 * subsequence are in increasing order.
 * 
 * @author m0k00i6
 *
 */
public class MaxSumIncreasingSubsequence {

	public static void main(String[] args) {
		int[] a = new int[] { 4, 6, 1, 3, 8, 4, 6 };

		int[] T = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			T[i] = a[i];
		}

		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				// if ((a[j] < a[i]) && ((T[j] + a[i]) > T[i])) {
				if (a[j] < a[i]) {
					// T[i] = T[j] + a[i];
					T[i] = Math.max(T[i], T[j] + a[i]);
				}
			}
		}

		int max = -1;
		for (int i = 0; i < T.length; i++) {
			if (T[i] > max) {
				max = T[i];
			}
		}

		System.out.println(max);
	}

}
