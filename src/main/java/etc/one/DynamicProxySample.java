package etc.one;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxySample {

    public static void main( String[] args ) {
        InvocationHandler handler = new MyInvocationHandler();
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance( MyInterface.class.getClassLoader(),
            new Class[] { MyInterface.class }, handler );

    
        proxy.show( "hello" );
    }

}
