package algorithmsAndDS;

/**
 * Count prime numbers less than N
 * 
 * Solution: Sieve of Eratosthenes algorithm
 */
public class CountPrimeNumbers {

    public static void main( String[] args ) {
        int count = countPrimeNumber( 121 );
        System.out.println( count );
    }

    private static int countPrimeNumber( int n ) {
        boolean[] bprimes = new boolean[n];
        int count = 0;
        bprimes[0] = true;
        bprimes[1] = true;
        bprimes[2] = true;
        bprimes[3] = true;
        bprimes[5] = true;
        bprimes[7] = true;

        for ( int i = 10; i < n; i++ ) {
            if ( i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0 ) {
                bprimes[i] = false;
            } else {
                bprimes[i] = true;
            }
        }

        for ( int i = 2; i < n; i++ ) {
            if ( bprimes[i] ) {
                count++;
            }
        }
        return count;
    }

}
