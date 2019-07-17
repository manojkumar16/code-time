package algorithmsAndDS;

public class SortingAlgorithm {

    public static void main( String[] args ) {
        long[] num = new long[] { 1361778821330L, 1361778820869L, 1361778833122L, 1361778820892L, 1361778832997L,
            1361778832908L, 1361778828641L };

        long[] sorted = sort( num );
        for ( long n : sorted ) {
            System.out.print( n + "  " );
        }
    }

    private static long[] sort( long[] num ) {

        for ( int i = 0; i < num.length; i++ ) {
            for ( int j = i; j < num.length; j++ ) {
                if ( num[j] < num[i] ) {
                    long temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        return num;
    }

}
