package etc.one;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestAnnotation {

    public static void main( String[] args ) throws SecurityException, ClassNotFoundException {
        for ( Method method : Class.forName( "BuildHouse" ).getMethods() ) {
            if ( method.isAnnotationPresent( Developer.class ) ) {
                for ( Annotation anno : method.getDeclaredAnnotations() ) {
                    System.out.println( "Annotation in method " + method + " : " + anno );
                    Developer a = method.getAnnotation( Developer.class );
                    if ( "Popeye".equals( a.value() ) ) {
                        System.out.println( "Popeye the sailor man! " + method );
                    }
                }
            }
        }
    }

}
