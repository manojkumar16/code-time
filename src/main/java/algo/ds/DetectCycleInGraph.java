package algo.ds;

import java.util.ArrayList;

/*
 * Detect Cycle in a Directed Graph 
 * 
 * http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 */

public class DetectCycleInGraph {
    public static void main( String[] args ) {
        Graph g = new Graph( 4 );
        g.addEdge( 0, 1 );
        g.addEdge( 0, 2 );
        g.addEdge( 1, 2 );
        g.addEdge( 2, 0 );
        g.addEdge( 2, 3 );
        g.addEdge( 3, 3 );
        if ( g.isCyclic() ) {
            System.out.println( "Graph contains cycle" );
        } else {
            System.out.println( "Graph doesn't contain cycle" );
        }
    }
}

class Graph {
    int V; // number of vertices

    ArrayList<Integer>[] adj;

    public Graph( int V ) {
        this.V = V;
        this.adj = (ArrayList<Integer>[]) new ArrayList[V];
        for ( int i = 0; i < V; i++ ) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge( int v, int w ) {
        adj[v].add( w );
    }

    public boolean dfs( int v, boolean[] visited, boolean[] recStack ) {
        visited[v] = true;

        // put the vertex in recursion stack
        recStack[v] = true;
        for ( int i : adj[v] ) {
            if ( !visited[i] && dfs( i, visited, recStack ) ) {
                return true;
            } else if ( recStack[i] ) {// cycle found because vertex 'i' is already visited
                return true;
            }
        }
        // remove the vertex from recursion stack
        recStack[v] = false;
        return false;
    }

    // Returns true if the graph contains a cycle, else false.
    // This function is a variation of DFS()
    public boolean isCyclic() {
        // Mark all the vertices as not visited and not part of recursion stack
        boolean[] visited = new boolean[V]; // default is false
        boolean[] recStack = new boolean[V];// default is false
        for ( int i = 0; i < V; i++ ) {
            // check each component/tree
            // Call the recursive helper function to detect cycle in different DFS trees
            if ( !visited[i] ) {
                if ( dfs( i, visited, recStack ) ) {
                    return true;
                }
            }
        }
        return false;
    }
}