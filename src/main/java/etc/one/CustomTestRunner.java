package etc.one;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

public class CustomTestRunner extends Runner {
    private List<Method> fTestMethods = new ArrayList<Method>();

    private final Class<?> fTestClass;

    public CustomTestRunner( Class<?> aClass ) throws InitializationError {
        this.fTestClass = aClass;
        Method[] methods = aClass.getDeclaredMethods();
        for ( int i = 0; i < methods.length; i++ ) {
            Method method = methods[i];
            Class<?> retClass = method.getReturnType();
            int length = method.getParameterTypes().length;
            int modifiers = method.getModifiers();
            if ( retClass == null || length != 0 || Modifier.isStatic( modifiers )
                || !Modifier.isPublic( modifiers ) || Modifier.isInterface( modifiers )
                || Modifier.isAbstract( modifiers ) ) {
                continue;
            }
            if ( method.getAnnotation( ReverseCharRecursion.class ) != null ) {
                fTestMethods.add( method );
            }
            if ( method.getAnnotation( Ignore.class ) != null ) {
                fTestMethods.remove( method );
            }
        }
    }

    @Override
    public Description getDescription() {
        Description spec = Description.createSuiteDescription( this.fTestClass.getName(),
            this.fTestClass.getAnnotations() );
        return spec;
    }

    @Override
    public void run( RunNotifier runNotifier ) {
        Result result = new Result();
        RunListener listener = result.createListener();
        runNotifier.addFirstListener( listener );
        for ( int i = 0; i < fTestMethods.size(); i++ ) {
            Method method = fTestMethods.get( i );
            Description spec = Description.createTestDescription( method.getClass(), method.getName() );
            try {
                runNotifier.fireTestRunStarted( spec );
                // run(runNotifier);
                runNotifier.fireTestRunFinished( result );
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }

        runNotifier.removeListener( listener );
    }
}