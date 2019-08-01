package etc.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindWeights {

	public static void main(String[] args) {
		System.out.println(find_weights(40));
	}

	private static List<Integer> find_weights(int W) {
		List<Integer> weights = new ArrayList<Integer>();
		int i = 0;
		while (sum(weights) < W) {
			weights.add(pow(3,i));
			i++;
		}
//		weights.push(W - sum(weights));

		return weights;
	}

	private static Integer pow(int n, int count) {
		int k = 1;
		if(count==0) return 1;
		for(int i=0; i<count;i++){
			k = k*3;
		}
		return null;
	}

	private static int sum(List<Integer> weights) {
		int sum = 0;
		for(Integer i : weights){
			sum = sum+i;
		}
		return sum;
	}

}
