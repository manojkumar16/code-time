package algorithmsAndDS;

import java.util.List;
import java.util.Map;

public class DFSProblems {
    int vertices = 13;

    boolean[] marked = new boolean[vertices];

    private Integer[] edgeTo = new Integer[vertices];

    public static void main( String[] args ) {
        new DFSProblems().dfs1();
    }

    // Prints the path from node1 to node2 If exists
    // Using HashMap 'hm' where key is 'node' and value will be list of nodes adjacent to key
    private void dfs1() {
        Map<Integer, List<Integer>> hm = new BuildGraph().buildGraph();

        Integer source = 6;
        Integer d = 4;

        isPath( hm, source, d );
        if ( marked[d] ) {
            System.out.println( "There is path" );
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

    private void isPath( Map<Integer, List<Integer>> hm, Integer s, Integer d ) {
        marked[s] = true;
        for ( Integer w : hm.get( s ) ) {
            if ( !marked[w] ) {
                isPath( hm, w, d );
                edgeTo[w] = s;
            }
        }
    }
}
