package etc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnit4TestClass {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println( "Executing setUpBeforeClass()" );
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println( "Executing tearDownAfterClass()" );
    }

    @Before
    public void setUp() throws Exception {
        System.out.println( "Executing setUp()" );
    }

    @After
    public void tearDown() throws Exception {
        System.out.println( "Executing tearDown()" );
    }

    @ReverseCharRecursion
    public void testJunit4Success() {
        System.out.println( "Executing testSuccess()." );
    }

    public void testNoExecution() {
        System.out.println( "Executing testNoExecution()" );
    }

}
