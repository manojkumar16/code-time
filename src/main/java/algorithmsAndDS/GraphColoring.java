package algorithmsAndDS;

public class GraphColoring {
    static int m = 4;

    static int[][] G = new int[][] { { 1, 1, 0, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 } };

    public static void main( String[] args ) {
        int size = 4;
        int[] x = new int[size];
        mcoloring( 0, size, x );
    }

    private static void mcoloring( int k, int n, int[] x ) {
        do {
            x[k] = getNodeColor( k, n, x );
            if ( x[k] == 0 )
                return;
            if ( k == n )
                display( x );
            else
                mcoloring( k + 1, n, x );
        } while ( true );
    }

    private static void display( int[] x ) {
        System.out.println(x);
    }

    private static int getNodeColor( int k, int n, int[] x ) {
        do {
            x[k] = ( x[k] + 1 ) % ( m + 1 );
            if ( x[k] == 0 )
                return 0; // all node tried

            int j = 0;
            for ( j = 0; j < n; j++ ) {
                if ( G[k][j] != 0 && x[k] == x[j] ) {
                    break;// same color
                }
            }
            if ( j == n )
                return x[k]; // new color found
        } while ( true );
    }
}
