package algorithmsAndDS;

public class Snippet {
    private static boolean find( int key, int[] d, int s, int e ) {
        for ( int i = s; i < e; i++ ) {
            if ( key == d[i] ) {
                return true;
            }
        }
        return false;
    }
}

