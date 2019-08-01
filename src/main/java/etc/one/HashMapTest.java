package etc.one;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main( String[] args ) {
        System.out.println( "Hello" );
        Map<Employee1, String> hm = new HashMap<Employee1, String>();
        final Employee1 e = new Employee1();
        e.setName( "manoj" );
        hm.put( e, "A" );
        e.setName( "kumar" );
        System.out.println( hm.get( e ) );
        System.out.println(e.getName());
    }

}

class Employee1 {
    private String name;

    public void setName( String n ) {
        this.name = n;
    }

    public String getName() {
        return this.name;
    }
}
