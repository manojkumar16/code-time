package algo.ds;

import java.util.Random;

/**
 * The last node of a singly linklist points to the middle node of the linklist.If there are even number of nodes the
 * first middle node is considered as the middle element.If there is only one node,it is considered as start/middle/end
 * node.How will you delete the given data in the linklist ? After deleting, the last node should still point to the
 * middle node of the updated linklist. Example: 1,2,3,4,5 Here 5 points to 3 If 4 is deleted 1,2,3,5 Now 5 points to 2
 * 
 * @author mkprasad
 * 
 */
public class SingleLinkedListMiddleOperation {
    int len;
    public static void main( String[] args ) {
        new SingleLinkedListMiddleOperation().start();
    }

    private void start() {
        len = new Random().nextInt( 10 );
        if ( len == 0 ) {
            System.out.println( "Length is 0. Return it." );
            return;
        }
        Node head = new Node( 1, null );
        buildLinkedList( head, len );
        traverseLinkedList( head, len );
        deleteNode( head, new Random().nextInt( 10 ) );
    }

    private void deleteNode( Node head, int key ) {
        if ( len < 3 ) {
            // MKPP Need to consider this corner case
            return;

        }
        Node i = head;
        Node j = head.next.next;

        while(i.key != j.key) {
            i = i.next;
            j = j.next;
            if(i.key == j.key) {
                
                
            }
            j = j.next;
        }
        
        // MKPP

    }

    private void traverseLinkedList( Node head, int len ) {
        System.out.println( "Length of linked list: " + len );
        Node cur = head;
        while ( cur != null && len > 0 ) {
            System.out.print( cur.key + "  " );
            cur = cur.next;
            len--;
        }
        System.out.println();
        System.out.println( "last element is pointing to " + cur.key );
    }

    private void buildLinkedList( Node head, int len ) {
        Node cur = head;
        Node mid = null;

        if ( len == 0 )
            return;
        if ( len == 1 ) {
            cur.next = cur;
            return;
        }
        if ( len == 2 ) {
            cur.next = new Node( 2, null );
            cur.next.next = cur;
            return;
        }
        // Find middle index
        int mid_ind = 0;
        if ( len % 2 == 0 ) {
            mid_ind = len / 2 - 1;
        } else {
            mid_ind = len / 2;
        }

        for ( int i = 1; i < len; i++ ) {
            cur.next = new Node( i + 1, null );
            cur = cur.next;
            if ( i == mid_ind ) {
                mid = cur;
            }

        }
        cur.next = mid;
    }

    private class Node {
        int key;

        Node next;

        public Node( int key, Node next ) {
            this.key = key;
            this.next = next;
        }
    }

}
