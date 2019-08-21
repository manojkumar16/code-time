package algo.ds;

public class LSD {

	public static void main(String[] args) {
		String[] arr = new String[] { "hello", "apple", "welco", "guava" };
		sort(arr, 5);
	}

	private static void sort(String[] a, int W) {
		int R = 256;
		int N = a.length;
		String[] aux = new String[N];

		for (int d = W - 1; d >= 0; d--) {
			int[] count = new int[R + 1];
			// Count frequency
			for (int i = 0; i < N; i++) {
				count[a[i].charAt(d) + 1]++;
			}

			// Count Cumulative
			for (int r = 0; r < R; r++) {
				count[r + 1] = count[r] + count[r + 1];
			}

			for (int i = 0; i < N; i++) {
				aux[count[a[i].charAt(d)]++] = a[i];
			}
		}

		for (String auxStr : aux) {
			System.out.println(auxStr);
		}
	}

}
