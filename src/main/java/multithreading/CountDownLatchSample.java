package multithreading;
import java.util.concurrent.CountDownLatch;
public class CountDownLatchSample {
    public static void main(String args[]) throws InterruptedException {
        new CountDownLatchSample().start();
    }
    public void start() throws InterruptedException {
        int N = 10;
        CountDownLatch startSignal = new CountDownLatch( 1 );
        CountDownLatch doneSignal = new CountDownLatch( N );

        // create and start threads
        for ( int i = 0; i < N; ++i )
            new Thread( new Worker( startSignal, doneSignal ) ).start();

        doSomethingElse("1"); // don't let run yet
        startSignal.countDown(); // let all threads proceed
        Thread.sleep( 1 );
        doSomethingElse("2");
        doneSignal.await(); // wait for all to finish
        doSomethingElse( "3" );
    }
    private void doSomethingElse(String msg) {
        System.out.println( "Do something else-" + msg );
    }
}
class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    Worker( CountDownLatch startSignal, CountDownLatch doneSignal ) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }
    public void run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch ( InterruptedException ex ) {
        } // return;
    }
    void doWork() {
        System.out.println( "do thread Worker work." );
    }
}