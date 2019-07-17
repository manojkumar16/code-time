package algorithmsAndDS;

/**
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * 
 * Permutations of string ABC --> ABC, ACB, BAC, BCA, CAB, CBA
 * 
 * @author mkprasad
 * 
 */
public class StringPermutations {
    static int count = 0;

    public static void main( String[] args ) {
        String str = "abc";
        permutate( str, 0, str.length() - 1 );
        System.out.println( "Number of permutations of String: " + count );
        
        System.out.println("=========");
        Count co = new Count();
        permutate2("",str,str.length(), co);
        System.out.println( "Number of permutations of String: " + co.c );
    }

    private static void permutate2( String cur, String str, int len, Count co ) {
        if ( cur.length() == len ) {
            System.out.println( cur );
            co.c = co.c + 1;
            return;
        }
        for ( int i = 0; i < str.length(); i++ ) {
            permutate2( cur + str.charAt( i ), str.substring( 0, i ) + str.substring( i + 1, str.length() ), len, co );
        }
    }

    private static void permutate( String str, int start, int end ) {
        if ( start == end ) {
            System.out.println( str );
            count++;
        } else {
            for ( int j = start; j <= end; j++ ) {
                str = swap( str, start, j );
                permutate( str, start + 1, end );
                str = swap( str, start, j ); // backtrack
            }
        }

    }

    private static String swap( String str, int i, int j ) {
        char c_i = str.charAt( i );
        char c_j = str.charAt( j );
        String str_i = str.substring( 0, i ) + c_j + str.substring( i + 1 );
        String str_j = str_i.substring( 0, j ) + c_i + str_i.substring( j + 1 );
        return str_j;
    }
    
    private static class Count {
        int c;
    }
}
