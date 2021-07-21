package algo.ds.leetcode;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 */
public class NumberOfIslands {

    public static void main(String[] args) {
        NumberOfIslands ob = new NumberOfIslands();

        int numIslands = ob.numIslands(getSampleGrid());
        System.out.println(numIslands);

    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands += dfs(grid, i, j);
                }
            }
        }

        return numIslands;
    }

    public int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0';
        dfs(grid, i + 1, j); // go one level down
        dfs(grid, i - 1, j); // go one level up
        dfs(grid, i, j + 1); // next element in i-th row
        dfs(grid, i, j - 1); // previous element in i-th row
        return 1;
    }

    private static char[][] getSampleGrid() {
        char[][] grid = new char[4][5];
        grid[0][0] = '1';
        grid[0][1] = '1';
        grid[0][2] = '0';
        grid[0][3] = '0';
        grid[0][4] = '0';

        grid[1][0] = '1';
        grid[1][1] = '1';
        grid[1][2] = '0';
        grid[1][3] = '0';
        grid[1][4] = '0';

        grid[2][0] = '0';
        grid[2][1] = '0';
        grid[2][2] = '1';
        grid[2][3] = '0';
        grid[2][4] = '0';

        grid[3][0] = '0';
        grid[3][1] = '0';
        grid[3][2] = '0';
        grid[3][3] = '1';
        grid[3][4] = '1';
        return grid;
    }
}
