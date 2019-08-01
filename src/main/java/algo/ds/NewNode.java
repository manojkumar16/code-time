package algo.ds;

public class NewNode<T> {
    public T key;

    public NewNode<T> left, right, next; // left and right subtrees

    // When left and right nodes are present [Tree]
    public NewNode( T key, NewNode<T> l, NewNode<T> r ) {
        this.key = key;
        this.left = l;
        this.right = r;
    }

    // When next node is present [LinkedList]
    public NewNode( T key, NewNode<T> n ) {
        this.key = key;
        this.next = n;
    }

    // When there is no node
    public NewNode( T key ) {
        this.key = key;
    }

    public T getNodeElement() {
        return key;
    }

    public NewNode<T> getLeftNode() {
        return this.left;
    }

    public NewNode<T> getRightNode() {
        return this.right;
    }

    public NewNode<T> getNextNode() {
        return this.next;
    }
}
