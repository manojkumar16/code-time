package algo.ds;

import java.util.Stack;

/**
 * 
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is
 * the first greater element on the right side of x in array. Elements for which no greater element exist, consider next
 * greater element as -1.
 * 
 * Examples: a) For any array, rightmost element always has next greater element as -1. 
 * b) For an array which is sorted in decreasing order, all elements have next greater element as -1. 
 * c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
 * Element       NGE
   4      -->   5
   5      -->   25
   2      -->   25
   25     -->   -1
   
   http://www.geeksforgeeks.org/next-greater-element/
 * 
 */
public class NextGreaterElement {

    public static void main( String[] args ) {
        //int arr[] = { 11, 13, 21, 3 };
        int arr[] = { 4,5,2,25 };
        printNGE( arr );
    }

    /**
     *  (Using Stack)
     *1) Push the first element to stack.
2) Pick rest of the elements one by one and follow following steps in loop.
....a) Mark the current element as next.
....b) If stack is not empty, then pop an element from stack and compare it with next.
....c) If next is greater than the popped element, then next is the next greater element for the popped element.
....d) Keep popping from the stack while the popped element is smaller than next. next becomes the next greater element for all such popped elements
....g) If next is smaller than the popped element, then push the popped element back.
....h) push next to stack so that we can find next greater for it
3) After the loop in step 2 is over, pop all the elements from stack and print -1 as next element for them
     */
    private static void printNGE( int[] arr ) {
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
                 * If the popped element is smaller than next, then a) print the pair b) keep popping while elements are
                 * smaller and stack is not empty
                 */
                if ( poppedElement < next ) {
                    System.out.println( poppedElement + " ---> " + next );
                } else {
                    /*
                     * If element is greater than next, then push the element back
                     */
                    s.push( poppedElement );
                    break;
                }
            }
            /*
             * push next to stack so that we can find next greater for it
             */
            s.push( arr[i] );
        }
        /*
         * After iterating over the loop, the remaining elements in stack do not have the next greater element, so print
         * -1 for them
         */
        while ( !s.isEmpty() ) {
            System.out.println( s.pop() + " ---> -1" );
        }
    }

}
