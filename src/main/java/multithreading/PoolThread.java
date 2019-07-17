package multithreading;
public class PoolThread extends Thread {

    private BlockingQueue taskQueue = null;

    private boolean isStopped = false;

    public PoolThread( BlockingQueue task ) {
        this.taskQueue = task;
    }

    public void run() {
        while ( !isStopped() ) {
            try {
                Runnable r = (Runnable) taskQueue.dequeue();
                r.run();
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void stopThread() {
        isStopped = true;
        this.interrupt(); // break pool thread out of dequeue() call.
    }

    public synchronized boolean isStopped() {
        return isStopped;
    }
}
