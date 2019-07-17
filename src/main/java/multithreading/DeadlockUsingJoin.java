package multithreading;

public class DeadlockUsingJoin implements Runnable {

    public static void main( String[] args ) {
        System.out.println("Hello World!");
        new Thread(new DeadlockUsingJoin()).start();
    }

    @Override
    public void run() {
        try {
            Thread t = new Thread( new DeadlockUsingJoin() );
            t.start();
            t.join();
        } catch ( InterruptedException e ) {
            System.out.println("won't see me");
        }
    }

}
