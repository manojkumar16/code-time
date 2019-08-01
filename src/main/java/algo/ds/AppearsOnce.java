package algo.ds;

/**
 * Find the element that appears once Given an array where every element occurs three times, except one element which
 * occurs only once. Find the element that occurs once. Expected time complexity is O(n) and O(1) extra space.
 * http://www.geeksforgeeks.org/find-the-element-that-appears-once/
 * 
 * @author mkprasad
 * 
 */
public class AppearsOnce {

    public static void main( String[] args ) {
        int arr[] = { 12, 1, 12, 3, 12, 1, 1, 2, 3, 3 };
        System.out.println( getSingle( arr ) );
    }

    /**
     * We can sum the bits in same positions for all the numbers and take modulo with 3. The bits for which sum is not
     * multiple of 3, are the bits of number with single occurrence. Let us consider the example array {5, 5, 5, 8}. The
     * 101, 101, 101, 1000 Sum of first bits%3 = (1 + 1 + 1 + 0)%3 = 0; Sum of second bits%3 = (0 + 0 + 0 + 0)%0 = 0;
     * Sum of third bits%3 = (1 + 1 + 1 + 0)%3 = 0; Sum of fourth bits%3 = (1)%3 = 1; Hence number which appears once is
     * 1000
     */
    private static int getSingle( int[] a ) {
        int INT_MAX = 32;
        int result = 0;
        for ( int i = 0; i < INT_MAX; i++ ) {
            int sum = 0;
            int x = 1 << i;
            for ( int j = 0; j < a.length; j++ ) {
                if ( ( a[j] & x ) != 0 ) {
                    sum = sum + 1;
                }
            }
            if ( sum % 3 != 0 ) {
                result = result | x;
            }
        }
        return result;
    }

}
