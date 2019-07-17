package algorithmsAndDS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildGraph {
    // 2nd argument is key and later arguments will be list of adjacent nodes to key
    public Map<Integer, List<Integer>> buildGraph() {
        Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>();
        buildNode( hm, 0, 1, 5 );
        buildNode( hm, 2, 0, 3 );
        buildNode( hm, 3, 2, 5 );
        buildNode( hm, 4, 2, 3 );
        buildNode( hm, 5, 4 );
        buildNode( hm, 6, 0, 4, 9, 8 );
        buildNode( hm, 7, 6, 9 );
        buildNode( hm, 8, 6 );
        buildNode( hm, 9, 10, 11 );
        buildNode( hm, 10, 12 );
        buildNode( hm, 11, 12 );
        buildNode( hm, 12, 9 );

        hm.put( 1, new ArrayList<Integer>() );

        return hm;
    }

    private void buildNode( Map<Integer, List<Integer>> hm, int key, int... nodes ) {
        List<Integer> value = new ArrayList<Integer>();
        for ( int i = 0; i < nodes.length; i++ ) {
            value.add( nodes[i] );
        }
        hm.put( key, value );
    }
}
