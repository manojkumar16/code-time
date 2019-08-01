package algo.ds;

public class DuplicateNumber {

    public static void main( String[] args ) {
       // int arr[] = { 1, 2, 3, 1, 3, 6, 6 };
        int arr[] = { 1, 3, 2, 5, 1};
        printRepeating( arr );
    }

    private static void printRepeating( int[] arr ) {
        int size = arr.length;
        System.out.println( "The repeating elements are: \n" );
        for ( int i = 0; i < size; i++ ) {
            if ( arr[abs( arr[i] )] >= 0 )
                arr[abs( arr[i] )] = -arr[abs( arr[i] )];
            else
                System.out.print( " " + abs( arr[i] ) );
        }
    }

    private static int abs( int e ) {
        return e > 0 ? e : -e;
    }

}
