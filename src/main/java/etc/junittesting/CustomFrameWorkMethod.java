package etc.junittesting;

import java.lang.reflect.Method;

import org.junit.runners.model.FrameworkMethod;

/**
 * A custom class for test method
 * @author mkprasad
 *
 */
public class CustomFrameWorkMethod extends FrameworkMethod {

    private int index;

    public CustomFrameWorkMethod( Method method, int index ) {
        super( method );
        this.index = index;
    }

    @Override
    public String getName() {
        return super.getName()+"["+index+"]";
    }
}
