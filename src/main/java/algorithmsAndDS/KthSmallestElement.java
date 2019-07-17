package algorithmsAndDS;

public class KthSmallestElement {

    public static void main( String[] args ) {
        int[] array = { 1, 23, 12, 9, 30, 2, 50 };
        int rank = rank( array, 0, array.length - 1, 3 );
        System.out.println( rank );
    }

    private static int rank( int[] array, int left, int right, int rank ) {
        int pivot = array[1];

        /* Partition and return end of left partition */
        int leftEnd = partition( array, left, right, pivot );

        int leftSize = leftEnd - left + 1;
        if ( leftSize == rank + 1 ) {
            return max( array, left, leftEnd );
        } else if ( rank < leftSize ) {
            return rank( array, left, leftEnd, rank );
        } else {
            return rank( array, leftEnd + 1, right, rank );
        }
    }

    private static int max( int[] array, int left, int leftEnd ) {
        return array[left] > array[leftEnd] ? array[left] : array[leftEnd];
    }

    private static int partition( int[] array, int left, int right, int pivot ) {
        while ( true ) {
            while ( left <= right && array[left] <= pivot ) {
                left++;
            }
            while ( left <= right && array[right] >= pivot ) {
                right--;
            }
            if ( left > right ) {
                return left - 1;
            }
            swap( array, left, right );
        }
    }

    private static void swap( int[] array, int left, int right ) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
