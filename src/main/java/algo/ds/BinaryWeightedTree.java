package algo.ds;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * In a Binary Tree, weight of each node is described by the value of the node multiplied by the level (i.e. for root
 * node value is 1* value in root node), And the weight of tree is sum of all the node weights. Find the minimum tree
 * weight out of all the binary trees possible from a given set of numbers.
 * 
 * @author mkprasad
 * 
 */
public class BinaryWeightedTree {

    /**
     * Build binary heaps with max node value starting at root. The left and right child should be less than its parent.
     */
    public static void main( String[] args ) {
        new BinaryWeightedTree().start();
    }

    private void start() {
        int arr[] = new int[new Random().nextInt( 10 )];
        buildArray( arr );
        Node[] nodes = getSortedNodes( arr );
        Node pq[] = new Node[arr.length];
        buildMaxBinaryHeapTree( nodes, pq );

        int weight = 0;
        for ( int i = 0; i < pq.length; i++ ) {
            System.out.println( pq[i].value + "-" + pq[i].level );
            weight = weight + ( pq[i].value * pq[i].level );
        }

        System.out.println( "Minimum weight tree: " + weight );

    }

    private void buildArray( int[] arr ) {
        Random r = new Random();
        for ( int i = 0; i < arr.length; i++ ) {
            arr[i] = r.nextInt( 100 );
        }
    }

    private Node[] getSortedNodes( int[] arr ) {
        Node[] tnodes = new Node[arr.length];
        for ( int i = 0; i < arr.length; i++ ) {
            tnodes[i] = new Node( arr[i], 0 );
        }

        Comparator<? super Node> comparator = new Comparator<Node>() {

            @Override
            public int compare( Node o1, Node o2 ) {
                return o1.value < o2.value ? 1 : -1;
            }

        };
        
        Arrays.sort( tnodes, comparator );
        
        System.out.print("New array: ");
        
        for(int i=0; i<tnodes.length; i++) {
            System.out.print(tnodes[i].value+", ");
        }
        
        System.out.println();

        return tnodes;
    }

    private void buildMaxBinaryHeapTree( Node[] arr, Node[] pq ) {
        pq[0] = arr[0];
        pq[0].level = 1;

        for ( int k = 1; k < arr.length; k++ ) {
            pq[k] = arr[k];
            pq[k].level = pq[( k - 1 ) / 2].level + 1;
            swim( pq, k );
        }
    }

    private void swim( Node[] pq, int k ) {
        while ( k > 0 && less( pq, k / 2, k ) ) {
            exch( pq, k, k / 2 );
            k = k / 2;
        }
    }

    private void exch( Node[] pq, int k, int i ) {
        int temp = pq[i].value;
        pq[i].value = pq[k].value;
        pq[k].value = temp;
    }

    private boolean less( Node[] pq, int i, int k ) {
        return pq[i].value < pq[k].value;
    }

    private class Node {
        int value;

        int level;

        public Node( int v, int l ) {
            value = v;
            level = l;
        }
    }
}
