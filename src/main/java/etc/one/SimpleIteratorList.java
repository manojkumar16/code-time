package etc.one;

import java.util.ArrayList;

public class SimpleIteratorList<E> extends ArrayList<E> implements SimpleIterator<E> {

    @Override
    public E getLazyElementNext() {
        return null;
    }

    @Override
    public E getEagerElelementNext() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public E next() {
        return null;
    }

    @Override
    public void remove() {
        
    }

}
