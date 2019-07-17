package etc.junittesting;

import junit.framework.Test;

import org.junit.internal.runners.JUnit38ClassRunner;

/**
 * A Junit 3 runner
 * @author mkprasad
 *
 */
public class JUnit3Runner extends JUnit38ClassRunner implements ITag {

    public JUnit3Runner( ReverseCharRecursion test ) {
        super( test );
    }

    public JUnit3Runner( Class<?> klass ) {
        super( klass );
    }

    private String testSuiteName;
    private Object testObjectName;

    public String getTestSuiteName() {
        return testSuiteName;
    }

    public void setTestSuiteName( String testSuiteName ) {
        this.testSuiteName = testSuiteName;
    }

    @Override
    public Object getTestObjectName() {
        return testObjectName;
    }

    @Override
    public void setTestObjectName( Object testObjectName ) {
        this.testObjectName = testObjectName;
    }

}
