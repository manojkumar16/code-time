package etc;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

public class junitMain {

    public static void main( String[] args ) throws InitializationError {
        junitMain obj = new junitMain();
        Map<String, Result> results = new HashMap<String, Result>();
        obj.testJunit( "junit3" );
        obj.testJunit( "junit4" );
    }

    private void testJunit( String cName ) throws InitializationError {
        Class<?> className = null;
        Result res = null;
        try {
            className = Class.forName( cName );

            Class<?> su = className.getSuperclass();

            if ( su.getName().equals( "junit.framework.TestCase" ) ) {
                res = org.junit.runner.JUnitCore.runClasses( className );
            } else if ( !su.getName().equalsIgnoreCase( "Object" ) ) {
                System.out.println( "JUNIT 4 needs to be executed..." );

                CustomJUnit4TestRunner obj = new CustomJUnit4TestRunner(className);
                
                // MKP
                TestResult testRes = new TestResult();

                Result result = new Result();
                RunListener listener = result.createListener();
                
                RunNotifier notifier = new RunNotifier();
                notifier.addListener( listener  );
                
                // Create a 4 runner, execute and capture the time
                Method[] methods = className.getMethods();
                for ( int i = 0; i < methods.length; i++ ) {
                    Method meth = methods[i];
                    if ( meth.getAnnotation( ReverseCharRecursion.class ) != null ) {
                        System.out.println( "====================================" );
                        System.out.println( "Method name:" + meth.getName() );
                        
                        obj.runChild( new FrameworkMethod( meth ) , notifier );
                       // obj.run( notifier  );
                        
                        System.out.println("JUNIT 4: TEST COUNT: "+result.getRunCount());
                        
                        List<Failure> list = result.getFailures();
                    }
                }
            }

        } catch ( ClassNotFoundException e ) {
            e.printStackTrace();
        }

        if ( res != null ) {
            System.out.println( "Run count for " + cName + ": " + res.getRunCount() );
        }
    }
}
