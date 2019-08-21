package algo.ds.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Eight Queens: Write an algorithm to print all ways of arranging eight queens
 * on an 8x8 chess board so that none of them share the same row, column, or
 * diagonal. In this case, "diagonal" means all diagonals, not just the two that
 * bisect the board.
 * 
 * @author m0k00i6
 *
 */
public class PlaceQueens {

	public static void main(String[] args) {
		System.out.println("Hello world!!!");
		Integer[] column = new Integer[8];
		List<Integer[]> result = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
		}
		placeQueens(0, column, result);

	}

	/**
	 * Column number in given row
	 * 
	 * @param row
	 * @param column
	 * @param result
	 */
	private static void placeQueens(int row, Integer[] columns, List<Integer[]> results) {
		if(row == 8) {
			results.add(columns.clone());
		}
		
		for(int col=0; col<8; col++) {
			if(checkValid(columns, row, col)) {
				placeQueens(row+1, columns, results);
			}
		}
	}

	private static boolean checkValid(Integer[] columns, int r, int c) {
		if(columns[r] != null ) {
			return false;
		}

		for(int i=0 ; i<columns.length; i++) {
			if(columns[i] == c) {
				return false;
			}
		}
		
		if(columns[r-1] == c-1 || columns[r-1] == c+1) {
			return false;
		}
		
		if(columns[r+1] == c+1 || columns[r+1] == c-1) {
			return false;
		}
		
		
		return true;
	}

}
