package algo.ds;

public class IntegerClassMain {
    public static void main( String args[] ) throws InterruptedException {
        IntegerClass ob = new IntegerClass();
        IntegerClassRunnable r2 = new IntegerClassRunnable( ob, 2 );
        IntegerClassRunnable r1 = new IntegerClassRunnable( ob, 1 );
        new Thread(r2).start();
        Thread.sleep( 1000 );
        new Thread(r1).start();
    }
}

class IntegerClassRunnable implements Runnable {
    IntegerClass ob;

    private int index;

    public IntegerClassRunnable( IntegerClass object, int i ) {
        ob = object;
        index = i;
    }

    @Override
    public void run() {
        if ( index == 2 ) {
            ob.set( 10 );
        } else {
            System.out.println( ob.get() );
        }
    }
}
