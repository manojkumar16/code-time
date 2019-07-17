package algorithmsAndDS;

public class RecursionPractice {

    public static void main( String[] args ) {
        String abc = "abc";
        printPermutations( "", "abc" );
    }

    /**
     * print all permutations of a string
     */
    private static void printPermutations( String prefix, String str ) {
        int n = str.length();
        if ( n == 0 )
            System.out.println( prefix );
        else {
            for ( int i = 0; i < n; i++ )
                printPermutations( prefix + str.charAt( i ), str.substring( 0, i ) + str.substring( i + 1, n ) );
        }
    }
}
