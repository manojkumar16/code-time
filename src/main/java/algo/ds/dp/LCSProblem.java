package algo.ds.dp;

/**
 * Longest Common Subsequence
 * 
 * https://www.geeksforgeeks.org/printing-longest-common-subsequence/
 * 
 * https://www.youtube.com/watch?v=NnD96abizww
 * https://www.youtube.com/watch?v=sSno9rV8Rhg
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * 
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A
 * subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example,
 * “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different
 * possible subsequences.
 * 
 * @author manoj
 * 
 */
public class LCSProblem {
    static String X = "abcdaf";
    static String Y = "acbcf";

//    static String X = "ABACEB";
//    static String Y = "ADBAVCEB";
    
    static int lcs[][] = new int[X.length() + 1][Y.length() + 1];

    public static void main( String[] args ) {
        LCS();
        System.out.println( "length of longest common subsequence using [Memoization]: "+ lcs[X.length()][Y.length()] );
       // System.out.println(ls);
        
        int max = lcsRecursion();
        System.out.println("length of longest common subsequence using [Recursion]: "+max);
        
        printSubsequence();
    }

    /**
     * https://www.youtube.com/watch?v=sSno9rV8Rhg
     * 
     * @return
     */
    private static int lcsRecursion() {
    		return lcsRecursion(0,0);
	}

	private static int lcsRecursion(int i, int j) {
		if (i >= X.length() || j >= Y.length()) { // End of String
			return 0;
		} else if (X.charAt(i) == Y.charAt(j)) { // Char matches so increase the count
			return 1 + lcsRecursion(i + 1, j + 1);
		} else {
			return Math.max(lcsRecursion(i, j + 1), lcsRecursion(i + 1, j));
		}
	}

	private static void LCS() {
        for ( int i = 0; i <= X.length(); i++ ) {
            lcs[i][0] = 0;
        }
        for ( int j = 0; j < Y.length(); j++ ) {
            lcs[0][j] = 0;
        }

        for ( int i = 1; i <= X.length(); i++ ) {
            for ( int j = 1; j <= Y.length(); j++ ) {
                if ( X.charAt( i - 1 ) == Y.charAt( j - 1 ) ) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = Math.max( lcs[i - 1][j], lcs[i][j - 1] );
                }
            }
        }
        
    }
	
	private static void printSubsequence() {
		// Print subsequence
		int index = lcs[X.length()][Y.length()];
		// Create a character array to store the lcs string
		char[] cs = new char[index];
		int i = X.length(), j = Y.length();
		while (i > 0 && j > 0) {
			if (X.charAt(i - 1) == Y.charAt(j - 1)) {
				cs[index - 1] = X.charAt(i - 1);
				i--;
				j--;
				index--;
			} else if (lcs[i - 1][j] < lcs[i][j - 1]) {
				j--;
			} else {
				i--;
			}
		}

		System.out.println("Longest Common Subsequence is: "+new String(cs));
	}
}
