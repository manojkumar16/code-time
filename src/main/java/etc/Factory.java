package etc;

public interface Factory<T> {
    T make(String str);
}
