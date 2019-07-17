package etc.junittesting;

/**
 * An interface to hold description of test object
 * @author mkprasad
 *
 */
public interface ITag {
    public String getTestSuiteName();
    public void setTestSuiteName( String testSuiteName );
    
    public Object getTestObjectName();
    public void setTestObjectName( Object testClassName );
}
