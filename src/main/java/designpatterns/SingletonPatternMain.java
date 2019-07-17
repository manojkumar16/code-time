package designpatterns;

public class SingletonPatternMain {
    public static void main( String[] args ) {
        SingletonPattern sp1 = SingletonPattern.getInstance();
        SingletonPattern sp2 = SingletonPattern.getInstance();

        System.out.println( sp1 );
        System.out.println( sp2 );
    }
}
