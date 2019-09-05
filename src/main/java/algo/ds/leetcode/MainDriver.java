package algo.ds.leetcode;

public class MainDriver {

	public static void main(String[] args) {

		long numberOfInts = (long) Integer.MAX_VALUE + 1;
		byte[] bitfield = new byte[(int) (100)];
		
		int n = 10;

//		int x = 1<< (n % 8);
//		int index = n / 8;
//		bitfield [index] |= x;
		
		bitfield [n / 8] |= 1 << (n % 8);
		
		System.out.println();
	}

}
