package algorithmsAndDS;

/*
 * Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that maximizes product
 * of lengths of all parts. You must make at least one cut. Assume that the length of rope is more than 2 meters.
 */
/*
 * Examples:
 * 
 * Input: n = 2 Output: 1 (Maximum obtainable product is 1*1)
 * 
 * Input: n = 3 Output: 2 (Maximum obtainable product is 1*2)
 * 
 * Input: n = 4 Output: 4 (Maximum obtainable product is 2*2)
 * 
 * Input: n = 5 Output: 6 (Maximum obtainable product is 2*3)
 * 
 * Input: n = 10 Output: 36 (Maximum obtainable product is 3*3*4)
 */
// http://www.geeksforgeeks.org/dynamic-programming-set-36-cut-a-rope-to-maximize-product/
// http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
public class MaxProduct {
    public static void main( String[] args ) {
        for ( int k = 4; k <= 10; k++ ) {
            int[] val = new int[k + 1];
            val[0] = 1;
            val[1] = 1;
            val[2] = 2;
            val[3] = 3;

            for ( int i = 4; i <= k; i++ ) {
                int max_val = 0;
                for ( int j = 1; j <= i / 2; j++ ) {
                    if ( max_val < val[j] * val[i - j] ) {
                        max_val = val[j] * val[i - j];
                    }
                }
                val[i] = max_val;
            }

            System.out.println( k + "--" + val[k] );

        }
    }
}
