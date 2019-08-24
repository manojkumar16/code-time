package algo.ds.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * @author m0k00i6
 *
 */
public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses ob = new ValidParentheses();
		System.out.println(ob.isValid("}("));
	}

	public boolean isValid(String s) {

		int n = s.length();
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> mp = new HashMap<>();
		mp.put('{', '}');
		mp.put('(', ')');
		mp.put('[', ']');

		return isValidUtilIterative(s);
		// return isValidUtilRecursion(stack, s, 0, n, mp);
	}

	private boolean isValidUtilIterative(String s) {

		int n = s.length();

		if (n == 0) {
			return true;
		}
		if (n == 1) {
			return false;
		}

		Stack<Character> stack = new Stack<>();
		Map<Character, Character> mp = new HashMap<>();
		mp.put('{', '}');
		mp.put('(', ')');
		mp.put('[', ']');

		for (int i = 0; i < n; i++) {
			char cur = s.charAt(i);
			if (cur == '}' || cur == ')' || cur == ']') {
				if (stack.isEmpty()) {
					return false;
				}
				Character popped = stack.pop();
				if (cur != mp.get(popped)) {
					return false;
				}
			} else {
				stack.push(cur);
			}
		}

		if (stack.isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean isValidUtilRecursion(Stack<Character> stack, String s, int index, int n,
			Map<Character, Character> mp) {

		if (n == 0) {
			return true;
		}
		if (n == 1) {
			return false;
		}
		if (index == n) { // base case
			if (stack.isEmpty()) {
				return true;
			} else {
				return false;
			}
		}

		if (s.charAt(index) == '}' || s.charAt(index) == ')' || s.charAt(index) == ']') {
			// Closing bracket. Pop from stack and compare
			if (stack.isEmpty()) {
				return false;
			}
			Character popped = stack.pop();
			if (s.charAt(index) != mp.get(popped)) {
				return false;
			}
		} else {
			stack.push(s.charAt(index));// Push opening bracket
		}
		return isValidUtilRecursion(stack, s, index + 1, n, mp);

	}
}
