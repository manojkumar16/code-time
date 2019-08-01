package algo.ds;

public class KeyIndexCountingPractice {

    public static void main( String[] args ) {
        char[] arr = new char[] { 'd', 'a', 'c', 'f', 'f', 'b', 'd', 'b', 'f', 'b', 'e', 'a' };
        int R = 256;
        int[] count = new int[R + 1];
        char[] aux = new char[arr.length];
        // count frequencies
        for ( int i = 0; i < arr.length; i++ ) {
            count[arr[i] + 1]++;
        }

        // count cumulative
        for ( int r = 0; r < R; r++ ) {
            count[r + 1] = count[r + 1] + count[r];
        }

        // aux array
        for ( int j = 0; j < arr.length; j++ ) {
            aux[count[arr[j]]++] = arr[j];
        }

        for ( int i = 0; i < aux.length; i++ ) {
            System.out.print( arr[i] + "   " + aux[i] );
            System.out.println();
        }
    }

}
