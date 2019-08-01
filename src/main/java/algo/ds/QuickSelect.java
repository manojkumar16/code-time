package algo.ds;

// Find kth largest element
public class QuickSelect {

    public static void main( String[] args ) {
        int[] a = {1, 23, 12, 9, 30, 2, 50};
        int k = 4;
        int kth = new QuickSelect().select( a, k );
        System.out.println(a[kth]);
    }

    private int select( int[] a, int k ) {
        int lo = 0;
        int hi = a.length - 1;
        while ( hi > lo ) {
            int i = partition(a, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return i;
        }
        return lo;
    }

    private int partition( int[] a, int lo, int hi ) {
        int i = lo;
        int j = hi;
        int v = a[lo];
        while (true) {
            while ( a[i] > v ) {
                i++;
                if ( i == hi )
                    break;
            }
            while ( a[j] < v ) {
                j--;
                if ( j == lo )
                    break;
            }
            
            // check if pointers cross
            if (i >= j) break;
            
            exch(a, i, j);
        }
        return j;
    }

    private void exch( int[] a, int i, int j ) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
