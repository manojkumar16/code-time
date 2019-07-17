package multithreading;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * If there are no threads, the task will be rejected. In our case, if the task is rejected, we would like to put it
 * back to the queue. This is a simple thing to do with ThreadPoolExecutor since we can implement our own
 * RejectedExecutionHandler:
 * 
 * @author mkprasad
 * 
 */
public class ForceQueuePolicy implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution( Runnable r, ThreadPoolExecutor executor ) {
        try {
            executor.getQueue().put( r );
        } catch ( InterruptedException e ) {
            // should never happen since we never wait
            throw new RejectedExecutionException( e );

        }
    }

}
