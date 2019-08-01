package algo.ds;

import java.util.List;
import java.util.Map;

public class BFSProblems {
    static Map<Integer, List<Integer>> hm = new GraphApi().buildGraph();

    static boolean visited[] = new boolean[hm.size()];

    static Integer edgeTo[] = new Integer[hm.size()];

    static int[] distTo = new int[hm.size()];

    public static void main( String[] args ) {
        Integer source = 8;
        Integer d = 12;

        bfs( hm, source );

        if ( hasPath( d ) ) {
            showPath( source, d );
        }

    }

    public static boolean hasPath( Integer d ) {
        return visited[d];
    }

    public static void showPath( Integer s, Integer d ) {
        if ( hasPath( d ) ) {
            System.out.println( "There is path with distance " + distTo[d] );
            Integer dtemp = d;
            System.out.print( dtemp + " <- " );
            while ( true ) {
                if ( !edgeTo[dtemp].equals( s ) ) {
                    System.out.print( edgeTo[dtemp] + " <-- " );
                    dtemp = edgeTo[dtemp];
                } else {
                    System.out.println( s );
                    break;
                }
            }
        } else {
            System.out.println("No path");
        }
    }

    private static void bfs( Map<Integer, List<Integer>> hm, Integer s ) {
        LocalQueue q = new LocalQueue();
        q.enqueue( s );
        visited[s] = true;
        while ( !q.isEmpty() ) {
            Integer v = q.dequeue();
            // Get adjacent to 't'
            for ( Integer w : hm.get( v ) ) {
                if ( !visited[w] ) {
                    q.enqueue( w );
                    visited[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
            }
        }
    }
}
