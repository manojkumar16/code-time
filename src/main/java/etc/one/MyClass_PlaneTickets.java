package etc.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyClass_PlaneTickets {

    public static void main( String[] args ) {
        Integer[] departure_ids = { 1, 4, 5 };
        Integer[] destination_ids = { 2, 1, 4 };
        get_journey( departure_ids, destination_ids );

    }

    public static void get_journey( Integer[] departure_ids, Integer[] destination_ids ) {
        List<Integer> ls = new ArrayList<Integer>();
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for ( int i = 0; i < destination_ids.length; i++ ) {
            hm.put( destination_ids[i], departure_ids[i] );
        }

        // Get source vertex first
        int src = -1;
        for ( int i = 0; i < destination_ids.length; i++ ) {
            if ( hm.get( hm.get( destination_ids[i] ) ) == null ) {
                src = departure_ids[i];
            }
        }

        // key/value store for departure/destination
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for ( int i = 0; i < departure_ids.length; i++ ) {
            mp.put( departure_ids[i], destination_ids[i] );
        }

        while ( mp.get( src ) != null ) {
            ls.add( src );
            src = mp.get( src );
        }
        ls.add( src );

        for(Integer i : ls) {
            System.out.print(i+" ");
        }
    }

}
