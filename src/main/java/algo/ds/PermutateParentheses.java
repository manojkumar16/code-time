package algo.ds;

public class PermutateParentheses {

	public static void main(String[] args) {
		permutateParentheses(3);
	}

	private static void permutateParentheses(int N) {
		brackets("", 0, 0, N);
	}

	private static void brackets(String str, int open, int close, int N) {
		if (open == N && close == N) {
			System.out.println(str);
		} else {
			if (open < N) {
				brackets(str + "(", open + 1, close, N);
			}
			if (close < open) {
				brackets(str + ")", open, close + 1, N);
			}
		}

	}

}
