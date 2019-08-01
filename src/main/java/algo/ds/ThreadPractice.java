package algo.ds;

public class ThreadPractice {
    public static void main( String[] args ) {
        final AA a = new AA();
        Thread t1 = new Thread() {
            public void run() {
                a.m1();
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                a.m2();
            }
        };
        t1.start();
        t2.start();
    }
}

class A {
    public synchronized void m1() throws InterruptedException {
        System.out.println( "m1" );
        System.out.println( "wait for 3 seconds" );
        Thread.sleep( 300 );
        System.out.println( "waiting is over." );
    }

    public synchronized void m2() {
        System.out.println( "m2" );
    }
}