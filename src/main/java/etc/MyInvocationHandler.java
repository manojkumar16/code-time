package etc;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {
        System.out.println(method.getName());
        for(Object arg : args) {
            System.out.println(arg);
        }
        return null;
    }

}
