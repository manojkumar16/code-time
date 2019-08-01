package etc.one;

public interface Box<T> {
    public T get();
    public void put(T element);
    public void put(Box<? extends T> box);
}
