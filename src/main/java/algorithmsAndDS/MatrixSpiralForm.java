package algorithmsAndDS;

/*
Given a 2D array, print it in spiral form. See the following examples.

Input:
        1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 


Input:
        1   2   3   4  5   6
        7   8   9  10  11  12
        13  14  15 16  17  18
Output: 
1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
*/
public class MatrixSpiralForm {
    public static void main( String[] args ) {
/*        int a[][] = { { 1, 2, 3, 4, 5, 6 }, 
                      { 7, 8, 9, 10, 11, 12 }, 
                      { 13, 14, 15, 16, 17, 18 } 
                    };*/
        int[][] a = {   {1,    2,   3,   4},
                        {5,    6,   7,   8},
                        {9,   10,  11,  12},
                        {13,  14,  15,  16}
            
                    };

        spiralPrint( 3, 3, 0, 0, a );
    }

    /*
     * m - ending row index 
     * n - ending column 
     * k - starting row index 
     * l - starting column index 
     * index i - iterator
     */
    private static void spiralPrint( int m, int n, int k, int l, int[][] a ) {
        while ( k <= m && l <= n ) {
            
            // Print 1st row from left to right
            for ( int i = l; i <= n; i++ ) {
                System.out.print( a[k][i] + " " );
            }

            // Print last column from top to bottom
            for ( int i = k + 1; i <= m; i++ ) {
                System.out.print( a[i][n] + " " );
            }

            // Print last row from right to left
            if ( k < m ) {
                for ( int i = n - 1; i >= l; i-- ) {
                    System.out.print( a[m][i] + " " );
                }
            }

            // Print 1st column from bottom to top
            if ( l < n ) {
                for ( int i = m - 1; i >= k + 1; i-- ) {
                    System.out.print( a[i][l] + " " );
                }
            }
            
            //decrement m,n and increment k,l
            m--;
            n--;
            k++;
            l++;
            
        }
    }

}
