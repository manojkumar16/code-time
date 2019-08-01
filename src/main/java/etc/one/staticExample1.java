package etc.one;
import java.util.ArrayList;
import java.util.List;


public class staticExample1 {

    public static final String STARTED = "STARTED";
    
    public static final String FAILED = "STOPPED";

    public static final List<String> FAILED_STATE = new ArrayList<String>(); 
    
    static {
     //FAILED_STATE.add( "FAILED" );
    // FAILED_STATE.add( "STOPPED" );
    // FAILED_STATE.add( "STOP_FAILED" );
    }
    
    public static void main( String[] args ) {
        System.out.println(FAILED_STATE);
    }

}
