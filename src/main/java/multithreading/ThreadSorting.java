package multithreading;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Not yet completed
public class ThreadSorting {
    private static Lock lock = new ReentrantLock();

    public static void main( String[] args ) {
        int[] a1 = { 1, 4, 7 };
        int[] a2 = { 2, 5, 8 };
        int[] a3 = { 3, 6, 9 };
        
        for(int i=0; i<3; i++) {
            if(lock.tryLock()) {
                try {
                    System.out.print(a1[i]);
                } finally {
                    lock.unlock();
                }
            }
        }
        
    }

}
