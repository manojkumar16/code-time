package algo.ds;

import java.util.ArrayList;
import java.util.List;

/**
 * A class which holds data structure of a service
 * @author mkprasad
 *
 */
public class ServiceNode {
    private String name;
    private int label;
    
    // Parent nodes
    private List<ServiceNode> inEdges;

    // Children nodes
    private List<ServiceNode> outEdges;

    public ServiceNode( String id ) {
        this( id, null, null );
    }

    public ServiceNode( String id, List<ServiceNode> inEdges, List<ServiceNode> outEdges ) {
        this.name = id;
        this.inEdges = checkNull( inEdges );
        this.outEdges = checkNull( outEdges );
    }

    List<ServiceNode> checkNull( List<ServiceNode> node ) {
        return ( node != null ) ? node : new ArrayList<ServiceNode>();
    }

    public int getLabel() {
        return label;
    }

    public void setLabel( int level ) {
        this.label = level;
    }
    
    public String getName() {
        return this.name;
    }

    /**
     * All outgoing edges from current Service node
     * @param nodes
     */
    public void addEdgeTo( ServiceNode... nodes ) {
        for ( ServiceNode node : nodes ) {
            outEdges.add( node );
        }
    }

    public void removeEdgeTo( ServiceNode... nodes ) {
        for ( ServiceNode node : nodes ) {
            outEdges.remove( node );
        }
    }

    /**
     * All incoming edges for current Service node
     * @param nodes
     */
    public void addEdgeFrom( ServiceNode... nodes ) {
        for ( ServiceNode node : nodes ) {
            inEdges.add( node );
        }
    }

    public void removeEdgeFrom( ServiceNode... nodes ) {
        for ( ServiceNode node : nodes ) {
            inEdges.remove( node );
        }
    }

    /**
     * Services dependent upon
     * 
     * @return
     */
    public List<ServiceNode> getOutEdges() {
        return outEdges;
    }

    public List<ServiceNode> getInEdges() {
        return inEdges;
    }

    public boolean isLeaf() {
        return outEdges.size() == 0;
    }

    public boolean isRoot() {
        return inEdges.size() == 0;
    }

    public boolean isConnected() {
        return isLeaf() || isRoot();
    }

   // @Override
    public String xtoString() {
        StringBuffer sb = new StringBuffer();
        sb.append( this.name );
        sb.append( "=[IncomingEdges{" );
        for ( int i = 0; i < this.inEdges.size(); i++ ) {
            sb.append( inEdges.get( i ) + "," );
        }

        sb.append( "}, OutgoingEdges{" );

        for ( int i = 0; i < this.outEdges.size(); i++ ) {
            sb.append( outEdges.get( i ) + "," );
        }

        sb.append( "}]" );
        System.out.println( sb.toString() );
        return sb.toString();
    }
}
