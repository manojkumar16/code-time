package etc.one;

public class Option2 implements Runnable {
    final Object gate = new Object();
    boolean isReady = false;
    final StringBuffer result = new StringBuffer();

    public static void main( String[] args ) throws InterruptedException {
        Option2 p = new Option2();
        Thread t = new Thread( p );
        t.setDaemon( true );
        t.start();

        synchronized ( p.gate ) {
            p.isReady = true;
            p.gate.notifyAll();
        }
        Thread.sleep( 1000 );
        synchronized ( p.gate ) {
            System.out.println("Result: "+ p.result );
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep( 10 );
            synchronized ( gate ) {
                while(!isReady) {
                    gate.wait();
                }
                result.append( "Question: will this msg be seen before program exits? - option2" );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }        
    }

}
