package algo.ds.gfk;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/print-all-permutations-of-a-string-in-java/
 * 
 * @author manoj
 *
 */
public class PermutationOfString {

	public static void main(String[] args) {
		PermutationOfString ob = new PermutationOfString();
		List<String> out = new ArrayList<>();
		ob.permutate("abc", "", out);
		System.out.println(out);
	}

	private void permutate(String str, String res, List<String> out) {
		if (str.length() == 0) {
			out.add(res);
		} else {
			for (int i = 0; i < str.length(); i++) {
				// ith character of str
				char ch = str.charAt(i);
				// Rest of the string after excluding the ith character
				String substr = str.substring(0, i) + str.substring(i + 1);
				permutate(substr, res + ch, out);
			}
		}
	}

}
