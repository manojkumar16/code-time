package multithreading;

public class StaticNonStaticThread extends Thread {
    private StaticNonStatic counter = null;

    private int n = 0;

    public StaticNonStaticThread( StaticNonStatic counter, int n ) {
        this.counter = counter;
        this.n = n;
    }

    public void run() {
        if ( n == 1 ) {
            this.counter.f1( "f1" );
        } else if ( n == 2 ) {
            this.counter.f2( "f2" );
        } else if ( n == 3 ) {
            this.counter.f3( "f3" );
        } else if ( n == 4 ) {
            this.counter.f4( "f4" );
        } else if ( n == 5 ) {
            this.counter.f5( "f5" );
        }
    }
}
