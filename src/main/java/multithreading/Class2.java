package multithreading;

import java.util.concurrent.Semaphore;

public class Class2 {

    private Semaphore semaphore;

    private boolean b1 = false;

    private boolean b2 = false;

    public void start( int num ) throws InterruptedException {
        System.out.println( "Class2" );

        if ( num > 0 && num <= 2 ) {
            System.out.println( "b1:" + b1 );
            b1 = true;
        } else if ( num > 3 && num <= 5 ) {
            System.out.println( "b2:" + b2 );
            b2 = true;
        }

        if ( b1 && b2 ) {
            semaphore.release();
        }
    }

    public Semaphore getSemaphore() throws InterruptedException {
        if ( semaphore == null ) {
            semaphore = new Semaphore( 1 );
            semaphore.acquire();
        }
        return this.semaphore;
    }
}
