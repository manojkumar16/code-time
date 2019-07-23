package algorithmsAndDS;

/**
 * Max Sum increasing subsequence
 * WRONG SOLUTION!!!
 * 
 * @author m0k00i6
 *
 */
public class WalmartPolaris {

	public static void main(String[] args) {
		int[] a = new int[] { 1, 202, 3, 200 }; // 204
		// {1,202,3,200}

		// 1,3,200 > 204
		// {1, 202, 3, 200}

		int max_sub = 0;

		for (int i = 0; i < a.length; i++) { // {1, 202, 3, 200}

			int prev_found_element = a[i]; // 1, ????
			int max_so_far = a[i]; // 1

			for (int j = i + 1; j < a.length; j++) {

				if (a[j] >= prev_found_element) {
					max_so_far = max_so_far + a[j]; // 1 + 202 = 203

					prev_found_element = a[j]; // 202
				}
			}

			if (max_sub < max_so_far) {
				max_sub = max_so_far; // 203
			}

		}

		System.out.print(max_sub);
	}

}
