package algo.ds;

import java.util.Stack;

public class Recursion {
    public static Stack<Integer> st = new Stack<Integer>();
    public static void main( String[] args ) {
        
        /*int arr2[] = {12, 10, 30, 50, 100};
        int n = fun2(arr2, 5);
        System.out.println(n);
        *///  fun(4);
        
        fun3(4);
        System.out.println("\n=============================================");
 
        int[] arr = new int[] { 9, 5, 2, 8, 4, 1, 23, 17 };
        selectionSort( arr, 0, arr.length - 1 );

        for ( int i = 0; i < arr.length; i++ ) {
            System.out.print( arr[i] + ", " );
        }
    }

    private static void fun3( int n ) {
        if(n > 0)
        {
            fun3(n-1);
            System.out.print(n+", ");
            fun3(n-1);
        }        
    }

    private static int fun2( int[] a, int n ) {
        int x;
        if ( n == 1 )
            return a[0];
        else {
            st.push( n - 1 );
            x = fun2( a, n - 1 );
            st.pop();
        }
        if ( x > a[n - 1] )
            return x;
        else
            return a[n - 1];
    }

    private static void fun( int x ) {
        if(x > 0)
        {
           st.push( x -1 );
           fun(--x);
           st.pop();
           System.out.print(x+"  ");
           st.push( x -1 );
           fun(--x);
           st.pop();
        }
    }

    private static void selectionSort( int[] arr, int start, int end ) {

        if ( start >= end ) {
            return;
        }

        int min_ind = MIN( arr, start, end );

        int temp = arr[start];
        arr[start] = arr[min_ind];
        arr[min_ind] = temp;

        selectionSort( arr, start + 1, end );
    }

    private static int MIN( int[] arr, int start, int end ) {
        int min = arr[start];
        int index = start;

        for ( int i = start+1; i < arr.length; i++ ) {
            if ( min > arr[i] ) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

}
