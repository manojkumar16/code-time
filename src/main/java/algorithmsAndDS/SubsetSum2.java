package algorithmsAndDS;

public class SubsetSum2 {

    public static void main( String[] args ) {
        int[] arr = { 10, 7, 5, 18, 12, 20, 15 };
        int M = 36;
        boolean[][] dp = new boolean[arr.length+1][M+1];
        dp[0][0] = true;
        for ( int i = 0; i < arr.length; i++ ) {
            for ( int s = 0; s < arr.length; s++ ) {
                for ( int j = M - 1; j >= 0; j-- ) {
                    if ( dp[s][j] && arr[i] + j <= M ) {
                        dp[s + 1][j + arr[i]] = true;
                    }
                }
            }
        }

        for ( int j = M; j >= 0; j-- ) {
            if ( dp[arr.length][j] ) {
                System.out.println( j );
                break;
            }
        }
    }

}
