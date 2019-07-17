package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class DeadLockUsingTwoObjects {

    public static void main( String args[] ) throws InterruptedException {
        AtomicInteger i = new AtomicInteger( 5 );
        AtomicInteger j = new AtomicInteger( 10 );

        Thread t1 = new Thread( new T( "A", i, j ) );
        Thread t2 = new Thread( new T( "B", j, i ) );

        t1.start();
        //Thread.sleep( 10 ); // put sleep and deadlock possibility will become very low
        t2.start();

        t1.join(); // comment out join and non-deadlock possibility will become very low 
        t2.join();
        System.out.println( "We got lucky." );
    }
}

class T implements Runnable {
    String name;

    AtomicInteger i;

    AtomicInteger j;

    public T( String name, AtomicInteger i, AtomicInteger j ) {
        this.name = name;
        this.i = i;
        this.j = j;
    }

    @Override
    public void run() {
        synchronized ( i ) {
            System.out.println( this.name + " locked resource  " + i + " waiting for resource " + j );
/*            try {
                Thread.sleep( 500 );
            } catch ( InterruptedException e ) {
                e.printStackTrace();
            }*/

            synchronized ( j ) {
                System.out.println( this.name + " got both resources " );
            }
        }
        System.out.println(this.name +" released both resources");
        System.out.println("==============");
    }
}
