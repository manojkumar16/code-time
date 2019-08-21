package algo.ds.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations without Dups: Write a method to compute all permutations of a
 * string of unique characters.
 * 
 * @author m0k00i6
 *
 */
public class StringPermutationCTCI {

	public static void main(String[] args) {
		List<String> res = getPerms("abcd");
		System.out.println(res);
	}

	private static List<String> getPerms(String str) {
		if (str == null) {
			return null;
		}
		List<String> permutations = new ArrayList<>();
		if (str.length() == 0) { // base case
			permutations.add("");
			return permutations;
		}
		char first = str.charAt(0); // get the first char
		String remainder = str.substring(1);// remove the first char
		List<String> words = getPerms(remainder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutations.add(s);
			}
		}

		return permutations;
	}

	private static String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}

}
