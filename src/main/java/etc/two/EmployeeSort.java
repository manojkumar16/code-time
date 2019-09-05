package etc.two;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSort {

    public static void main( String[] args ) {
        Employee e1 = new Employee( "Manoj1", "Kumar1", 1212L );
        Employee e2 = new Employee( "Manoj2", "Kumar2", 1200L );
        Employee e3 = new Employee( "Manoj3", "Kumar3", 1208L );
        Employee e4 = new Employee( "Manoj4", "Kumar4", 1216L );
        Employee e5 = new Employee( "Manoj5", "Kumar5", 1219L );
        Employee e6 = new Employee( "Manoj6", "Kumar6", 1216L );
        List<Employee> list = Arrays.asList( e1, e2, e3, e4, e5, e6 );
        for ( Employee e : list ) {
            System.out.println( e.timestamp + " - " + e.fname + " " + e.lname );
        }
        System.out.println("----------******-------");
        List<Employee> ls = sortedNewToOldRecords( list );

        for ( Employee e : ls ) {
            System.out.println( e.timestamp + " - " + e.fname + " " + e.lname );
        }
    }

    private static List<Employee> sortedNewToOldRecords( List<Employee> list ) {
        Collections.sort( list, new Comparator<Employee>() {
            @Override
            public int compare( Employee o1, Employee o2 ) {
                return ( o1.timestamp > o2.timestamp ? -1 : ( o1 == o2 ? 0 : 1 ) );
            }
        } );

        return list;
    }

}
