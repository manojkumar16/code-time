package multithreading.threadlocal;

public class BusinessService {

    public void businessMethod() {
        // get the context from ThreadLocal
        System.out.println( ThreadLocalContainer.get().getTransactionId() );
    }

}
