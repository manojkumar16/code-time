package algorithmsAndDS;

public class FibonacciSum {

	public static void main(String[] args) {
		System.out.println(new FibonacciSum().howMany(70));
	}

	public int howMany(int n) {
		int[] f = new int[1000];
		f[0] = 1;
		f[1] = 1;
		int num = 0;
		while (n > 0) {
			int i = 1;
			while (f[i] <= n) {
				f[i + 1] = f[i] + f[i - 1];
				i++;
			}
			i--;
			num++;
			n -= f[i];
		}
		return num;
	}
}
