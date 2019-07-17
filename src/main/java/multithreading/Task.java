package multithreading;

public class Task implements Runnable {
    private final int count;

    public Task( int c ) {
        this.count = c;
    }

    @Override
    public void run() {
        try {
            long t  = (long) ( Math.random()*10000 );
            System.out.println( "Processing request # " + count + " with sleep " + t );
            Thread.sleep( t );
            System.out.println( "Processed request # " + count + " with sleep " + t );
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
    }

}
