package multithreading;
import java.util.ArrayList;
import java.util.List;

// http://tutorials.jenkov.com/java-concurrency/thread-pools.html
public class ThreadPool {
    BlockingQueue taskQueue = null;

    private List<PoolThread> threads = new ArrayList<PoolThread>();

    private boolean isStopped = false;

    public ThreadPool( int noOfThreads, int maxNoOfTasks ) {
        taskQueue = new BlockingQueue( maxNoOfTasks );
        for ( int i = 0; i < noOfThreads; i++ ) {
            threads.add( new PoolThread( taskQueue ) );
        }

        for ( PoolThread thread : threads ) {
            thread.start();
        }
    }

    public synchronized void execute( Runnable task ) throws InterruptedException {
        if ( this.isStopped ) {
            throw new IllegalStateException( "ThreadPool is stopped" );
        }
        this.taskQueue.enqueue( task );
    }

    public synchronized void stop() {
        this.isStopped = true;
        for ( PoolThread thread : threads ) {
            thread.stop();
        }
    }
}
