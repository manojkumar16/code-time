package algo.ds.leetcode;

/**
Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Example:

Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
Follow up:
Could you do better than O(n2) per move() operation?
 
 * Look at 2nd approach
 * @author manoj
 *
 */
public class DesignTicTacToe {

	/**
	 * Look at 2nd approach
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Your TicTacToe object will be instantiated and called as such: TicTacToe obj
	 * = new TicTacToe(n); int param_1 = obj.move(row,col,player);
	 */
	int[][] board;

	/** Initialize your data structure here. */
	public DesignTicTacToe(int n) {
		board = new int[n][n];
	}

	// O(n)
	/**
	 * Player {player} makes a move at ({row}, {col}).
	 * 
	 * @param row
	 *            The row of the board.
	 * @param col
	 *            The column of the board.
	 * @param player
	 *            The player, can be either 1 or 2.
	 * @return The current winning condition, can be either: 0: No one wins. 1:
	 *         Player 1 wins. 2: Player 2 wins.
	 */
	public int move(int row, int col, int player) {
		board[row][col] = player;
		if (win(row, col, player) == 1)
			return player;
		else
			return 0;
	}

	public int win(int r, int c, int p) {
		int i;
		// across row r
		for (i = 0; i < board.length; i++)
			if (board[r][i] != p)
				break;
		if (i == board.length)
			return 1;

		// across column c
		for (i = 0; i < board.length; i++)
			if (board[i][c] != p)
				break;
		if (i == board.length)
			return 1;

		// across left to right diagonal
		if (r == c) {
			for (i = 0; i < board.length; i++)
				if (board[i][i] != p)
					break;
			if (i == board.length)
				return 1;
		}

		// across right to left diagonal
		if (r + c + 1 == board.length) {
			int rr = 0, cc = board.length - 1;
			for (; rr < board.length && cc >= 0; rr++, cc--)
				if (board[rr][cc] != p)
					break;
			if (rr == board.length && cc == -1)
				return 1;
		}
		return 0;
	}
    
    
    //  ==================================
    
    
    /**
	 * Initially, I had not read the Hint in the question and came up with an O(n)
	 * solution. After reading the extremely helpful hint; a much easier approach
	 * became apparent. The key observation is that in order to win Tic-Tac-Toe you
	 * must have the entire row or column. Thus, we don't need to keep track of an
	 * entire n^2 board. We only need to keep a count for each row and column. If at
	 * any time a row or column matches the size of the board then that player has
	 * won.
	 * 
	 * To keep track of which player, I add one for Player1 and -1 for Player2.
	 * There are two additional variables to keep track of the count of the
	 * diagonals. Each time a player places a piece we just need to check the count
	 * of that row, column, diagonal and anti-diagonal.
	 *
	 * 
	 */
    //O(1) :
	class TicTacToe {
		private int[] rows;
		private int[] cols;
		private int diagonal;
		private int antiDiagonal;

		/** Initialize your data structure here. */
		public TicTacToe(int n) {
			rows = new int[n];
			cols = new int[n];
		}

		/**
		 * Player {player} makes a move at ({row}, {col}).
		 * 
		 * @param row
		 *            The row of the board.
		 * @param col
		 *            The column of the board.
		 * @param player
		 *            The player, can be either 1 or 2.
		 * @return The current winning condition, can be either: 0: No one wins. 1:
		 *         Player 1 wins. 2: Player 2 wins.
		 */
		public int move(int row, int col, int player) {
			int toAdd = player == 1 ? 1 : -1;

			rows[row] += toAdd;
			cols[col] += toAdd;
			if (row == col) {
				diagonal += toAdd;
			}

			if (col == (cols.length - row - 1)) {
				antiDiagonal += toAdd;
			}

			int size = rows.length;
			if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diagonal) == size
					|| Math.abs(antiDiagonal) == size) {
				return player;
			}

			return 0;
		}
	}
}
