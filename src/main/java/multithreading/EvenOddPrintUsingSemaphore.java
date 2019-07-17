package multithreading;

import java.util.concurrent.Semaphore;

// Given two threads even and odd, print numbers in sequence using Semaphore
public class EvenOddPrintUsingSemaphore implements Runnable {
    static Semaphore s = new Semaphore( 1 );

    static Semaphore t = new Semaphore( 0 );

    private boolean iseven;

    private int count;

    public EvenOddPrintUsingSemaphore( boolean even, int count ) {
        this.iseven = even;
        this.count = count;
    }

    public static void main( String[] args ) throws InterruptedException {
        Thread even = new Thread( new EvenOddPrintUsingSemaphore( true, 20 ) );
        Thread odd = new Thread( new EvenOddPrintUsingSemaphore( false, 20 ) );

        odd.start();
        even.start();
    }

    @Override
    public void run() {
        try {
            if ( iseven ) {
                printEven( count );
            } else {
                printOdd( count );
            }
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

    private void printOdd( int count2 ) throws InterruptedException {
        for ( int i = 1; i <= count2; i = i + 2 ) {
            s.acquire();
            System.out.print( i + " " );
            t.release();
        }
    }

    private void printEven( int count2 ) throws InterruptedException {
        for ( int i = 2; i <= count2; i = i + 2 ) {
            t.acquire();
            System.out.print( i + " " );
            s.release();
        }
    }

}
