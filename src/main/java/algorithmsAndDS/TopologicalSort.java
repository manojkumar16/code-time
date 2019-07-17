package algorithmsAndDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

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
// Stop services
    public ArrayList<ServiceNode> sortServices( List<ServiceNode> nodes, boolean bStart ) throws Exception {

        int serviceCount = nodes.size();
        HashMap<String, HashSet<ServiceNode>> graph = new HashMap<String, HashSet<ServiceNode>>();
        Queue<ServiceNode> Q = new LinkedList<ServiceNode>();
        ArrayList<ServiceNode> sorted = new ArrayList<ServiceNode>();
        // Graph construction
        
        for ( int i = 0; i < nodes.size(); i++ ) {
            ServiceNode node = nodes.get( i );

            String nodeName = node.getName();
            graph.put( nodeName, new HashSet<ServiceNode>() );

            List<ServiceNode> connectedServices = null;

            connectedServices = node.getInEdges();
            
            for ( int j = 0; j < connectedServices.size(); j++ ) {
                graph.get( nodeName ).add( connectedServices.get( j ) );
            }
            // Q -> Set of all nodes with no incoming/outgoing edges
            if ( graph.get( nodeName ).size() == 0 ) {
                Q.add( node );
            }
        }

        // Getting the nodes in sorted order
        int index = 0;
        while ( Q.size() > 0 ) {
            ServiceNode s = Q.remove();
            sorted.add( s );
            index++;
            Iterator<String> iter = graph.keySet().iterator();
            while ( iter.hasNext() ) {
                // for each key in graph
                // check if node is not already removed
                String key = iter.next();
                if ( graph.get( key ).size() != 0 ) {
                    graph.get( key ).remove( s );
                    // if this node now has zero incoming/outgoing edges
                    if ( graph.get( key ).size() == 0 ) {
                        for ( int k = 0; k < nodes.size(); k++ ) {
                            if ( key.equals( nodes.get( k ).getName() ) ) {
                                Q.add( nodes.get( k ) );
                            }
                        }
                    }
                }
            }
        }
        
        if ( index < serviceCount )
            throw new Exception( "Cycle detected, exiting ...." );

        ArrayList<ServiceNode> sortedListWithLabel = labelServiceNodes(sorted);

        if ( bStart ) {
            Collections.reverse( sortedListWithLabel );
            return sortedListWithLabel;
        } else {
            return sortedListWithLabel;
        }
    }

    /**
     * labelList -> Final set contains all nodes with updated levels
     * @param labelList
     * @return
     */
    private ArrayList<ServiceNode> labelServiceNodes( ArrayList<ServiceNode> labelList ) {
        for(int i=0; i<labelList.size(); i++) {
            ServiceNode currNode = labelList.get( i );
            List<ServiceNode> inEdges = currNode.getInEdges();
            if(inEdges.size() == 0) {
                currNode.setLabel( 0 );
            } else {
                int maxLabel = 0;
                for(int j=0; j<inEdges.size(); j++) {
                    ServiceNode tempNode = inEdges.get( j );
                    if(maxLabel < tempNode.getLabel()) {
                        maxLabel = tempNode.getLabel();
                    }
                }
                currNode.setLabel( maxLabel + 1 );
            }
        }
        return labelList;
    }
}
