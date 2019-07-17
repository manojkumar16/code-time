package multithreading;
/**
 * You have two threads one printing even numbers in order and other odd numbers. 
 * Design an algorithm so that it prints numbers in natural order
 * 
 * @author mkprasad
 * 
 */
public class ThreadSynchronize {

    public static void main( String[] args ) throws InterruptedException {

        Object lock = new Object();
//        Runnable evenThread = new StaticNonStatic( 0, lock );
//        Runnable oddThread = new StaticNonStatic( 1, lock );
        Runnable evenThread = new Counter( 0, lock );
        Runnable oddThread = new Counter( 1, lock );
        Thread evenWorker = new Thread( evenThread );
        Thread oddWorker = new Thread( oddThread );
        evenWorker.start();
        Thread.sleep( 1000 );
        oddWorker.start();

    }

}

class Counter implements Runnable {

    private int start;

    private Object lock;

    public Counter( int seed, Object lock ) {
        start = seed;
        this.lock = lock;

    }

    @Override
    public void run() {

        while ( true ) {
            start += 2;
            System.out.println( start );
            synchronized ( lock ) {
                try {
                    // T1 comes and notify other threads, then it goes to wait state. Since, there is only one thread out there(T2),
                    //T2 will come and put a lock on it. Then it noties other threads(now, T1 is in waiting state, not T2)
                    lock.notify();
                    lock.wait();
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }

            }
        }

    }
}