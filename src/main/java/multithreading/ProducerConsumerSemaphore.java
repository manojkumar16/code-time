package multithreading;
import java.util.Stack;
import java.util.concurrent.Semaphore;

public class ProducerConsumerSemaphore {
    public static Stack<Integer> items = new Stack<Integer>();
    public static ProducerConsumerSemaphore ob = new ProducerConsumerSemaphore();
    
    public static void main( String[] args ) {
        Semaphore sp = new Semaphore( 5 );
        Semaphore sc = new Semaphore( 0 );

        new Thread(ob.new Producer(sp, sc)).start();
        new Thread(ob.new Consumer(sp, sc)).start();
    }

    class Producer implements Runnable {
        
        private Semaphore sp;
        private Semaphore sc;

        public Producer( Semaphore sp, Semaphore sc ) {
            this.sp = sp;
            this.sc = sc;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    sp.acquire();
                    int i = (int) ( Math.random()*100 );
                    items.push( i );
                    System.out.println( "produced : " + i );
                    sc.release();
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
        }

    }

    class Consumer implements Runnable {

        private Semaphore sp;
        private Semaphore sc;

        public Consumer( Semaphore sp, Semaphore sc ) {
            this.sp = sp;
            this.sc = sc;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    sc.acquire();
                    System.out.println( items.pop() + " is consumed." );
                    sp.release();
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
        }

    }

}
