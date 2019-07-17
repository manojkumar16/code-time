package designpatterns;

public class TestDesign {
    public static void main( String[] args ) {
        SingletonPattern ob = AbstractClassExample.getSingletonPattern();
        System.out.println( ob );
    }
}
