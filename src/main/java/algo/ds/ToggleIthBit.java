package algo.ds;

/**
 * Toggle ith bit in biven bit vector/integer
 * 
 * @author m0k00i6
 *
 */
public class ToggleIthBit {

	public static void main(String[] args) {
		int bitVector = 0; // output 8
		//int bitVector = 40; // output 32
		bitVector = toggle(bitVector, 3);

		System.out.println(bitVector);
	}

	private static int toggle(int bitVector, int index) {
		if (index < 0) {
			return bitVector;
		}

		int mask = 1 << index;
		if ((bitVector & mask) == 0) {
			return bitVector | mask;
		} else {
			return bitVector & ~mask;
		}
	}

}
