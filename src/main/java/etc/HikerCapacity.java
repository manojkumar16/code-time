package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A climber climbs up the mountain and after reaching at peak, he goes down.
 * The metrics to measure climber capacity is a range where he either starts
 * climbing up to one peak, then come down OR he starts going down from one peak
 * and then climb up to next peak. Since range is important metrics for a
 * climber, write a program that computes the longest distance covered by
 * climbing up then down, or vice versa.
 * 
 * Assume, distance covered by climber is measured in terms of Altitude.
 * Climbing up means, increase in Altitude and climbing down means, decrease in
 * Altitude. Also assume, Climber covers some distance, take rest, resume
 * climbing again. For example, If the Climber's distance covered are:
 * 5,6,7,4,3,2,8,10,12,6 Here, [5,6,7] means, Climber is climbing up the
 * mountain, next element in array is '4' that means, climber is going down from
 * peak which is 3rd element '7'. The longest distance of climbing up/down is
 * 46. [7,4,3,28,10,12]
 * 
 * Constraints:
 * 
 * @author mkuma22
 * 
 */
public class HikerCapacity {

	public static void main(String[] args) throws IOException {
	//	int[] a = { 5, 6, 7, 4, 3, 2, 8, 10, 12, 6 }; //46
		//int[] a = { 9, 7, 8, 2, 5, 10, 7 }; //25
		//int[] a = { 9, 7, 8, 2, 5, 10, 9 }; // 26
		//int[] a = {10,8,10,8,10,8,7,10}; // 35
		//int[] a = {10,8,10,8,4,5,6,2,3,9,4,8}; // 33
	//	int[] a = {6,3,4};//13

		//System.out.println(longest_distance(a));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] strArr = str.split(",");
		int arr[] = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		// int arr[] = { 4,5,2,25 };
		// int arr[] = {13, 7, 6, 12, 4};
		int res = maxHikerCapacity(arr);
		System.out.print(res);
	}

	private static int maxHikerCapacity(int[] dist) {
		int max = -1;
		List<Integer> ls = new ArrayList<Integer>();
		ls.add(0);
		boolean asc = false;
		if (dist[1] > dist[0]) {
			asc = true;// ascending order
		}
		int flip_ind = -1;

		for (int i = 1; i < dist.length; i++) {

			if ((dist[i] >= dist[i - 1]) && !asc) {// it was descending. not
												// ascending. update flip_ind
				flip_ind = i - 1;
				ls.add(flip_ind);
				asc = !asc;
			} else if ((dist[i] < dist[i - 1]) && asc) {// it was ascending. not
													// descending. update
													// flip_ind
				flip_ind = i - 1;
				ls.add(flip_ind);
				asc = !asc;
			} else if (asc) {
				//System.out.println("a");
			} else {
				//System.out.println("d");
			}
		}
		ls.add(dist.length - 1);
/*		for (int i = 0; i < ls.size(); i++) {
			System.out.print(ls.get(i) + "  ");
		}
		System.out.println("\n-----");
*/
		// Not optimized solution. Look for better solution from students :)
		for (int i = 0; i < ls.size() - 2; i++) {
			int sum = getsum(dist, ls.get(i), ls.get(i + 2));
			if (max < sum) {
				max = sum;
			}
		}

		return max;
	}

	private static int getsum(int[] a, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum = sum + a[i];
		}
		return sum;
	}
}
