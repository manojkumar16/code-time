package etc;

import java.util.Iterator;


public interface SimpleIterator<E> extends Iterator<E>{
    
    public E getLazyElementNext();
    
    public E getEagerElelementNext();
}
