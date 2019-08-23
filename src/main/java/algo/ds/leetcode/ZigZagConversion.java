package algo.ds.leetcode;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * Brute force approach...
 * 
 * @author m0k00i6
 *
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		//System.out.println(zigzag("PAYPALISHIRING", 3));
		 //System.out.println(zigzag("PAYPALISHIRING", 4));
		//System.out.println(zigzag("PAYPALISHIRING", 5));
		// System.out.println(zigzag("PAYPAL", 4));
		
		System.out.println(zigzag("PAYPA", 4));
	}

	private static String zigzag(String s, int numRows) {
		int c = getColumn(s, numRows);
		// Create matrix of rXc
		char[][] mat = new char[numRows][c];

		int n = s.length();

		int index = 0;
		int diff = numRows - 2;
		for (int tc = 0; tc < c; tc = tc + diff + 1) {
			int tr = 0;
			while (tr < numRows && index < n) {
				mat[tr][tc] = s.charAt(index);
				index++;
				tr++;
			}
			index = index + diff;
		}

		index = numRows;
		int dr = 0;
		int row = numRows - 2;
		for (int tc = 1; tc < c; tc++) {
			if (dr < diff) {
				char curr_char = s.charAt(index);
				mat[row][tc] = curr_char;
				index++;
				dr++;
				row--;
			} else {
				index = index + numRows; // skip string index by 'r'
				row = numRows - 2; // reset row
				dr = 0; // reset dr
			}
		}

		String res = buildString(mat);
		return res;
	}

	private static String buildString(char[][] mat) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (mat[i][j] != '\u0000') {
					sb.append(mat[i][j]);
				}
			}
		}
		return sb.toString();
	}

	private static int getColumn(String s, int r) {
		int n = s.length();
		int d = r - 2;
		int k = 0;
		int c = 0;
		while (k <= n) {
			if (k != n) {
				c++;
			}

			k = k + r;
			if ((k + d) <= n) {
				c = c + d;
				k = k + d;
			} else {
				c = c + Math.max(n - k, 0);
				k = n + 1;
			}
		}
		System.out.println(c);
		return c;
	}

}
