package multithreading;

public class AnimatorMain {

    public static void main( String[] args ) throws InterruptedException {
        Animator a = new Animator();
        Thread t1 = new Thread( a );
      //  Thread t2 = new Thread( a );
        t1.start();
       // t2.start();
       // Thread.sleep(10);
        a.stop();
    }
}

class Animator implements Runnable {
    private boolean stop = false;
    public void stop(){stop = true;}
    
    @Override
    public void run() {
        while(!stop){
            oneStep();
            try {
                Thread.sleep( 100 );
            } catch ( InterruptedException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void oneStep() {
        System.out.println("One step further");
    }

}
