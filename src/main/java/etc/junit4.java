package etc;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith( value = CustomTestRunner.class )
public class junit4 {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Before class executing...");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("After class executing...");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Before method executing...");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After method executing...");
    }

    @ReverseCharRecursion
    public void testFail() {
        System.out.println( "Executing testFail()" );
        // fail( "Not yet implemented" );
        assertTrue( "fail it", false );
    }

    @ReverseCharRecursion( expected = ArithmeticException.class )
    public void testDivideByZero() {
        System.out.println( "Executing testDivideByZero()" );
        int k = 10;
        int res = k / 0;
    }

    @ReverseCharRecursion
    public void Success() {
        System.out.println("Executing Success()");
    }

    public void testNoRun() {

    }
}
