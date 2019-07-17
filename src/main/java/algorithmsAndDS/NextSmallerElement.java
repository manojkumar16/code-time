package algorithmsAndDS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextSmallerElement {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] strArr = str.split(",");
		int arr[] = new int[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		// int arr[] = { 4,5,2,25 };
		// int arr[] = {13, 7, 6, 12, 4};
		int[] res = getNextSmallerElementArray(arr);
		for (int i = 0; i < res.length - 1; i++) {
			System.out.print(res[i] + ",");
		}
		System.out.print(res[res.length - 1]);
	}

	/**
     *  (Using Stack)
     *1) Push the first element to stack.
2) Pick rest of the elements one by one and follow following steps in loop.
	a) Mark the current element as next.
	b) If stack is not empty, then pop an element from stack and compare it with next.
	c) If next is smaller than the popped element, then next is the next smaller element for the popped element.
	d) Keep popping from the stack while the popped element is greater than next. next becomes the next smaller element for all such popped elements
	g) If next is greater than the popped element, then push the popped element back.
	h) push next to stack so that we can find next smaller for it
	3) After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them
     */
	private static int[] getNextSmallerElementArray(int[] arr) {
		Map<Integer,Integer> hm = new HashMap<>();
        Stack<Integer> s = new Stack<Integer>();
        /* push the first element to stack */
        s.push( arr[0] );

        // iterate for rest of the elements
        for ( int i = 1; i < arr.length; i++ ) {
            int next = arr[i];
            // if stack is not empty, then pop an element from stack
            while ( !s.isEmpty() ) {
                int poppedElement = s.pop();
                /*
                 * If the popped element is greater than next, then a) print the pair b) keep popping while elements are
                 * greater and stack is not empty
                 */
                if ( poppedElement > next ) {
                	hm.put(poppedElement, next);
                } else {
                    /*
                     * If element is smaller than next, then push the element back
                     */
                    s.push( poppedElement );
                    break;
                }
            }
            /*
             * push next to stack so that we can find next smaller for it
             */
            s.push( arr[i] );
        }
        /*
         * After iterating over the loop, the remaining elements in stack do not have the next greater element, so print
         * -1 for them
         */
        while ( !s.isEmpty() ) {
        	hm.put(s.pop(), -1);
        }
        int[] res = new int[arr.length];
        for(int i=0;i<arr.length;i++){
        	res[i] = hm.get(arr[i]);
        }
        return res;
    }

}