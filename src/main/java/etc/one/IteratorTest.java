package etc.one;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class IteratorTest {

    public static void main( String[] args ) {
        Map<String, String> hm = new HashMap<String,String>();
        Iterator<String> iter = hm.keySet().iterator();
        if(iter.hasNext())
        {
            String key = iter.next();
            System.out.println(key);
        }
    }

}
