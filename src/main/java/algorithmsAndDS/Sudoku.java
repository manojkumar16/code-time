package algorithmsAndDS;

/**
 * http://www.geeksforgeeks.org/backtracking-set-7-suduku/
 * 
 * @author mkprasad
 * 
 */
public class Sudoku {
    static int N = 9;

    static int BOX_SIZE = 3;

    static int UNASSIGNED = 0;
    
    public static void main( String[] args ) {
     // 0 means unassigned cells
/*        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                          {5, 2, 0, 0, 0, 0, 0, 0, 0},
                          {0, 8, 7, 0, 0, 0, 0, 3, 1},
                          {0, 0, 3, 0, 1, 0, 0, 8, 0},
                          {9, 0, 0, 8, 6, 3, 0, 0, 5},
                          {0, 5, 0, 0, 9, 0, 6, 0, 0},
                          {1, 3, 0, 0, 0, 0, 2, 5, 0},
                          {0, 0, 0, 0, 0, 0, 0, 7, 4},
                          {0, 0, 5, 2, 0, 6, 3, 0, 0}};*/
        int grid[][] = {
            {0, 8, 0, 6, 0, 5, 0, 1, 0},
            {7, 0, 0, 0, 9, 0, 0, 0, 5},
            {5, 0, 3, 0, 0, 0, 8, 0, 6},
            {0, 0, 6, 2, 0, 7, 3, 0, 0},
            {0, 0, 0, 0, 6, 0, 0, 0, 0},
            {0, 0, 5, 9, 0, 8, 1, 0, 0},
            {2, 0, 4, 0, 0, 0, 5, 0, 9},
            {6, 0, 0, 0, 8, 0, 0, 0, 7},
            {0, 5, 0, 4, 0, 9, 0, 2, 0}};
        
        Sudoku s = new Sudoku();
        if ( s.solveSudoku( grid ) == true )
            s.printGrid( grid );
        else
            System.out.println( "No solution exists" );
    }

    /**
     * Takes a partially filled-in grid and attempts to assign values to all unassigned locations in such a way to meet
     * the requirements for Sudoku solution (non-duplication across rows, columns, and boxes)
     */
    private boolean solveSudoku( int[][] grid ) {
        int row, col = 0;
        int[] rc = new int[2];
        // If there is no unassigned location, we are done
        if ( !FindUnassignedLocation( grid, rc ) ) {
            return true; // success!
        }
        row = rc[0];
        col = rc[1];
        // consider digits 1 to 9
        for ( int num = 1; num <= N; num++ ) {
            // if looks promising
            if ( isSafe( grid, row, col, num ) ) {
                // make tentative assignment
                grid[rc[0]][rc[1]] = num;

                // return, if success, yay!
                if ( solveSudoku( grid ) ) {
                    return true;
                }

                // failure, unmake & try again
                grid[row][col] = UNASSIGNED;

            }
        }
        return false;
    }

    /*
     * Returns a boolean which indicates whether it will be legal to assign num to the given row,col location.
     */
    private boolean isSafe( int[][] grid, int row, int col, int num ) {

        /*
         * Check if 'num' is not already placed in current row, current column and current 3x3 box
         */
        return !UsedInRow( grid, row, num ) && !UsedInCol( grid, col, num )
            && !UsedInBox( grid, row - row % BOX_SIZE, col - col % BOX_SIZE, num );
    }

    /*
     * Returns a boolean which indicates whether any assigned entry in the specified row matches the given number.
     */
    private boolean UsedInRow( int[][] grid, int row, int num ) {
        for ( int c = 0; c < N; c++ ) {
            if ( grid[row][c] == num ) {
                return true;
            }
        }
        return false;
    }

    /*
     * Returns a boolean which indicates whether any assigned entry in the specified column matches the given number.
     */
    private boolean UsedInCol( int[][] grid, int col, int num ) {
        for ( int r = 0; r < N; r++ ) {
            if ( grid[r][col] == num ) {
                return true;
            }
        }
        return false;
    }

    /*
     * Returns a boolean which indicates whether any assigned entry within the specified 3x3 box matches the given
     * number.
     */
    private boolean UsedInBox( int[][] grid, int boxStartRow, int boxStartCol, int num ) {
        for ( int r = 0; r < BOX_SIZE; r++ ) {
            for ( int c = 0; c < BOX_SIZE; c++ ) {
                if ( grid[r + boxStartRow][c + boxStartCol] == num ) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean FindUnassignedLocation( int[][] grid, int[] rc ) {
        for ( int row = 0; row < N; row++ ) {
            for ( int col = 0; col < N; col++ ) {
                if ( grid[row][col] == UNASSIGNED ) {
                    rc[0] = row;
                    rc[1] = col;
                    return true;
                }
            }
        }
        return false;
    }

    /* A utility function to print grid */
    private void printGrid( int[][] grid ) {
        for ( int r = 0; r < N; r++ ) {
            for ( int c = 0; c < N; c++ ) {
                System.out.print( grid[r][c] + "  " );
            }
            System.out.println();
        }
    }
}
