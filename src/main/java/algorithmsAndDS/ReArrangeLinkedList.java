package algorithmsAndDS;

/*Given a linked list, reverse alternate nodes and append at the end
Given a linked list, reverse alternate nodes and append them to end of list. Extra allowed space is O(1) 
Examples

Input List:  1->2->3->4->5->6
Output List: 1->3->5->6->4->2

Input List:  12->14->16->18->20
Output List: 12->16->20->18->14

http://www.geeksforgeeks.org/given-linked-list-reverse-alternate-nodes-append-end/

The idea is to maintain two linked lists, one list of all odd positioned nodes (1, 3, 5 in above example) and other list of all even positioned nodes (6, 4 and 2 in above example). Following are detailed steps.
1) Traverse the given linked list which is considered as odd list. Do following for every visited node.
……a) If the node is even node, remove it from odd list and add it to the front of even node list. Nodes are added at front to keep the reverse order.
2) Append the even node list at the end of odd node list.
*/
public class ReArrangeLinkedList {

    public static void main( String[] args ) {
        new ReArrangeLinkedList().process();
    }

    private void process() {
        /*
         * The constructed linked list is: 1->2->3->4->5->6->7
         */
        JavaNode start = new JavaNode();
        start.data = 7;
        for ( int i = start.data-1; i >= 1; i-- ) {
            start = push( start, i );
        }
        System.out.print( "Linked list before calling  rearrange(): " );
        printList( start );

        start = rearrange( start );

        System.out.print( "\n\nLinked list after calling  rearrange(): " );
        printList( start );
    }

    private JavaNode rearrange( JavaNode odd ) {
        // If linked list has less than 3 nodes, no change is required
        if ( odd == null || odd.next == null || odd.next.next == null ) {
            return odd;
        }
        // even points to the beginning of even list
        JavaNode even = odd.next;

        // Remove the first even node
        odd.next = odd.next.next;

        // odd points to next node in odd list
        odd = odd.next;

        // Set terminator for even list
        even.next = null;

        // Traverse the list
        while ( odd != null && odd.next != null ) {
            // Store the next node in odd list
            JavaNode temp = odd.next.next;

            // Link the next even node at the beginning of even list
            odd.next.next = even;
            even = odd.next;

            // Remove the even node from middle
            odd.next = temp;

            // Move odd to the next odd node
            if ( temp != null )
                odd = temp;
        }

        // Append the even list at the end of odd list
        odd.next = even;
        return odd;
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