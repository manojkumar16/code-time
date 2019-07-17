package multithreading;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierMain {

    public static void main( String[] args ) {
        int parties = 5;
        CyclicBarrier barrier = new CyclicBarrier( parties, new Runnable() {
            public void run() {
                System.out.println( "BarrierAction is executed " );
            }
        } );

        for ( int i = 0; i < parties; i++ ) {
            new Thread( new CyclicBarrierRunnable( i + "", barrier ) ).start();
        }
    }
}
