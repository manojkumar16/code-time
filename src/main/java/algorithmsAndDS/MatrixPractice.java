package algorithmsAndDS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Suppose u have a square matrix of 0s and 1s only ... find the longest path of 1s available in the matrix and return
 * that .. you can only move right and down ... For e.g.
 */
    /*
0 0 0 1 1 
1 1 1 0 1 
0 1 1 1 0 
0 0 1 0 0 
1 1 1 1 1
*/
public class MatrixPractice {
    private static boolean[] marked = new boolean[25];
    private static List<Integer> len = new ArrayList<Integer>();
    public static void main( String[] args ) {
        int matrix[][] = {  { 0, 0, 0, 1, 1 }, 
                            { 1, 1, 1, 0, 1 }, 
                            { 0, 1, 1, 1, 0 }, 
                            { 1, 1, 1, 1, 1 } 
                         };
        Graph G = buildGraph(matrix, 5, 5);
        //displayEdge(G.adj( 7 ));
        dfs(G, 6, 1);
        System.out.println(len);
    }

    private static void dfs( Graph G, int s, int count ) {
        marked[s] = true;
        if(marked[20] && s == 20) {
            len.add( count );
        }
        List<NewNode> nodes = G.adj( s );
        if ( nodes == null ) {
            return;
        }
        for ( NewNode n : nodes ) {
            int w = (int) n.key;
            dfs( G, w, count+1 );
/*            if ( !marked[w] ) {
            }*/
        }
    }

    private static void displayEdge( List<NewNode> edges ) {
        for(NewNode n : edges) {
            System.out.print(n.key+"  ");
        }
    }

    private static Graph buildGraph( int[][] a, int row, int col ) {
       Graph g = new Graph();
       g.addEdge( 6, 7 );
       g.addEdge( 7, 8 );
       g.addEdge( 7, 12 );
       g.addEdge( 8, 13 );
       g.addEdge( 13, 14 );
       g.addEdge( 13, 18 );
       g.addEdge( 14, 19 );
       g.addEdge( 19, 20 );
       g.addEdge( 12, 13 );
       g.addEdge( 12, 17 );
       g.addEdge( 17, 18 );
       g.addEdge( 18, 19 );
       
       g.addEdge( 13, 17 );
       g.addEdge( 17, 14 );
       g.addEdge( 14, 18 );
        
       return g;
    }

}

class Graph {
    int key;

    Map<Integer, List<NewNode>> adj = new HashMap<Integer, List<NewNode>>();

    List<NewNode> adj( int v ) {
        return adj.get( v );
    }

    void addEdge( int v, int w ) {
        if ( adj.containsKey( v ) ) {
            adj.get( v ).add( new NewNode( w ) );
        } else {
            List<NewNode> ls = new ArrayList<NewNode>();
            ls.add( new NewNode( w ) );
            adj.put( v, ls );
        }
    }
}
