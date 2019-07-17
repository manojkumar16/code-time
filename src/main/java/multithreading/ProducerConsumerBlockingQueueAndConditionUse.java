package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerBlockingQueueAndConditionUse {

    public static void main( String[] args ) {
        BlockingQueueImpl q = new BlockingQueueImpl( 10 );
        Producer p = new Producer( q );
        Consumer q1 = new Consumer( q );
        Consumer q2 = new Consumer( q );
        new Thread( p ).start();
        new Thread( q1 ).start();
        new Thread( q2 ).start();
    }

}

class Producer implements Runnable {
    private final BlockingQueueImpl queue;

    public Producer( BlockingQueueImpl q ) {
        this.queue = q;
    }

    @Override
    public void run() {
        while ( true ) {
            try {
                queue.put( produce() );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }

    private Object produce() {
        // TODO Auto-generated method stub
        return null;
    }

}

class Consumer implements Runnable {
    private final BlockingQueueImpl queue;

    public Consumer( BlockingQueueImpl q ) {
        this.queue = q;
    }

    @Override
    public void run() {
        while ( true ) {
            try {
                consume( queue.take() );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }
        }
    }

    private void consume( Object take ) {
        // TODO Auto-generated method stub

    }
}

class BlockingQueueImpl {
    final Lock lock = new ReentrantLock();

    final Condition notFull = lock.newCondition();

    final Condition notEmpty = lock.newCondition();

    private final int size;

    final List<Object> items = new ArrayList<Object>();

    int putptr, takeptr, count;

    public BlockingQueueImpl( int s ) {
        size = s;
    }

    public void put( Object x ) throws InterruptedException {
        lock.lock();
        try {
            while ( items.size() == size ) {
                notFull.await();
            }
            putNow( x );
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    private void putNow( Object x ) {
        items.add( x );
        count++;
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while ( items.size() == 0 ) {
                notEmpty.await();
            }
            Object x = takeNow();
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

    private Object takeNow() {
        Object x = items.get( count );
        count--;
        return x;
    }

}