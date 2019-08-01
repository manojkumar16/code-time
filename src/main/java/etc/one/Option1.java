package etc.one;
public class Option1 implements Runnable {
    final Object gate = new Object();

    final StringBuffer result = new StringBuffer();

    public static void main( String[] args ) throws InterruptedException {
        Option1 p = new Option1();
        Thread t = new Thread( p );
        t.setDaemon( true );
        t.start();
        synchronized ( p.gate ) {
            p.gate.notifyAll();
        }
        Thread.sleep( 1000 );
        synchronized ( p.gate ) {
            System.out.println( "Result: "+p.result );
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep( 10 );
            synchronized ( gate ) {
                gate.wait();
                result.append( "Question: will this msg be seen before program exits?" );
            }
            System.out.println("end of story.");
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}
