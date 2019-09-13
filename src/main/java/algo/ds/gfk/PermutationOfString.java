package algo.ds.gfk;

import java.util.ArrayList;
import java.util.List;

/**
	Given a string str, the task is to print all the permutations of str. 
	A permutation is an arrangement of all or part of a set of objects, 
	with regard to the order of the arrangement. For instance, the words 
	‘bat’ and ‘tab’ represents two distinct permutation (or arrangements) 
	of a similar three letter word.
	
	Examples:
	
	Input: str = “cd”
	Output: cd dc
	
	Input: str = “abb”
	Output: abb abb bab bba bab bba

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
