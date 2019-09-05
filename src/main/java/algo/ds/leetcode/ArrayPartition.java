package algo.ds.leetcode;

public class ArrayPartition {

	public static void main(String[] args) {
		new ArrayPartition().start();

	}

	private void start() {
		int[] a = new int[] { 2, 1, 2, 3, 4, 1, 2, 3, 6, 7, 8, 6, 2 };
		int n = a.length;
		int head = 0;

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int maxIndex=-1;
		int minIndex=-1;
		int maxCount=0;
		int minCount=0;
		int count = 0;
		int skipCount = 0;
		while (head < n) {
			for (int i = head; i < n; i++) {
				if (max < a[i]) {
					max = a[i];
					maxIndex = i;
				}
				if (min > a[i]) {
					min = a[i];
					minIndex = i;
				}
			}
			
			if(minIndex > maxIndex) {
				
			}
			head = max + min;
			count = count + 2;
		}
		
		System.out.println(count);

	}

}
