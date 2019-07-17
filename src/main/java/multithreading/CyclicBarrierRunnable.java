package multithreading;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierRunnable implements Runnable {

    CyclicBarrier barrier1 = null;
    private String name;

    public CyclicBarrierRunnable( String name, CyclicBarrier barrier1 ) {
        this.barrier1 = barrier1;
        this.name = name;
    }

    @Override
    public void run() {
        try {
          //  Thread.sleep( 1000 );
            System.out.println( name + " waiting at barrier. Performing some tasks." );
            this.barrier1.await();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        } catch ( BrokenBarrierException e ) {
            e.printStackTrace();
        }
    }

}
