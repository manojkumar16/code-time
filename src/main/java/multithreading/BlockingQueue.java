package multithreading;
import java.util.LinkedList;
import java.util.List;

//Use Lock, Condition instead of synchronized
//Lock --> synchronized
//Condition --> wait, notify, notifyAll
public class BlockingQueue {
    private List queue = new LinkedList();

    private int limit = 10;

    public BlockingQueue( int limit ) {
        this.limit = limit;
    }

    public synchronized void enqueue( Object item ) throws InterruptedException {
        while ( queue.size() == limit ) {
            wait();
        }
        if ( queue.size() == 0 ) {
            notifyAll();
        }
        queue.add( item );
    }

    public synchronized Object dequeue() throws InterruptedException {
        while ( queue.size() == 0 ) {
            wait();
        }
        if ( queue.size() == limit ) {
            notifyAll();
        }
        return queue.remove( 0 );
    }
}
