package algo.ds;

public class StringPermutations3 {

	public static void main(String[] args) {
		new StringPermutations3().start();
	}

	private void start() {
		permutate("abc", "");

	}

	private void permutate(String str, String prefix) {
		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1); // bc
				permutate(rem, prefix + str.charAt(i)); // bc, ""+a
			}
		}
	}

}
