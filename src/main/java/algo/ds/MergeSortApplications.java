package algo.ds;

public class MergeSortApplications {
    static int[] sortedArray;

    public static void main( String[] args ) {
        int[] num = new int[] { 10, 5, 8, 58 };
        sortedArray = new int[num.length];

        for ( int n : num ) {
            System.out.print( n + "  " );
        }
        mergesort( num, 0, num.length - 1 );

        System.out.println();
        System.out.println( "-----------------" );

        for ( int n : sortedArray ) {
            System.out.print( n + "  " );
        }
    }

    private static void mergesort( int[] num, int first, int last ) {

        if ( first >= last ) {
            return;
        }
        int mid = first + ( last - first ) / 2;
        mergesort( num, first, mid );
        mergesort( num, mid + 1, last );

        merge( num, first, mid, last );

    }

    private static void merge( int[] num, int first, int mid, int last ) {
        int low = first;
        int f = first;
        int start_last = mid + 1;

        while ( low <= mid && start_last <= last ) {
            if ( num[low] <= num[start_last] ) {
                sortedArray[f++] = num[low++];
            } else {
                sortedArray[f++] = num[start_last++];
            }
        }

        if ( low <= mid ) {
            for ( int i = low; i <= mid; i++ ) {
                sortedArray[f++] = num[i];
            }
        } else {
            for ( int i = start_last; i <= last; i++ ) {
                sortedArray[f++] = num[i];
            }
        }
    }
}
