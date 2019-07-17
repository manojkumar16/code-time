package etc;
import java.lang.reflect.Method;

import org.junit.Ignore;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class CustomJUnit4TestRunner extends BlockJUnit4ClassRunner {

    public CustomJUnit4TestRunner( Class<?> klass ) throws InitializationError {
        super( klass );
    }

    @Override
    protected void runChild( FrameworkMethod method, RunNotifier notifier ) {
        Description desc = Description.createTestDescription( getTestClass().getJavaClass(), method.getMethod().getName() );;
        
        if (method.getAnnotation(Ignore.class) != null) {
            notifier.fireTestIgnored( desc );
            return;
        }

        notifier.fireTestStarted( desc );
        try {
            methodBlock(method).evaluate();
        } catch (AssumptionViolatedException e) {
            notifier.fireTestAssumptionFailed( new Failure(desc, e) );
        } catch (Throwable e) {
            notifier.fireTestFailure( new Failure(desc, e) );
        } finally {
            notifier.fireTestFinished( desc );
        }
    }

    
/*    @Override
    protected List<FrameworkMethod> computeTestMethods() {
        List<FrameworkMethod> ls = new ArrayList<FrameworkMethod>();

        if ( methods != null ) {
            for ( Method method : methods ) {
                try {
                    ls.add( new FrameworkMethod( method ) );
                } catch ( SecurityException e ) {
                    e.printStackTrace();
                }
            }
        }

        Class<?>[] parameterTypes = new Class[] {};
        try {
            ls.add( new FrameworkMethod( getTestClass().getJavaClass().getMethod( "testFail", parameterTypes ) ) );
        } catch ( SecurityException e ) {
            e.printStackTrace();
        } catch ( NoSuchMethodException e ) {
            e.printStackTrace();
        }

        return ls;
    }*/
}
