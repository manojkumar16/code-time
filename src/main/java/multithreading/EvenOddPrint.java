package multithreading;

/**
 * Given two threads even and odd, print numbers in sequence.
 * 
 * @author mkprasad
 * 
 */
public class EvenOddPrint {
    final String str = "hello";
    public static void main( String[] args ) {
        
        new EvenOddPrint().incrementAndPrint();
        System.out.println( "done" );
    }

    private void incrementAndPrint() {
        Runnable even = new Runnable() {
            @Override
            public void run() {
                while ( true ) {
                    IncrementAndPrint.incrementAndPrint( true );
                    if ( IncrementAndPrint.c == 100 ) {
                        return;
                    }
                }
            }
        };

        Runnable odd = new Runnable() {
            @Override
            public void run() {
                while ( true ) {
                    IncrementAndPrint.incrementAndPrint( false );
                    if ( IncrementAndPrint.c == 100 ) {
                        return;
                    }
                }
            }
        };

        Thread t1 = new Thread( even );
        Thread t2 = new Thread( odd );
        t1.start();
        t2.start();
    }
}

class IncrementAndPrint {

    public static int c = 0;

    // synchronized means the two threads can't be in here at the same time
    // returns bool because that's a good thing to do, even if currently unused
    public static synchronized boolean incrementAndPrint( boolean even ) {
        if ( ( even && c % 2 == 1 ) || ( !even && c % 2 == 0 ) ) {
            return false;
        }
        System.out.println( c++ );
        return true;
    }
}
