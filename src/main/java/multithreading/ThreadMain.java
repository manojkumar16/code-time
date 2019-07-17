package multithreading;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadMain {

    public static void main( String[] args ) {
        ConcurrentHashMap<String,String> hm = new ConcurrentHashMap<String,String>();
        String str = hm.putIfAbsent( "a", "apple" );
        System.out.println(str);
    }

}
