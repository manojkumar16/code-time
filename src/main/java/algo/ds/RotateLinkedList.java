package algo.ds;

/*
 * Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer.
 * For example, if the given linked list is 10->20->30->40->50->60 and k is 4, the list should be modified to
 * 50->60->10->20->30->40. Assume that k is smaller than the count of nodes in linked list.
 * 
 * http://www.geeksforgeeks.org/rotate-a-linked-list/
 */
public class RotateLinkedList {
    public static void main( String[] args ) {
        new RotateLinkedList().process();
    }

    private void process() {
        NodeData head = new NodeData( 10 );
        for ( int i = 20; i <= 60; i += 10 ) {
            push( head, i );
        }
        display( head );

        rotate( head, 4 );

        display( head );
    }

    private void rotate( NodeData head, int k ) {
        if ( k == 0 ) {
            return;
        }
        // Let us understand the below code for example k = 4 and
        // list = 10->20->30->40->50->60.
        NodeData current = head;

        // current will either point to kth or NULL after this loop.
        // current will point to node 40 in the above example
        while ( k > 1 && current != null ) {
            current = current.next;
            k--;
        }

        // If current is NULL, k is greater than or equal to count
        // of nodes in linked list. Don't change the list in this case
        if ( current == null ) {
            return;
        }

        // current points to kth node. Store it in a variable.
        // kthNode points to node 40 in the above example
        NodeData kthNode = current;

        // current will point to last node after this loop
        // current will point to node 60 in the above example
        while ( current.next != null ) {
            current = current.next;
        }

        // Change next of last node to previous head
        // Next of 60 is now changed to node 10
        current.next = head;

        // Change head to (k+1)th node
        // head is now changed to node 50
        head = kthNode.next;

        // change next of kth node to NULL
        // next of 40 is now NULL
        kthNode.next = null;
    }

    private void display( NodeData head ) {
        while ( head != null ) {
            System.out.print( head.data + "-->" );
            head = head.next;
        }
    }

    private void push( NodeData head, int data ) {
        NodeData t = new NodeData( data );
        if ( head == null ) {
            head = t;
        } else {
            NodeData first = head;
            while ( first.next != null ) {
                first = first.next;
            }
            first.next = t;
        }
    }
}

class NodeData {
    public int data;

    public NodeData next;

    public NodeData( int d ) {
        this.data = d;
    }

    /*
     * public String toString() { NodeData t = this; StringBuilder sb = new StringBuilder(); sb.append( t.data + "  " );
     * while ( t.next != null ) { t = t.next; sb.append( t.data + " " ); } return sb.toString(); }
     */
}