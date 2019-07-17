package algorithmsAndDS;

import java.util.ArrayList;

/**
 * Write an algorithm to prim all ways of arranging eight queens on an 8x8 chess board so that none of them share the
 * same row, column or diagonal. In this case, "diagonal" means all diagonals, not just the two that bisect the board.
 * 
 * Solution: Check cracking the coding interview or Saurabhschool vid
 * 
 * Observe that since each row can only have one queen, we don't need to store our board as a full 8x8 matrix. We only
 * need a single array where column [row] = c indicates that row r has a queen at column c.
 */
public class NQueensProblem {
    static int GRID_SIZE = 4;

    public static void main( String[] args ) {
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();

        Integer[] columns = new Integer[GRID_SIZE];

        placeQueens( 0, columns, results );
        Integer[] cols = results.get( 0 );
        for ( Integer i : cols ) {
            System.out.println( i );
        }
    }

    private static void placeQueens( int row, Integer[] columns, ArrayList<Integer[]> results ) {
        if ( row == GRID_SIZE ) { // Found valid placement
            results.add( columns.clone() );
        } else {
            for ( int col = 0; col < GRID_SIZE; col++ ) {
                if ( checkValid( columns, row, col ) ) {
                    columns[row] = col; // Place the queen
                    placeQueens( row + 1, columns, results );
                }
            }
        }
    }

    /*
     * Check if (row1, col1) is a valid spot for a queen by checking if there is a queen in the same column or diagonal.
     * We don't need to check it for queens in the same row because the calling placeQueen only attempts to place one
     * queen at a time. We know this row is empty.
     */
    private static boolean checkValid( Integer[] columns, int row1, int col1 ) {
        for ( int row2 = 0; row2 < row1; row2++ ) {
            Integer col2 = columns[row2];
            // Check if (row2, column2) invalidates (row1, column1) as a queen spot.
            /* Check if rows have a queen in the same column */
            if ( col2 == col1 ) {
                return false;
            }

            /*
             * Check diagonals: if the distance between the columns equals the distance between the rows, then they're
             * in the same diagonal.
             */
            int columnDistance = Math.abs( col1 - col2 );
            int rowDistance = row1 - row2; // row1 > row2, so no need for abs
            if ( columnDistance == rowDistance ) {
                return false;
            }
        }
        return true;
    }

}
