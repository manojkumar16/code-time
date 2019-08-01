package etc.one;
import org.junit.runner.notification.RunNotifier;


public class RunJunit {
    public static void main( String[] args ) {

        Class<?> className = null;
        try {
            className = Class.forName( "junit4" );
        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }

        CustomTestRunner obj = new CustomTestRunner( className );
        RunNotifier runNotifier = new RunNotifier();
        obj.run( runNotifier );
    }
}
