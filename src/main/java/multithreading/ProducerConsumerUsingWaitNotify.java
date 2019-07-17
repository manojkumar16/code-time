package multithreading;
import java.util.Stack;

public class ProducerConsumerUsingWaitNotify {
    Stack<Integer> items = new Stack<Integer>();

    static final int MAX_ITEMS = 5;

    static ProducerConsumerUsingWaitNotify ob = new ProducerConsumerUsingWaitNotify();

    public static void main( String[] args ) {
        new Thread( ob.new Consumer() ).start();
        new Thread( ob.new Producer() ).start();
    }

    class Producer implements Runnable {

        public Producer() {

        }

        @Override
        public void run() {
            while ( true ) {
                synchronized ( items ) {
                    if ( items.size() < MAX_ITEMS ) {
                        int i = (int) ( Math.random() * 100 );
                        System.out.println( "produced : " + i );
                        items.push( i );
                        items.notifyAll();
                    } else {
                        System.out.println("Producer is waiting for consumer to consume.");
                        try {
                            items.wait();
                        } catch ( InterruptedException e ) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    class Consumer implements Runnable {
        public Consumer() {
        }

        @Override
        public void run() {
            while ( true ) {
                synchronized ( items ) {
                    if ( !items.isEmpty() ) {
                        System.out.println( items.pop() + " is consumed." );
                        items.notifyAll();
                    } else {
                        System.out.println("Consumer is waiting for producer to produce.");
                        try {
                            items.wait();
                        } catch ( InterruptedException e ) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
