package etc;

import junit.framework.TestCase;

public class Main {
    public static void main( String args[] ) {
        Class<?> klass1 = TestMEGContainer.class;
        Class<?> junit3 = TestCase.class;
        if ( junit3.isAssignableFrom( klass1 )) {
            System.out.println( "JUNIT 3 CLASS" );
        } else {
            System.out.println( "...NOT JUNIT 3 CLASS" );
        }
    }
}
