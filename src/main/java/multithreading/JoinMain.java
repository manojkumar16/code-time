package multithreading;
/**
 * Join method from Thread class is used to impose order on execution of multiple Threads. Here
 * is one of such question, “You have three threads T1, T2 and T3, How do you ensure that they finish in order T1, T2,
 * T3 ? You can do this by using join method, by calling T1.join() from T2 and T2.join() from T3. In this case thread T1
 * will finish first, followed by T2 and T3. You can also use CountDownLatch and CyclicBarrier classes to implement
 * scenarios like one thread is waiting for other threads to finish there task.
 * 
 * Read more: http://javarevisited.blogspot.in/2013/02/how-to-join-multiple-threads-in-java-example-tutorial.html
 * 
 * @author mkprasad
 * 
 */
public class JoinMain {
    public static void main( String[] args ) {
        new JoinMain().testJoin();
    }

    private void testJoin() {
        Thread T1 = new Thread( new T( "T1", null ), "T1" );
        Thread T2 = new Thread( new T( "T2", T1 ), "T2" );
        Thread T3 = new Thread( new T( "T3", T2 ), "T3" );
        T1.start();
        T2.start();
        T3.start();
    }

    class T implements Runnable {
        private String name;

        private Thread Tobj;

        public T( String name, Thread Tobj ) {
            this.name = name;
            this.Tobj = Tobj;
        }

        @Override
        public void run() {
            if ( Tobj != null ) {
                try {
                    Tobj.join(); // Remove join api call and you will see threads are executing in an unordered way.
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
            System.out.println( "Completed Thread " + this.name );
        }
    }
}
