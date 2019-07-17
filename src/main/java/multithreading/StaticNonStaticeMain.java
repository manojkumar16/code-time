package multithreading;

public class StaticNonStaticeMain {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        new StaticNonStaticeMain().action();
    }

    private void action() {
        StaticNonStatic c1 = new StaticNonStatic();
        // Counter c2 = new Counter();
        Thread t1 = new StaticNonStaticThread( c1, 1 );
        Thread t2 = new StaticNonStaticThread( c1, 2 );
        Thread t3 = new StaticNonStaticThread( c1, 3 );
        Thread t4 = new StaticNonStaticThread( c1, 4 );
        Thread t5 = new StaticNonStaticThread( c1, 5 );

        t5.start();
        t4.start();
        t1.start();
        t2.start();
        t3.start();
    }

}
