package iostreams;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersistentAnimation implements Serializable, Runnable {
    /**
     * 
     */
    private static final long serialVersionUID = 1320924593477119670L;

    transient private Thread th;

    private int speed;

    public PersistentAnimation( int s ) {
        speed = s;
        start();
    }

    public void start() {
        th = new Thread(this);
        th.start();
    }
    public void run() {
        int n = 0;
        while ( n < speed ) {
            System.out.println( "Hello run..." );
            n++;
        }
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        start();
    }
}
