package etc;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

@RunWith( MyTargetTestClass.TheRunner.class )
public class MyTargetTestClass {
    static int count = 0;

    public boolean doStuff() {
        try {
            Thread.sleep( 1000 );
        } catch ( InterruptedException e ) {
        }
        count++;
        if ( count % 2 == 0 ) {
            throw new RuntimeException( "A Failure" );
        }

        return !( count % 3 == 0 );
    }

    public static class TheRunner extends Runner {
        List descriptions = new ArrayList();

        private final Class<? extends MyTargetTestClass> testClass;

        private final MyTargetTestClass testContainingInstance;

        private Description testSuiteDescription;

        public TheRunner( Class<? extends MyTargetTestClass> testClass ) {
            this.testClass = testClass;
            testContainingInstance = reflectMeATestContainingInstance( testClass );
            testSuiteDescription = Description.createSuiteDescription( "All my stuff is happening now dudes" );
            testSuiteDescription.addChild( createTestDescription( "first bit happening" ) );
            testSuiteDescription.addChild( createTestDescription( "second bit happening" ) );
            testSuiteDescription.addChild( createTestDescription( "third bit happening" ) );
        }

        @Override
        public Description getDescription() {
            return testSuiteDescription;
        }

        @Override
        public void run( RunNotifier notifier ) {
            for ( Description description : testSuiteDescription.getChildren() ) {
                notifier.fireTestStarted( description );
                try {
                    if ( testContainingInstance.doStuff() ) {
                        notifier.fireTestFinished( description );
                    } else {
                        notifier.fireTestIgnored( description );
                    }
                } catch ( Exception e ) {
                    notifier.fireTestFailure( new Failure( description, e ) );
                }
            }

        }

        private MyTargetTestClass reflectMeATestContainingInstance( Class<? extends MyTargetTestClass> testClass ) {
            try {
                return testClass.newInstance();
            } catch ( Exception e ) {
                throw new RuntimeException( e );
            }
        }

        private Description createTestDescription( String description ) {
            return Description.createTestDescription( testClass, description );
        }

    }
}
