package etc.one;
public class SortZeroOne {

    //0 1 1 1 0 1 1 0 0 0 1 1 
    //----------------
    //0 0 0 0 0 1 1 1 1 1 1 1 
    public static void main( String[] args ) {
        int[] a = { 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1 };
        for ( int i = 0; i < a.length; i++ )
            System.out.print( a[i] + " " );
        
        System.out.println("\n----------------");
        sort( a );
    }

    private static void sort( int[] a ) {
        int pos = 0;
        boolean bFlag = true;
        for ( int i = 0; i < a.length; i++ ) {

            if ( a[i] == 0 ) {
                if ( !bFlag ) {
                    swap( a, i, pos );
                    pos++;
                }

            } else if ( a[i] == 1 && bFlag ) {
                pos = i;
                bFlag = false;
            }

        }

        for ( int i = 0; i < a.length; i++ )
            System.out.print( a[i] + " " );
    }

    private static void swap( int[] a, int i, int pos ) {
        int temp = a[i];
        a[i] = a[pos];
        a[pos] = temp;
    }
}
