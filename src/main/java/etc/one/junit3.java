package etc.one;
import junit.framework.TestCase;

import org.junit.Test;

public class junit3 extends TestCase {

    public junit3( String name ) {
        super( name );
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testJunit3Fail() {
        assertTrue( "sample fail test", false );
    }

    public void fail11() {
        assertTrue( "non test", false );
    }
    public void testJunitPass() {

    }

    @ReverseCharRecursion
    public void Success() {

    }
}
