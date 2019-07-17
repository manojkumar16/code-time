package multithreading;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// http://www.javacodegeeks.com/2013/02/java-7-forkjoin-framework-example.html
public class MaximumFinder extends RecursiveTask<Integer> {

    private static final int SEQUENTIAL_THRESHOLD = 5;

    private final int[] data;

    private final int start;

    private final int end;

    public MaximumFinder( int[] data, int start, int end ) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    public MaximumFinder( int[] data ) {
        this( data, 0, data.length );
    }

    @Override
    protected Integer compute() {
        final int length = end - start;
        if ( length < SEQUENTIAL_THRESHOLD ) {
            return computeDirectly();
        }
        final int split = length / 2;
        final MaximumFinder left = new MaximumFinder( data, start, start + split );
        left.fork();
        final MaximumFinder right = new MaximumFinder( data, start + split, end );
        // return max( right.compute(), left.join() );

        // either we can return by calling right.compute(), else call right.fork, and then call max
        // on right.join and left.join
        right.fork();
        return max( right.join(), left.join() );
    }

    private Integer max( Integer i, Integer j ) {
        return i > j ? i : j;
    }

    private Integer computeDirectly() {
        System.out.println( Thread.currentThread() + " computing: " + start + " to " + end );
        int max = Integer.MIN_VALUE;
        for ( int i = start; i < end; i++ ) {
            if ( data[i] > max ) {
                max = data[i];
            }
        }
        return max;
    }

    public static void main( String[] args ) {
        // create a random data set
        final int[] data = new int[30];
        final Random random = new Random();
        for ( int i = 0; i < data.length; i++ ) {
            data[i] = random.nextInt( 30 );
        }
        for ( int i = 0; i < data.length; i++ ) {
            System.out.print( data[i] + " " );
        }
        System.out.println();
        forkJoin( data );
    }

    private static void forkJoin( int[] data ) {
        // submit the task to the pool
        final ForkJoinPool pool = new ForkJoinPool( 4 );
        final MaximumFinder finder = new MaximumFinder( data );
        long start = System.currentTimeMillis();
        System.out.println( "Max element : " + pool.invoke( finder ) );
        long end = System.currentTimeMillis();
        long tt = end - start;
        System.out.println( "Total time in fork/join approach: " + tt );
    }
}