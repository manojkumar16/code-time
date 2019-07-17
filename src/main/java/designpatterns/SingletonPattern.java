package designpatterns;

public class SingletonPattern {
    private static SingletonPattern sp = null;
    
    public static SingletonPattern getInstance() {
        if ( sp == null ) {
            sp = new SingletonPattern();
        }
        return sp;
    }
    
}
