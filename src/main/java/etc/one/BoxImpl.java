package etc.one;

public class BoxImpl<T> implements Box<T> {

    private T element;
    private Box<? extends T> box;

    public BoxImpl( T element ) {
        this.element = element;
    }

    @Override
    public T get() {
        return element;
    }

    @Override
    public void put( T element ) {
        this.element = element;
    }

    @Override
    public void put( Box<? extends T> box ) {
        this.box = box;
    }

}
