package algo.ds;

import java.util.Stack;

public class StackPractice {

    public static void main( String[] args ) {
        stackToQueue();
    }

    private static void stackToQueue() {
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();

        st1.push( 1 );
        st1.push( 2 );
        st1.push( 3 );

        st2.push( st1.pop() );
        st2.push( st1.pop() );
        st2.push( st1.pop() );

        while ( st2.size() > 0 )
            System.out.print( st2.pop() +", ");
    }

}
