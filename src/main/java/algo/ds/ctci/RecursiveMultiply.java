package algo.ds.ctci;

/**
 * Recursive Multiply: Write a recursive function to multiply two positive
 * integers without using the * operator (or / operator). You can use addition,
 * subtraction, and bit shifting, but you should minimize the number of those
 * operations.
 * 
 * @author m0k00i6
 *
 */
public class RecursiveMultiply {

	public static void main(String[] args) {
		// int res = minProduct2(7, 8);
		int res = minProduct(7, 8);
		System.out.println(res);
	}

	private static int minProduct(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		return minProductHelper(smaller, bigger);
	}

	private static int minProductHelper(int smaller, int bigger) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		}
		// Compute half. If uneven, compute other half. If even, double it
		int s = smaller >> 1; // Divide by 2

		int halfProd = minProduct(s, bigger);
		if (smaller % 2 == 0) { // even
			return halfProd + halfProd;
		} else {
			return halfProd + halfProd + bigger;
		}
	}

	private static int minProduct2(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		return minProductHelper2(smaller, bigger);
	}

	private static int minProductHelper2(int smaller, int bigger) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		}
		// Compute half. If uneven, compute other half. If even, double it
		int s = smaller >> 1; // Divide by 2
		int side1 = minProduct2(s, bigger);
		int side2 = side1;
		if (smaller % 2 == 1) {
			side2 = minProductHelper2(smaller - s, bigger);
		}
		return side1 + side2;
	}

}
