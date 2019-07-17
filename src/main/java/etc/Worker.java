package etc;
import java.util.concurrent.CountDownLatch;


public class Worker implements Runnable {

    private CountDownLatch doneSignal;

    public Worker( CountDownLatch doneSignal ) {
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            Thread.sleep( 5000 );
            doneSignal.countDown();
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

}
