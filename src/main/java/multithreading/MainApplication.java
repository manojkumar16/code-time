package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 1. If the thread pool has not reached the core size, it creates new threads. 
 * 2. If the core size has been reached and there is no idle threads, it queues tasks. 
 * 3. If the core size has been reached, there is no idle threads, and the queue becomes full, 
 *    it creates new threads (until it reaches the max size).
 * 4. If the max size has been reached, there is no idle threads, and the queue becomes full, 
 *    the rejection policy kicks in.
 * 
 * @author mkprasad
 * 
 */
public class MainApplication {
    final static ExecutorService ex = newCachedPool();

    final static int CORE_POOL_SIZE = 2;

    final static int MAX_CORE_POOL_SIZE = 4;

    final static long KEEP_ALIVE_TIME = 5L;

    final static int QUEUE_SIZE = 3;

    public static void main( String[] args ) throws Exception {
        try {
            MainApplication obj = new MainApplication();
            for ( int i = 0; i < 20; i++ ) {
                obj.submitTask( new Task( i ) );
            }

            ThreadPoolExecutor exx = (ThreadPoolExecutor) ex;
            while ( true ) {
                int num = ( exx ).getActiveCount();
                if ( num > 0 ) {
                    System.out.println( "Currently active threads : " + num );
                    System.out.println("Current queue size : " + exx.getQueue().size());
                    System.out.println("Current Number of threads in the pool : " + exx.getPoolSize());
                } else {
                    break;
                }
                try {
                    Thread.sleep( 1000 );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
            Thread.sleep( 10000 );
            System.out.println("Current Number of threads in the pool : " + exx.getPoolSize());
        } finally {
            System.out.println( "DONE..." );
            ex.shutdown();
        }

    }

    /**
     * It seems I have implemented bounded cached thread pool!!!
     * 
     * @return
     */
    private static ExecutorService newCachedPool() {
        /*
         * ExecutorService executor = new ThreadPoolExecutor( CORE_POOL_SIZE, MAX_CORE_POOL_SIZE, KEEP_ALIVE_TIME,
         * TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>( QUEUE_SIZE ), Executors.defaultThreadFactory(), new
         * ThreadPoolExecutor.CallerRunsPolicy() );
         */

        /*
         * ExecutorService executor = new ThreadPoolExecutor( CORE_POOL_SIZE, MAX_CORE_POOL_SIZE, KEEP_ALIVE_TIME,
         * TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>( QUEUE_SIZE ) );
         */

        ScalingQueue<Runnable> queue = new ScalingQueue<Runnable>();

        ThreadPoolExecutor executor = new ThreadPoolExecutor( CORE_POOL_SIZE, MAX_CORE_POOL_SIZE, KEEP_ALIVE_TIME,
            TimeUnit.SECONDS, queue );
        executor.setRejectedExecutionHandler( new ForceQueuePolicy() );
        queue.setThreadPoolExecutor( executor );

        return executor;
        // return Executors.newFixedThreadPool( 5 );
    }

    private void submitTask( Task task ) {
        ex.submit( task );
    }

}
