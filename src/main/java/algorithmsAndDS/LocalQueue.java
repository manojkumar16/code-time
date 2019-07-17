package algorithmsAndDS;

import java.util.NoSuchElementException;

public class LocalQueue {

    private int N = 0;

    Node first;

    Node last;

    public void enqueue( Integer n ) {
        Node oldlast = last;
        last = new Node();
        last.item = n;
        last.next = null;
        if ( isEmpty() ) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    boolean isEmpty() {
        return first == null;
    }

    // FIFO
    public Integer dequeue() {
        if ( isEmpty() )
            throw new NoSuchElementException( "Queue underflow" );
        Node oldfirst = first;
        first = first.next;
        N--;
        return oldfirst.item;
    }

    public Integer peek() {
        if ( isEmpty() )
            throw new NoSuchElementException( "Queue underflow" );
        return first.item;
    }

    public int size() {
        return N;
    }

    // helper linked list class
    private class Node {
        private Integer item;

        private Node next;
    }

}
