package etc.junittesting;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * A Junit 4 runner
 * @author mkprasad
 *
 */
public class JUnit4Runner extends BlockJUnit4ClassRunner implements ITag {

	List<Method> methods;
	int executionCount = 1;
	private String testSuiteName;
    private Object testObjectName;
	
	public String getTestSuiteName() {
        return testSuiteName;
    }

    public void setTestSuiteName( String testSuiteName ) {
        this.testSuiteName = testSuiteName;
    }

    public JUnit4Runner(Class<?> klass, Method...method) throws InitializationError {
		super(klass);
		methods = Arrays.asList(method);
		validate();// Here we go!!
	}
	
	public JUnit4Runner(Class<?> klass) throws InitializationError {
		super(klass);
	}

	public void setExecutionCount(int count){
		this.executionCount = count;
	}
	
	@Override
	protected List<FrameworkMethod> computeTestMethods() {

		List<FrameworkMethod> meths = sorted(super.computeTestMethods());
		
		//System.out.println(methods);
		if(this.methods ==  null) return meths;
		
		ArrayList<FrameworkMethod> newMethods = new ArrayList<FrameworkMethod>();
		
        if ( meths != null){
			for (FrameworkMethod fMethod : meths) {
				if(this.methods.contains(fMethod.getMethod())){
					for(int i=0;i<executionCount;i++){
					    if(executionCount == 1) {
					        newMethods.add(fMethod);
					    } else {
					        FrameworkMethod newMethod = new CustomFrameWorkMethod(fMethod.getMethod(),i);
					        newMethods.add(newMethod);
					    }
					}
				}
			}
		}
		return newMethods;// No sorting required here
	}

	private List<FrameworkMethod> sorted(List<FrameworkMethod> methods){
		if(getTestClass().getJavaClass().getAnnotation(Ordered.class)!=null){
			sort(methods);
		}
		return methods;
	}
	
	private void sort(List<FrameworkMethod> methods) {
		Collections.sort(methods, new Comparator<FrameworkMethod>() {
			@Override
			public int compare(FrameworkMethod m1, FrameworkMethod m2) {
				return getOrder(m1) - getOrder(m2);
			}

		});
	}

	private int getOrder(FrameworkMethod m) {
		Order order = m.getMethod().getAnnotation(Order.class);
		if(order == null) return Integer.MAX_VALUE;
		return order.value();
	}

	@Override
	protected void collectInitializationErrors(List<Throwable> errors) {
		//Just skip as the current constructor calls this before
		//variables are set properly.
		//Just doing this LAZY, see the constructor, the actual call happens there!!
	}
	
	private void validate() throws InitializationError {
		  List<Throwable> errors= new ArrayList<Throwable>();
		  super.collectInitializationErrors(errors);
		  //System.out.println(errors);
		  if (!errors.isEmpty())
			  throw new InitializationError(errors);
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