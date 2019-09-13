package algo.ds;

/**
 * http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
 * @author manoj
 *
 */
public class ReverseLinkedList {

    public static void main( String[] args ) {
        ReverseLinkedList ob = new ReverseLinkedList();
        rnode head = ob.createList();
        ob.display( head );
        head = ob.reverseIteratively( head );
        ob.display( head );
        //head = ob.reverseRecursively( head );
       // boolean isP = isPalindrome( head );
       // System.out.println( "Palindrome : " + isP );
    }

    // http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
    // NOT working... left pointer is not getting updated.
    private static boolean isPalindrome( rnode head ) {
        rnode left = head;
        rnode right = head;
        return isPalindromeUtil(left, right);
    }

    // Initial parameters to this function are head and head
    private static boolean isPalindromeUtil( rnode left, rnode right ) {
        /* stop recursion when right becomes NULL */
        if ( right == null )
            return true;

        boolean isp = isPalindromeUtil( left, right.next );
        if ( !isp ) {
            return false;
        }

        /* Check values at current left and right */
        boolean isp1 = left.data == right.data ? true : false;
        left = left.next;
        return isp1;
    }

    //  http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
    private rnode reverseRecursively( rnode head ) {
        
        return null;
    }

    /**
     * Initially, list is 85 -> 15 -> 4 -> 20
     * Before while loop:
     *      prev = null, current = 85 -> 15 -> 4 -> 20
     * After 1st while loop:
     *      prev = 85, current = 15 -> 4 -> 20
     * After 2nd while loop:
     *      prev = 15 -> 85, current = 4 -> 20
     * After 3rd while loop:
     *      prev = 4 -> 15 -> 85, current = 20
     * After 4th while loop:
     *      prev = 20 -> 4 -> 15 -> 85, current = null
     *                
     */
    private rnode reverseIteratively( rnode head ) {
        rnode prev = null;
        rnode current = head;
        rnode next = null;

        while ( current != null ) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        head = prev;
        return head;
    }

    private void display( rnode head ) {
        rnode t = head;
        while ( t != null ) {
            System.out.print( t.data + " " );
            t = t.next;
        }
        System.out.println( "\n----------" );
    }

    private rnode createList() {
        rnode head = null;
        head = push( head, 1 );
        head = push( head, 2 );
        head = push( head, 3 );
        head = push( head, 4 );
        return head;

    }

    private rnode push( rnode head, int d ) {
        if ( head == null ) {
            head = new rnode();
            head.data = d;
        } else {
            rnode new_node = new rnode();
            new_node.data = d;
            new_node.next = head;
            head = new_node;
        }

        return head;
    }

}

class rnode {
    int data;

    rnode next;

    @Override
    public String toString() {
        rnode t = this;
        StringBuilder sb = new StringBuilder();
        while ( t != null ) {
            sb.append( t.data );
            t = t.next;
            if ( t != null ) {
                sb.append( " -> " );
            }
        }
        return sb.toString();
    }
}