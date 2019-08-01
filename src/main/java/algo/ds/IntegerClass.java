package algo.ds;

public class IntegerClass {

    private int i=5;
    
    public synchronized void set(int j) {
        try {
            Thread.sleep( 5000 );
            System.out.println("set");
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }
        i = j;
    }
    
    public synchronized int get() {
        System.out.println("get");
        return i;
    }
}
