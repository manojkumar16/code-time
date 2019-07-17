package multithreading;

public class StaticNonStatic {
    public StaticNonStatic() {
    }

    public void f1( String msg ) {
        work( msg );
    }

    public synchronized void f2( String msg ) {
        work( msg );
    }

    public synchronized void f3( String msg ) {
        work( msg );
    }

    public static synchronized void f4( String msg ) {
        staticwork( msg );
    }

    public static synchronized void f5( String msg ) {
        staticwork( msg );
    }

    private void work( String msg ) {
        System.out.println( msg + " start" );
        try {
            Thread.sleep( 100 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println( msg + " end" );
    }

    private static void staticwork( String msg ) {
        System.out.println( msg + " start" );
        try {
            Thread.sleep( 100 );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        System.out.println( msg + " end" );
    }
}
