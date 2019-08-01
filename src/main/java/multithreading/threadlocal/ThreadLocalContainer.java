package multithreading.threadlocal;

/**
 * this class acts as a container to thread local variables.
 * @author mkprasad
 *
 */
public class ThreadLocalContainer {

    public static final ThreadLocal<Context> tLocal = new ThreadLocal<Context>() {
        @Override
        protected Context initialValue() {
            Context ctx = new Context();
            ctx.setTransactionId( "DefaultTransId-0" );
            return ctx;
        }
    };
    
    public static void set(Context ctx) {
        tLocal.set( ctx );
    }
    
    public static void unset( ) {
        tLocal.remove();
    }
    
    public static Context get() {
        return tLocal.get();
    }
}
