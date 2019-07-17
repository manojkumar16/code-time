package etc;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Option3 implements Runnable {
    final CyclicBarrier barrier = new CyclicBarrier( 2 ); // for the main thread and the one it starts

    final StringBuffer result = new StringBuffer();

    public static void main( String[] args ) throws InterruptedException, BrokenBarrierException, TimeoutException {
        Option3 p = new Option3();
        Thread t = new Thread( p );
        t.setDaemon( true );
        t.start();
       // p.barrier.await( 5, TimeUnit.SECONDS );
        p.barrier.await();
        //Thread.sleep( 20 );
        System.out.println( p.result );
    }

    @Override
    public void run() {
        result.append( "mkpp" );
        try {
            barrier.await();
            Thread.sleep( 10 );
            result.append( "Question: will this msg be seen before program exits?" );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}
