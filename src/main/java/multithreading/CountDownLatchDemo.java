package multithreading;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CountDownLatch in Java is a kind of synchronizer which allows one Thread to wait for one or more Threads before
 * starts processing.
 * 
 * CountDownLatch works in latch principle, main thread will wait until Gate is open. One thread waits for n number of
 * threads specified while creating CountDownLatch in Java. Any thread, usually main thread of application, which calls
 * CountDownLatch.await() will wait until count reaches zero or it is interrupted by another Thread. All other thread
 * are required to do count down by calling CountDownLatch.countDown() once they are completed or ready to the job. as
 * soon as count reaches zero, Thread awaiting starts running. One of the disadvantage of CountDownLatch is that its not
 * reusable once count reaches to zero you can not use CountDownLatch any more, but don't worry Java concurrency API has
 * another concurrent utility called CyclicBarrier for such requirements.
 * 
 * In following CountDownLatch example, Java program requires 3 services namely CacheService, AlertService and
 * ValidationService to be started and ready before application can handle any request and this is achieved by using
 * CountDownLatch in Java.
 * 
 * Read more: http://javarevisited.blogspot.in/2012/07/countdownlatch-example-in-java.html
 * 
 * @author mkprasad
 * 
 */
public class CountDownLatchDemo {

    public static void main( String[] args ) {
        new CountDownLatchDemo().testCountDownLatch();

    }

    private void testCountDownLatch() {
        CountDownLatch latch = new CountDownLatch( 3 );
        Thread cacheService = new Thread( new Service( "CacheService", 1000, latch ) );
        Thread alertService = new Thread( new Service( "AlertService", 1000, latch ) );
        Thread validationService = new Thread( new Service( "ValidationService", 1000, latch ) );

        cacheService.start(); // separate thread will initialize CacheService
        alertService.start(); // another thread for AlertService initialization
        validationService.start();

        // application should not start processing any thread until all service is up
        // and ready to do there job.
        // Countdown latch is idle choice here, main thread will start with count 3
        // and wait until count reaches zero. each thread once up and read will do
        // a count down. this will ensure that main thread is not started processing
        // until all services is up.

        // count is 3 since we have 3 Threads (Services)

        try {
            latch.await(); // main thread is waiting on CountDownLatch to finish
            System.out.println( "All services are up, Application is starting now" );
        } catch ( InterruptedException ie ) {
            ie.printStackTrace();
        }
    }

    /**
     * Service class which will be executed by Thread using CountDownLatch synchronizer.
     */
    class Service implements Runnable {
        private final String name;

        private final int timeToStart;

        private final CountDownLatch latch;

        public Service( String name, int timeToStart, CountDownLatch latch ) {
            this.name = name;
            this.timeToStart = timeToStart;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep( timeToStart );
            } catch ( InterruptedException ex ) {
                Logger.getLogger( Service.class.getName() ).log( Level.SEVERE, null, ex );
            }
            System.out.println( name + " is Up" );
            latch.countDown(); // reduce count of CountDownLatch by 1
        }
    }

}
