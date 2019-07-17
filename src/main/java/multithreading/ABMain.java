package multithreading;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ABMain {

    public static void main( String[] args ) {
        A1 a = new A1();
        B1 b = new B1();
        
//        new Thread( a ).start();
//        new Thread( b ).start();
        
        ExecutorService executorService = Executors.newFixedThreadPool(10); 
        executorService.execute( a );
        executorService.execute( b );
        executorService.shutdown();
    }
}

class A1 implements Runnable {
    @Override
    public void run() {
        System.out.println("A1 Runnable");
    }
}

class B1 extends Thread {
    public void run() {
        System.out.println("B1 Runnable");
    }
}

