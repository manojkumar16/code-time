package multithreading;
/**
 * yield() method pauses the currently executing thread temporarily for giving a chance to the remaining waiting threads
 * of the same priority to execute. If there is no waiting thread or all the waiting threads have a lower priority then
 * the same thread will continue its execution. The yielded thread when it will get the chance for execution is decided
 * by the thread scheduler whose behavior is vendor dependent.
 * 
 * @author mkprasad
 * 
 */
public class YieldExample {

    public static void main( String[] args ) {
        new YieldExample().test();
    }

    private void test() {
        Thread t1 = new Thread( new YieldRunnable( "t1", 1 ) );
        Thread t2 = new Thread( new YieldRunnable( "t2", 2 ) );
        Thread t3 = new Thread( new YieldRunnable( "t3", 3 ) );
        Thread t4 = new Thread( new YieldRunnable( "t4", 4 ) );
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    class YieldRunnable implements Runnable {

        private String name;

        private int n;

        public YieldRunnable( String name, int n ) {
            this.name = name;
            this.n = n;
        }

        // This is WRONG...
        @Override
        public void run() {
            if ( n == 2 ) {
                System.out.println( "Pause thread " + this.name );
                Thread.yield();
                System.out.println( "Finished execution of thread " + this.name );
            } else {
/*                try {
                    Thread.sleep( 1000 );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }*/
                System.out.println( "Executed thread " + this.name );
            }
        }
    }
}
