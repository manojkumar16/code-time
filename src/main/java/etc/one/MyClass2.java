package etc.one;

public class MyClass2 {
    public static void main( String[] args ) {
        Integer m = 6;
        Integer[] h = { 3, 3, 4, 4, 4, 2, 3, 1, 3, 2, 1, 4, 7, 3, 1, 6, 4, 1 };
        rain( m, h );
    }

    public static void rain( Integer m, Integer[] heights ) {
        int row_len = heights.length / m;
        int[][] mesh = new int[row_len][m];
        int sum = 0;
        for ( int i = 0; i < row_len; i++ ) {
            fill( heights, mesh, i, m );
        }

        System.out.println( mesh );

        for ( int i = 1; i < row_len - 1; i++ ) {
            for ( int j = 1; j < m - 1; j++ ) {
                int water = getAvailableWater(mesh,i,j);
            }
        }

    }

    private static int getAvailableWater( int[][] mesh, int r, int c ) {
        int top = mesh[r-1][c];
        int bottom = mesh[r+1][c];
        int left = mesh[r][c-1];
        int right = mesh[r][c+1];
        int key = mesh[r][c];
        if(key < top && key < bottom && key < left && key < right ){
            
        }
        return 0;
    }

    private static void fill( Integer[] heights, int[][] mesh, int row, Integer col_len ) {
        int j = 0;
        for ( int i = row * col_len; i < row * col_len + col_len; i++ ) {
            mesh[row][j++] = heights[i];
        }
    }
}
