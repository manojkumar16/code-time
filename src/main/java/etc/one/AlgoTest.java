package etc.one;
public class AlgoTest {

    public static void main( String[] args ) {
        int[] a = { 3, 5, 7, 9, 1 };
        int ind = elementInRotatedArray( a, 5, 3 );
        System.out.println( ind );
    }

    public static int elementInRotatedArray( int[] a, int n, int key ) {

        int mid = n / 2;

        while ( mid != 0 ) {
            if ( key == a[mid] ) {
                return mid;
            }
            if ( key < a[mid + 1] ) {
                // go to left sub array
                mid = ( mid - 1 ) / 2;

            } else {
                // go to right sub array
                mid = ( mid + n ) / 2;
            }
        }
        return -1;
    }

}
