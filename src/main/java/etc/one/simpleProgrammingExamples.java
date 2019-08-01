package etc.one;
public class simpleProgrammingExamples {

    public static void main( String[] args ) {

        display( "Hello" );

        displayNumbers( 1, 10 );
    }

    private static void displayNumbers( int i, int j ) {
        for ( int num = i; num < j; num++ ) {
            System.out.println( num );
        }
    }

    private static void display( String str ) {
        System.out.println( str );
    }

}
