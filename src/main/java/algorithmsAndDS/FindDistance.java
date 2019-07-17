package algorithmsAndDS;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/find-distance-two-given-nodes/
 * 
 */
public class FindDistance {

    public static void main( String[] args ) {
        FindDistance ob = new FindDistance();
        DNode root = ob.createTree();
        System.out.println( ob.findDistance( root, 4, 5 ) );

        System.out.println( ob.findDistance( root, 4, 6 ) );

        System.out.println(ob.findDistance(root, 3, 4));
    }

    private int findDistance( DNode root, int i, int j ) {
        DNode n1 = new DNode( i );
        DNode n2 = new DNode( j );
        Distance d1 = new Distance();
        d1.d = -1;

        Distance d2 = new Distance();
        d2.d = -1;

        Distance dist = new Distance();
        dist.d = -1;

        DNode lca = findDistUtil( root, n1, n2, d1, d2, dist, 1 );

        // If both n1 and n2 were present in Binary Tree, return dist
        if ( d1.d != -1 && d2.d != -1 ) {
            return dist.d;
        }
        if ( d1.d != -1 ) {
            // If n1 is ancestor of n2, consider n1 as root and find level
            // of n2 in subtree rooted with n1
            dist.d = findLevel( lca, n2, 0 );
            return dist.d;
        }
        if ( d2.d != -1 ) {
            dist.d = findLevel( lca, n1, 0 );
            return dist.d;
        }

        return -1;
    }

    private static int findLevel( DNode root, DNode n, int lvl ) {
        if ( root == null )
            return -1;

        if ( root.data == n.data ) {
            return lvl;
        }
        int l = findLevel( root.left, n, lvl + 1 );
        return l != -1 ? l : findLevel( root.right, n, lvl + 1 );
    }

    // This function returns pointer to LCA of two given values n1 and n2.
    // It also sets d1, d2 and dist if one key is not ancestor of other
    // d1 --> To store distance of n1 from root
    // d2 --> To store distance of n2 from root
    // lvl --> Level (or distance from root) of current node
    // dist --> To store distance between n1 and n2
    private static DNode findDistUtil( DNode root, DNode n1, DNode n2, Distance d1, Distance d2, Distance dist,
        int lvl ) {
        if ( root == null )
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if ( root.data == n1.data ) {
            d1.d = lvl;
            return root;
        }
        if ( root.data == n2.data ) {
            d2.d = lvl;
            return root;
        }

        // Look for n1 and n2 in left and right subtrees
        DNode left_lca = findDistUtil( root.left, n1, n2, d1, d2, dist, lvl + 1 );
        DNode right_lca = findDistUtil( root.right, n1, n2, d1, d2, dist, lvl + 1 );

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if ( left_lca != null && right_lca != null ) {
            dist.d = d1.d + d2.d - 2 * lvl;
            return root;
        }

        // Otherwise check if left subtree or right subtree is LCA
        return left_lca != null ? left_lca : right_lca;
    }

    private DNode createTree() {
        DNode root = new DNode( 1 );
        root.left = new DNode( 2 );
        root.right = new DNode( 3 );
        root.left.left = new DNode( 4 );
        root.left.right = new DNode( 5 );
        root.right.left = new DNode( 6 );
        root.right.right = new DNode( 7 );
        root.right.left.right = new DNode( 8 );
        return root;
    }

}

class DNode {
    int data;

    DNode left;

    DNode right;

    DNode( int d ) {
        data = d;
    }

    DNode( int d, DNode l, DNode r ) {
        data = d;
        left = l;
        right = r;
    }

    public List<DNode> getAdjNode() {
        List<DNode> ls = new ArrayList<DNode>();
        if ( left != null ) {
            ls.add( left );
        }
        if ( right != null ) {
            ls.add( right );
        }
        return ls;
    }
}

class Distance {
    int d;
}
