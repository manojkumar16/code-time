package etc;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main( String[] args ) throws InterruptedException {
        int i=0;
        for(char c=0; c<256; c++){
            System.out.println(i+" --> "+c);
            i++;
        }
    }

    private void remove2( final ConcurrentHashMap<Integer, Integer> hm ) throws InterruptedException {

        for ( int i = 0; i < 1000; i++ ) {
            hm.put( i, i );
        }

        Thread t1 = new Thread( new Runnable() {

            @Override
            public void run() {
                Iterator<Entry<Integer, Integer>> iter = hm.entrySet().iterator();
                while ( iter.hasNext() ) {
                    iter.remove();
                }
            }
        } );

        Thread t2 = new Thread( new Runnable() {

            @Override
            public void run() {
                for ( int i = 1000; i < 2000; i++ ) {
                    hm.put( i, i );
                    System.out.println( i );

                }
            }
        } );

        t2.start();
        Thread.sleep( 100 );
        t1.start();

    }

    private void remove1( final ConcurrentHashMap<Integer, Integer> hm ) {
        for ( int i = 0; i < 1000; i++ ) {
            hm.put( i, i );
        }

        Thread t1 = new Thread( new Runnable() {

            @Override
            public void run() {
                Iterator<Entry<Integer, Integer>> iter = hm.entrySet().iterator();
                while ( iter.hasNext() ) {
                    Entry<Integer, Integer> entry = iter.next();
                    System.out.println( entry.getKey() + "," + entry.getValue() );
                }
            }
        } );

        Thread t2 = new Thread( new Runnable() {

            @Override
            public void run() {
                for ( int i = 0; i < 1000; i++ ) {
                    hm.remove( i );
                }
            }
        } );

        t1.start();
        t2.start();
    }

}
