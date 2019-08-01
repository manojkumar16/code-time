package algo.ds;

public class ThreadJob extends Thread {
    private int counter;

    @Override
    public void run() {
        synchronized ( this ) {
            for ( int i = 0; i < 100; i++ ) {
                counter++;
            }

            this.notifyAll();
            System.out.println( "Notified thread." );
        }
    }

    public static void main( String[] args ) throws InterruptedException {
        ThreadJob job = new ThreadJob();
        job.start();
        Thread.sleep( 10 );
        synchronized ( job ) {
            System.out.println( "Waiting for one thread." );
            job.wait();
            System.out.println( "wait is over." ); // wait will never over as the thread is completed its
                                                   // execution and notifyAll call is already made before going into
                                                   // wait state.
        }

        System.out.println( job.counter );
    }

}
