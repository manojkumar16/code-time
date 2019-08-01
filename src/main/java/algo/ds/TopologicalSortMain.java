package algo.ds;

import java.util.Arrays;
import java.util.List;

/**
 * Call this method when starting/stopping services
 *        
 *            L <- Empty list that will contain the sorted elements 
 *            Q <- Set of all nodes with no incoming edges 
 *             while Q is non-empty do
 *                 remove a node n from Q
 *                 insert n into L
 *                 for each node m with an edge e from n to m do
 *                     remove edge e from the graph
 *                     if m has no other incoming edges then
 *                         insert m into Q
 *          if graph has edges then
 *              return error (graph has at least one cycle)
 *          else 
 *              return L (a topologically sorted order)
 * @param nodes
 * @param bStart
 * @return
 * @throws Exception
 */

/**
 * Entry class
 * @author mkprasad
 *
 */
public class TopologicalSortMain {

    public static void main( String[] args ) throws Exception {
        
        //First build the graphs
        List<ServiceNode> list = buildConnectedServices();
        
        TopologicalSort ts = new TopologicalSort();
       
        System.out.println("Topological sort...");
        System.out.println();
        // Call this method when starting services
        System.out.println("Start Services");
        List<ServiceNode> sortedChild = ts.sortServices(list, true);
        display(sortedChild);
        
        System.out.println();
        System.out.println("===============================================");

        // Call this method when stopping services
        System.out.println("Stop Services");
        List<ServiceNode> sortedParent = ts.sortServices(list, false);
        display(sortedParent);
    }

    private static List<ServiceNode> buildConnectedServices() {
        ServiceNode d1 = new ServiceNode( "d1" );
        ServiceNode d2 = new ServiceNode( "d2" );
        ServiceNode d3 = new ServiceNode( "d3" );
        ServiceNode d4 = new ServiceNode( "d4" );
        ServiceNode d5 = new ServiceNode( "d5" );
        ServiceNode d6 = new ServiceNode( "d6" );
        ServiceNode d7 = new ServiceNode( "d7" );
        ServiceNode d8 = new ServiceNode( "d8" );
        
        // Node d3 = new Node("3", null, Arrays.asList( new Node[] {d6, d6} ));

        // All outgoing edges
        d1.addEdgeTo( d2, d3, d4 );
        d2.addEdgeTo( d6 );
        d3.addEdgeTo( d2, d6, d7 );
        //d3.addEdgeTo( d6, d7 );
        d4.addEdgeTo( d5 );
        d8.addEdgeTo( d2 );
        
        // All incoming edges
        d2.addEdgeFrom( d1, d8, d3 );
        //d2.addEdgeFrom( d1, d8 );
        d3.addEdgeFrom( d1 );
        d4.addEdgeFrom( d1 );
        d5.addEdgeFrom( d4 );
        d6.addEdgeFrom( d2, d3 );
        d7.addEdgeFrom( d3 );
        
        
        ServiceNode a1 = new ServiceNode( "a1" );
        ServiceNode a2 = new ServiceNode( "a2" );
        ServiceNode a3 = new ServiceNode( "a3" );
        ServiceNode a4 = new ServiceNode( "a4" );
        a1.addEdgeTo( a2, a3 );
        a2.addEdgeTo( a3, a4 );
        a3.addEdgeTo( a4 );
        a2.addEdgeFrom( a1 );
        a3.addEdgeFrom( a2, a1 );
        a4.addEdgeFrom( a2, a3 );
        
        ServiceNode a5 = new ServiceNode( "a5" );
        ServiceNode a6 = new ServiceNode( "a6" );
        ServiceNode a7 = new ServiceNode( "a7" );
        ServiceNode a8 = new ServiceNode( "a8" );
        a8.addEdgeTo( a7 );
        a7.addEdgeTo( a5 );
        a5.addEdgeTo( a6 );
        a7.addEdgeFrom( a8 );
        a5.addEdgeFrom( a7 );
        a6.addEdgeFrom( a5 );
        
        return Arrays.asList( new ServiceNode[] {d1,d2,d3,a1,a5,a2,a6,d5,d6,a3,a7,a4,a8,d4,d7,d8} );
    }

    private static void display( List<ServiceNode> list ) {
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get( i ).getName() + "{"+list.get( i ).getLabel()+"}, ");
        }
    }
}
