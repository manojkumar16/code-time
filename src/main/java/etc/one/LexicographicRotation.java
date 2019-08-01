package etc.one;

import java.util.Arrays;

public class LexicographicRotation {
	public static void main(String[] args) {
		String str = minLexicographicRotation("manmadelake"); // // adelakemanm
		System.out.println(str);
	}

	private static String minLexicographicRotation(String str) {
		Suffix[] suffixes;
		String s = str + str;
		suffixes = new Suffix[s.length()];
		for (int i = 0; i < s.length(); i++)
			suffixes[i] = new Suffix(s, i);
		Arrays.sort(suffixes);

		for (int i = 0; i < suffixes.length; i++) {
			if (suffixes[i].length() >= s.length() / 2) {
				String res = suffixes[i].toString()
						.substring(0, s.length() / 2);
				return res;
			}
			// System.out.println(suffixes[i]);
		}
		return null;
	}

	private static class Suffix implements Comparable<Suffix> {
		private final String text;
		private final int index;

		private Suffix(String text, int index) {
			this.text = text;
			this.index = index;
		}

		private int length() {
			return text.length() - index;
		}

		private char charAt(int i) {
			return text.charAt(index + i);
		}

		public int compareTo(Suffix that) {
			if (this == that)
				return 0; // optimization
			int N = Math.min(this.length(), that.length());
			for (int i = 0; i < N; i++) {
				if (this.charAt(i) < that.charAt(i))
					return -1;
				if (this.charAt(i) > that.charAt(i))
					return +1;
			}
			return this.length() - that.length();
		}

		public String toString() {
			return text.substring(index);
		}
	}
}
