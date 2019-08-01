package algo.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FibonacciDP {

    static Map<Integer, Integer> map = new HashMap<Integer,Integer>();
    private static long start;
    private static int res;
    private static long end;
    public static void main( String[] args ) {
        int num = 40;
        //DP
        map.put( 0, 0 );
        map.put( 1, 1 );
        start = System.currentTimeMillis();
        res = new FibonacciDP().DP( num );
        Set<Integer> keys = map.keySet();
        for ( Integer key : keys ) {
            System.out.print( map.get( key ) + " " );
        }
        System.out.println();
        end = System.currentTimeMillis();
        System.out.println( "Fibonacci of " + num + " with top-down DP is " + res );
        System.out.println( "Time taken: " + ( end - start ) );
        System.out.println("===========================");
        
        start = System.currentTimeMillis();
        res = new FibonacciDP().noDP( num );
        end = System.currentTimeMillis();
        System.out.println( "Fibonacci of " + num + " without DP is " + res );
        System.out.println( "Time taken: " + ( end - start ) );
        System.out.println("===========================");
        
        start = System.currentTimeMillis();
        res = new FibonacciDP().buttom_upDP(num);
        end = System.currentTimeMillis();
        System.out.println( "Fibonacci of " + num + " with buttom-up DP is " + res );
        System.out.println( "Time taken: " + ( end - start ) );
                
    }

    private int buttom_upDP( int num ) {
        Map<Integer, Integer> fib = new HashMap<Integer, Integer>();
        for ( int k = 1; k <= num; k++ ) {
            int f = 0;
            if ( k <= 2 ) {
                f = 1;
            } else {
                f = fib.get( k - 1 ) + fib.get( k - 2 );
            }
            fib.put( k, f );
        }
        return fib.get( num );
    }

    private int DP( int n ) {
        if ( !map.containsKey( n ) ) {
            map.put( n, DP( n - 1 ) + DP( n - 2 ) );
        }
        return map.get( n );
    }

    private int noDP( int n ) {
        if ( n == 0 )
            return 0;
        if ( n == 1 )
            return 1;
        return noDP( n - 1 ) + noDP( n - 2 );
    }

}
