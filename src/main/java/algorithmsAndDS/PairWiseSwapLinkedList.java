package algorithmsAndDS;

/*
 * Pairwise swap elements of a given linked list by changing links Given a singly linked list, write a function to swap
 * elements pairwise. 
 * 
 * For example, if the linked list is 1->2->3->4->5->6->7 then the function should change it to
 * 2->1->4->3->6->5->7, and if the linked list is 1->2->3->4->5->6 then the function should change it to
 * 2->1->4->3->6->5
 * 
 * http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
 */
public class PairWiseSwapLinkedList {

    private static final JavaNode NULL = null;

    public static void main( String[] args ) {
            new PairWiseSwapLinkedList().process();
    }

    private void process() {
        JavaNode start = new JavaNode();
        start.data = 6;
        for ( int i = start.data-1; i >= 1; i-- ) {
            start = push( start, i );
        }
        System.out.print( "Linked list before calling  rearrange(): " );
        printList( start );
        
        start = pairwiseSwap(start);
        
        System.out.print( "\n\nLinked list after calling  rearrange(): " );
        printList( start );        
    }

    private static JavaNode pairwiseSwap( JavaNode head ) {
        // If linked list is empty or there is only one node in list
        if ( head == NULL || head.next == NULL )
            return head;

        // Initialize previous and current pointers
        JavaNode prev = head;
        JavaNode curr = head.next;

        head = curr; // Change head before proceeeding

        // Traverse the list
        while ( true ) {
            JavaNode next = curr.next;
            curr.next = prev; // Change next of current as previous node

            if ( next == NULL || next.next == NULL ) {
                prev.next = next;
                break;
            }

            prev.next = next.next;

            prev = next;
            curr = prev.next;
        }
        return head;
    }

    private void printList( JavaNode node ) {
        while ( node != null ) {
            System.out.print( node.data + "  " );
            node = node.next;
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
    public String toString(){
        int c = 0;
        String s = "";
        JavaNode t = this;
        while(c<10 && t!=null){
            s = s+t.data+" ";
            c++;
            t = t.next;
        }
        return s;
    }
}
