package multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Class1 {

    protected Semaphore semaphore;

    public void start(final Class2 obj2) throws InterruptedException {
        System.out.println("Class1");
        semaphore = obj2.getSemaphore();
        
        Thread.sleep( 1000 );
        //Now wait for Class2 to do some work then call this method again
        boolean bFlag = semaphore.tryAcquire( 4, TimeUnit.SECONDS );
        
        if(bFlag) {
            System.out.println("Class1 has acquired it.");
        } else {
            System.out.println("TimedOut...");
        }
    }
}
