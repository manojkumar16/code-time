package etc.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import etc.one.BucketingProblem.Node;

public class BucketingProblemMain {
	Map<Integer, BucketingProblem> hm = new HashMap<Integer, BucketingProblem>();

	public static void main(String[] args) {
		new BucketingProblemMain().start();

		System.out.println();
	}

	//2,1,3
	private void start() {
		List<BucketingProblem> ls = buildGraph();

		int k = 350;

		Node found = null;
		int count=1;
		for(int i=0; i<ls.size(); i++){
			System.out.println("Looking key in graph which is having digit length "+ls.get(i).getDigitLength());
			found = ls.get(i).search(ls.get(i).getHead(), getNumber(k, ls.get(i).getDigitLength()));
			if(found !=null){
				System.out.println("We found the key: "+found+" in "+count+" loop");
				return;
			}
			count++;
		}
		
		System.out.println("key not found.");
		/*Node found = hm.get(3).search(hm.get(3).getHead(), getNumber(k, 3));
		if (found == null) {
			found = hm.get(2).search(hm.get(2).getHead(), getNumber(k, 2));
			if (found == null) {
				found = hm.get(2).search(hm.get(1).getHead(), getNumber(k, 1));
			}
		}

		if (found != null) {
			System.out.println("We found the key: " + found);
		} else {
			System.out.println("key is not found");
		}*/
	}

	private int getNumber(int key, int d) {
		String str = key + "";
		String res = str.substring(0, d);

		return Integer.parseInt(res);
	}

	private List<BucketingProblem> buildGraph() {
		BucketingProblem bp_3 = new BucketingProblem(3);
		bp_3.put(600, 650);
		bp_3.put(300, 400);
		bp_3.put(700, 710);
		bp_3.put(420, 480);
		bp_3.put(100, 115);

		BucketingProblem bp_2 = new BucketingProblem(2);
		bp_2.put(50, 60);
		bp_2.put(38, 40);
		bp_2.put(70, 90);
		bp_2.put(10, 20);
		bp_2.put(21, 29);
		bp_2.put(91, 99);

		BucketingProblem bp_1 = new BucketingProblem(1);
		bp_1.put(3, 5);
		bp_1.put(1, 2);
		bp_1.put(7, 9);

		List<BucketingProblem> ls = new ArrayList<>();
		ls.add(bp_1);
		ls.add(bp_2);
		ls.add(bp_3);
		Collections.sort(ls);
		System.out.println(ls);
		return ls;
//		buildMaxHeap(bp_3);
//		hm.put(3, bp_3);
//		hm.put(2, bp_2);
//		hm.put(1, bp_1);
	}

}
