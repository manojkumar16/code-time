package algo.ds;

public class LinkedListPractice {

    public static void main( String[] args ) {
        reverseLinkedListDirection();
        // reverseLinkedList();
        // nthLastNode();
        
        //NewNode head = getLinkedList( 2 );
        //NewNode head = getLinkedList( );
        //display(head);
        //deleteKthNode(head,3);
        //display(head);
        //head = reverseLinkedListUsingRecursion(head);
        //display(head);
    }

    //delete node at position k
    private static void deleteKthNode( NewNode head, int k ) {
        if ( head == null ) {
            return;
        }
        NewNode prev = head;
        k--;
        while ( prev.next != null && k > 1 ) {
            prev = prev.next;
            k--;
        }
        if ( k > 1 ) {// linked list size is not more than k elements
            return;
        }
        prev.next = prev.next.next;
    }

    private static NewNode reverseLinkedListUsingRecursion(NewNode head) {
        if(head == null){
            return null;
        }
        NewNode first = head;
        NewNode rest = head.next;
        
        if(rest == null){
            return head;
        }
        
        reverseLinkedListUsingRecursion( rest );
        first.next.next = first;
        first.next = null;
        head = rest;
        return head;
    }

    private static void reverseLinkedListDirection() {
        NewNode head = getLinkedList();
        display( head );
        System.out.println();

        NewNode prev = null;
        NewNode cur = head;
        NewNode next = cur.next;

        while ( next != null ) {
            NewNode temp = cur;
            cur.next = prev;
            prev = temp;
            cur = next;
            next = next.next;
        }
        cur.next = prev;

        while ( cur != null ) {
            System.out.print( cur.key + "  " );
            cur = cur.next;
        }
    }

    /**
     * Write a program to print elements of a linked list in reverse order by using same single linked list in java.
     * Note : you can use only one linked list and no other data structure.
     */
    private static void reverseLinkedList() {
        NewNode head = getLinkedList();
        display( head );
        reverse( head );

    }

    private static void display( NewNode head ) {
        while ( head != null ) {
            System.out.print( head.key + "  " );
            head = head.next;
        }
        System.out.println( "" );
    }

    private static void reverse( NewNode head ) {
        if ( head != null ) {
            reverse( head.next );
            System.out.print( head.key + "  " );
        }
    }

    /**
     * Given a linked list , print the nth last node.
     */
    private static void nthLastNode() {
        NewNode head = getLinkedList();
        display( head );
        int n = 3;
        // Assuming linked list has more than 3 nodes.
        NewNode cur = head.next.next, prev = head;
        while ( cur.next != null ) {
            cur = cur.next;
            prev = prev.next;
        }

        System.out.println( "Nth last node: " + prev.key );
    }

    private static NewNode getLinkedList() {
        NewNode head = new NewNode( 16 );
        head.next = new NewNode( 20 );
        head.next.next = new NewNode( 18 );
        head.next.next.next = new NewNode( 5 );
        head.next.next.next.next = new NewNode( 17 );
        head.next.next.next.next.next = new NewNode( 13 );
        head.next.next.next.next.next.next = new NewNode( 8 );
        return head;
    }

    private static NewNode getLinkedList( int n ) {
        NewNode head = new NewNode( 16 );
        head.next = new NewNode( 20 );
        return head;
    }

}
