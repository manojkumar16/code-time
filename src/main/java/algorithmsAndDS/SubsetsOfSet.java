package algorithmsAndDS;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method to return all subsets of a set.
 * 
 * Solution: See cracking the coding interview
 */
public class SubsetsOfSet {
    static ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();

    public static void main( String[] args ) {
        List<Integer> set = new ArrayList<Integer>();
        set.add( 1 );
        set.add( 2 );
        set.add( 3 );
        set.add( 4 );
     //   getSubsets( set, 0 );

        // System.out.println(allsubsets);

        getSubsets2( set );

        System.out.println( allsubsets );
    }

    private static void getSubsets2( List<Integer> set ) {
        int max = 1 << set.size();
        for ( int k = 0; k < max; k++ ) {
            ArrayList<Integer> subset = convertIntToSet( k, set );
            allsubsets.add( subset );
        }
    }

    private static ArrayList<Integer> convertIntToSet( int x, List<Integer> set ) {
        ArrayList<Integer> subset = new ArrayList<Integer>();
        int index = 0;
        for ( int k = x; k > 0; k >>= 1 ) {
            if ( ( k & 1 ) == 1 ) {
                subset.add( set.get( index ) );
            }
            index++;
        }

        return subset;
    }

    private static ArrayList<ArrayList<Integer>> getSubsets( List<Integer> set, int index ) {
        if ( set.size() == index + 1 ) {
            allsubsets.add( new ArrayList<Integer>() ); // Empty set
        } else {
            allsubsets = getSubsets( set, index + 1 );
            int item = set.get( index );
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for ( ArrayList<Integer> subset : allsubsets ) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll( subset );
                newsubset.add( item );
                moresubsets.add( newsubset );
            }
            allsubsets.addAll( moresubsets );
        }
        return allsubsets;
    }

}
