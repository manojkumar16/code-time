package algorithmsAndDS;

// http://en.wikipedia.org/wiki/Counting_sort
public class CountingSort {

    public static void main( String[] args ) {
        int[] a = { 1, 4, 1, 2, 7, 5, 2 };
        csort( a, 10 );
    }

    private static void csort( int[] a, int k ) {
        display( a );
        int[] count = new int[k];

        // 1. Take a count array to store the count of each unique object
        for ( int i = 0; i < a.length; i++ ) {
            count[a[i]] = count[a[i]] + 1;
        }
        display( count );

        // 2. Modify the count array such that each element at each index stores the sum of previous counts.
        for ( int i = 1; i < count.length; i++ ) {
            count[i] = count[i] + count[i - 1];
        }
        display( count );

        // 3. The modified count array indicates the position of each object in the output sequence.
        // Output each object from the input sequence followed by decreasing its count by 1.
        int[] output = new int[a.length];
        for ( int i = 0; i < a.length; i++ ) {
            output[count[a[i]] - 1] = a[i];
            --count[a[i]];
        }
        display( output );

    }

    private static void display( int[] arr ) {
        for ( int i : arr ) {
            System.out.print( i + "  " );
        }
        System.out.println();
    }

}
