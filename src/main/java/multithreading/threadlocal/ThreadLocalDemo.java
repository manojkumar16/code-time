package multithreading.threadlocal;

public class ThreadLocalDemo extends Thread {
    public static void main(String args[]) {
        Thread t1 = new ThreadLocalDemo();
        t1.start();
        
        Thread t2 = new ThreadLocalDemo();
        t2.start();
        
    }

    @Override
    public void run() {
     // sample code to simulate transaction id
        Context context = new Context();
        context.setTransactionId(getName());

        // set the context object in thread local to access it somewhere else
        ThreadLocalContainer.set( context );

        /* note that we are not explicitly passing the transaction id */
        new BusinessService().businessMethod();
        ThreadLocalContainer.unset();
    }
}
