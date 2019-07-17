package multithreading;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * http://www.coderanch.com/t/619139/threads/java/Thread-Implementation-asked-interview
 * 
 * Have three thread T1 , T2 , T3 and 3 Arrays a1[1,4,7] , a2[2,5,8] ,a3[3,6,9] now the thread T1 will have array a1 and
 * T2 --> a2 and T3 --> a3
 * 
 * We will start all 3 threads in the main thread and they should run in such a way that the output is
 * 1,2,3,4,5,6,7,8,9.
 * 
 * @author mkprasad
 * 
 */
public class TestLocks {

    public static void main( String[] args ) throws InterruptedException {
        int[] a1 = { 1, 4, 7 };
        int[] a2 = { 2, 5, 8 };
        int[] a3 = { 3, 6, 9 };
        LocksTrial locksTrial1 = new LocksTrial( a1, a2, a3 );

        new Thread( locksTrial1 ).start();
        Thread.sleep( 10 );
        new Thread( locksTrial1 ).start();
        Thread.sleep( 10 );
        new Thread( locksTrial1 ).start();
    }

}

class LocksTrial implements Runnable {
    AtomicInteger i = new AtomicInteger( 0 );

    int[] a1;

    int[] a2;

    int[] a3;

    int count = 0;

    ReentrantLock lock = new ReentrantLock();

    Condition condition = lock.newCondition();

    public LocksTrial( int[] a1, int[] a2, int[] a3 ) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    @Override
    public void run() {
        while ( i.get() < 9 ) {
            printA1();
            printA2();
            printA2();
        }
        /*
         * if ( i.get() == 0 ) { printA1(); i.incrementAndGet(); } else if ( i.get() == 1 ) { printA2();
         * i.incrementAndGet(); } else { printA3(); }
         */
    }

    public void printA1() {
        lock.lock();
        try {
            if ( count % 3 != 0 ) {
                condition.await();
            }
            System.out.print( a1[count / 3] + "  " );
            count++;
            condition.signal();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printA2() {
        lock.lock();
        try {
            if ( count % 3 != 1 ) {
                condition.await();
            }
            System.out.print( a2[count / 3] + "  " );
            count++;
            condition.signal();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printA3() {
        lock.lock();
        try {
            if ( count % 3 != 2 ) {
                condition.await();
            }
            System.out.print( a3[count / 3] + "  " );
            count++;
            condition.signal();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void testLock1() {
        System.out.println( "TESTLOCK 1" );
        lock.lock();
        try {
            while ( count == 0 ) {
                System.out.println( "Count now await:" + count );
                condition.await();
                System.out.println( "Count now after await:" + count );

            }
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println( "Lock1 released" );
        }
    }

    public void testLock2() {
        System.out.println( "TESTLOCK 2" );
        lock.lock();
        try {
            count++;
            condition.signal();
            System.out.println( "Count now signal:" + count );
        } finally {
            lock.unlock();
            System.out.println( "Lock2 released" );
        }
    }

}
