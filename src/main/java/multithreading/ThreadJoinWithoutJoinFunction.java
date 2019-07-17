package multithreading;
public class ThreadJoinWithoutJoinFunction {

    public static void main( String[] args ) {
        MyThread t1 = createNewThread( "T1", 0, 25 );
        MyThread t2 = createNewThread( "T2", 25, 50 );
        MyThread t3 = createNewThread( "T3", 50, 75 );

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();

    }

    private static MyThread createNewThread( final String T, final int i, final int j ) {
        MyThread t = new MyThread( new Runnable() {
            @Override
            public void run() {
                int k = i;
                System.out.print( T + ": " );
                while ( k < j ) {
                    System.out.print( k + " " );
                    k++;
                    try {
                        Thread.sleep( 10 );
                    } catch ( InterruptedException e ) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
            }
        } );
        return t;
    }

}

class MyThread {
    private Thread t;

    public MyThread( Runnable r ) {
        t = new Thread( r );
    }

    public void start() {
        t.start();
    }

    public void join() {
        while ( t.isAlive() ) {
            // do nothing
        }
    }
}