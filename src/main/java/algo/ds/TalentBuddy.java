package algo.ds;

/**
 * http://www.talentbuddy.co/challenge/5286b6e84af0110af3838c475286b6e84af0110af3838c45
 * 
 * @author mkprasad
 * 
 */
public class TalentBuddy {

    public static void main( String[] args ) {
        Integer[] s = { 1, 4, 5 };
        Integer[] d = { 2, 1, 4 };
        get_journey( s, d );

    }

    public static void get_journey( Integer[] departure_ids, Integer[] destination_ids ) {
        Integer[] itinerary = new Integer[departure_ids.length + 1];
        int j = 0;
        int src_index = -1;
        int visitedCount = 0;
        for ( int i = 0; i < departure_ids.length; i++ ) {
            if ( isSource( destination_ids, departure_ids[i] ) ) {
                src_index = i;
            }
        }
        if ( src_index == -1 ) {
            System.out.println( "No route" );
            return;
        }

        while ( visitedCount < departure_ids.length ) {
            if ( j > 1 && itinerary[j - 1] != departure_ids[src_index] ) {
                itinerary[j++] = departure_ids[src_index];
            } else if ( j == 0 ) {
                itinerary[j++] = departure_ids[src_index];
            }
            itinerary[j++] = destination_ids[src_index];

            visitedCount++;

            if ( visitedCount == departure_ids.length ) {
                display( itinerary );
                return;
            }

            src_index = getSource( destination_ids[src_index], departure_ids );
            if ( src_index == -1 ) {
                System.out.println( "Route is broken" );
                return;
            }
        }
    }

    private static void display( Integer[] itinerary ) {
        for ( int i = 0; i < itinerary.length; i++ ) {
            System.out.print( itinerary[i] + " " );
        }
    }

    private static int getSource( Integer node, Integer[] departure_ids ) {
        for ( int i = 0; i < departure_ids.length; i++ ) {
            if ( departure_ids[i] == node ) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isSource( Integer[] destination_ids, Integer node ) {
        for ( int i = 0; i < destination_ids.length; i++ ) {
            if ( node == destination_ids[i] ) {
                return false;
            }
        }
        return true;
    }
}