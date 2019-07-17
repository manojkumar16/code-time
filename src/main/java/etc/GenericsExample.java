package etc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericsExample {

    public static void main( String[] args ) {
         //ex1();
        //ex2();
        ex3();
    }


    private static void ex3() {
        List<String> a = new ArrayList<String>();
        a.add("foo");
         
        List<?> b = a;
         
        Object c = b.get(0);

        b.add(new Integer (1)); 
    }


    private static void ex2() {
        List<?>[] lsa = new List<?>[10]; // not really allowed
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add( new Integer( 3 ) );
        oa[1] = li; // unsound, but passes run time store check
        //String s = lsa[1].get( 0 ); // run-time error - ClassCastException
        System.out.println(lsa[1].get( 0 ));

    }

    private static void ex1() {
        List<?> l = new ArrayList<String>();
        // l.add( new Object() );
        List<Integer> l2 = new ArrayList<Integer>();
        System.out.println( l2.getClass() );
        
        List<Object> ls = new ArrayList<Object>();
        ls.add( "hello" );
        ls.add( 12 );
        System.out.println(ls);
    }

    static void fromArrayToCollection( int[] a, Collection<Object> c ) {
        for ( int o : a ) {
            c.add( o ); // compile time error
        }
    }
}
