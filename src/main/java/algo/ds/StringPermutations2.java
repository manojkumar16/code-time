package algo.ds;

import java.util.ArrayList;

/**
 * Write a method to compute all permutations of a string Permutations of string.
 * ABC --> ABC, ACB, BAC, BCA, CAB, CBA
 * 
 * Solution: See cracking the coding interview
 */
public class StringPermutations2 {

    public static void main( String[] args ) {
        ArrayList<String> p = getPerms( "abc" );
        System.out.println( p );
    }

    private static ArrayList<String> getPerms( String str ) {
        if ( str == null ) {
            return null;
        }
        ArrayList<String> permutations = new ArrayList<String>();
        if ( str.length() == 0 ) { // base case
            permutations.add( "" );
            return permutations;
        }
        char first = str.charAt( 0 ); // get the first character
        String remainder = str.substring( 1 ); // remove the 1st character
        ArrayList<String> words = getPerms( remainder );
        for ( String word : words ) {
            for ( int j = 0; j <= word.length(); j++ ) {
                String s = insertCharAt( word, first, j );
                permutations.add( s );
            }
        }
        return permutations;
    }

    private static String insertCharAt( String word, char c, int j ) {
        String start = word.substring( 0, j );
        String end = word.substring( j );
        return start + c + end;
    }
}
