package etc.one;
import java.util.Calendar;

public class DemonstrateSyntheticMethods {

    public static void main( String[] args ) {
        DemonstrateSyntheticMethods.NestedClass nested = new DemonstrateSyntheticMethods.NestedClass();
        System.out.println( "String: " + nested.highlyConfidential );
    }

    private static final class NestedClass {
        private String highlyConfidential = "Don't tell anyone about me";

        private int highlyConfidentialInt = 42;

        private Calendar highlyConfidentialCalendar = Calendar.getInstance();

        private boolean highlyConfidentialBoolean = true;
    }
}
