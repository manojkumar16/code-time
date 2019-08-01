package algo.ds;

import java.util.List;
import java.util.Map;

public class DFSProblems {
    int vertices = 13;

    boolean[] marked = new boolean[vertices];

    private Integer[] edgeTo = new Integer[vertices];

    public static void main( String[] args ) {
        new DFSProblems().start();
    }

    // Prints the path from node1 to node2 If exists
    // Using HashMap 'hm' where key is 'node' and value will be list of nodes adjacent to key
    private void start() {
        Map<Integer, List<Integer>> hm = new GraphApi().buildGraph();

        Integer source = 6;
        Integer d = 4;

        dfs( hm, source );

        if ( marked[d] ) {
            System.out.println( "There is path from node2 to node1(source)" );
            Integer dtemp = d;
            System.out.print( dtemp + " <-- " );
            while ( true ) {
                if ( !edgeTo[dtemp].equals( source ) ) {
                    System.out.print( edgeTo[dtemp] + " <-- " );
                    dtemp = edgeTo[dtemp];
                } else {
                    System.out.println( source );
                    break;
                }
            }
        } else {
            System.out.println( "There is no path" );
        }
    }

    private void dfs( Map<Integer, List<Integer>> hm, Integer s) {
        marked[s] = true;
        for ( Integer w : hm.get( s ) ) {
            if ( !marked[w] ) {
                dfs( hm, w);
                edgeTo[w] = s;
            }
        }
    }
}
