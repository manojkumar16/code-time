package algo.ds;

public class LinkedListSimple {

    public static void main( String[] args ) {
        new LinkedListSimple().process();
    }

    private void process() {
        JavaNode start = new JavaNode();
        start.data = 6;
        for ( int i = start.data - 1; i >= 1; i-- ) {
            start = push( start, i );
        }
        System.out.print( "Linked list before calling  practice(): " );
        printList( start );

        // start = swapFirstTwoNodes( start );
        //start = RemoveEvenNodes( start );
        start = RemoveOddNodes( start );

        System.out.print( "\n\nLinked list after calling  swapFirstTwoNodes(): " );
        printList( start );
    }

    private JavaNode RemoveOddNodes( JavaNode start ) {
        start = start.next;
        JavaNode even = start;
        while ( even != null && even.next != null ) {
            even.next = even.next.next;
            even = even.next;
        }
        return start;
    }

    // Remove nodes from even places
    private JavaNode RemoveEvenNodes( JavaNode start ) {
        JavaNode odd = start;
        while ( odd != null && odd.next != null ) {
            odd.next = odd.next.next;
            odd = odd.next;
        }
        return start;
    }

    private JavaNode swapFirstTwoNodes( JavaNode start ) {
        JavaNode cur = start; // 1 2 3 4 5 6
        JavaNode next = start.next; // 2 3 4 5 6
        cur.next = null;
        cur.next = next.next;
        next.next = cur;
        return next;
    }

    private void printList( JavaNode node ) {
        int c = 0;
        while ( node != null && c < 10 ) {
            System.out.print( node.data + "  " );
            node = node.next;
            c++;
        }
    }

    private JavaNode push( JavaNode head, int new_data ) {
        JavaNode new_node = new JavaNode();
        new_node.data = new_data;
        new_node.next = head;
        head = new_node;
        return head;
    }
}

class JavaNode {
    int data;

    JavaNode next;

    @Override
    public String toString() {
        int c = 0;
        String s = "";
        JavaNode t = this;
        while ( c < 10 && t != null ) {
            s = s + t.data + " ";
            c++;
            t = t.next;
        }
        return s;
    }
}