package etc;

import java.net.URLClassLoader;
import java.util.Arrays;

public class TestClassLoader {

    public static void main( String[] args ) {
        A a = new A();
        a.display();
        
        System.out.println(Arrays.toString( ((URLClassLoader)TestClassLoader.class.getClassLoader()).getURLs() ));
    }

}
