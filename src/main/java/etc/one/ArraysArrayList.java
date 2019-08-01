package etc.one;
import java.util.ArrayList;
import java.util.List;

public class ArraysArrayList {

    public static void main( String[] args ) {
        int len = 0;

        int[] n = new int[100];
        List<Integer> ls = new ArrayList<Integer>();

        recur( n, len, ls );
        
        for ( int i = 0; i < ls.size(); i++ ) {
            System.out.println( n[i] + ",  " + ls.get( i ) );
        }
    }

    private static void recur( int[] n, int len, List<Integer> ls ) {
        if ( ls.size() > 5 )
            return;

        n[len] = len + 1;
        ls.add( len + 1 );
        len++;

        recur( n, len, ls );
        
        recur( n, len, ls );
        
    }

}
