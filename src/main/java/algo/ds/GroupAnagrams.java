package algo.ds;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given array of words, group the anagrams 
 * IP:{tar,rat,banana,atr} 
 * OP:{[tar,rat,atr],[banana]}
 * 
 * @author mkprasad
 * 
 */
public class GroupAnagrams {
    public static void main( String[] args ) {
        String[] arrwords = {"peat", "neat", "art", "tar", "top", "pot", "rat", "tape", "nate", "random" };
        display(arrwords);
        String[] srtdarrwords = sortAlphabetsInEachWord( arrwords );
        HashMap<String, String> wordmap = new HashMap<String, String>();
        display(arrwords);
        display(srtdarrwords);    
        int i = 0;
        for ( String s : srtdarrwords ) {
       //     System.out.println( s );
            if ( wordmap.containsKey( s ) ) {
                wordmap.put( s, wordmap.get( s ) + "," + arrwords[i++] );
              /*  System.out.println( "already contains, so adding" );
                System.out.println( wordmap.get( s ) );*/
            } else {
                wordmap.put( s, arrwords[i++] );
            }
        }
        for ( String s : wordmap.keySet() ) {
            System.out.println( "[" + wordmap.get( s ) + "]" );
        }

    }

    private static void display( String[] arrwords ) {
        for(String s: arrwords) {
            System.out.print(s+", ");
        }
        System.out.println();
    }

    private static String[] sortAlphabetsInEachWord( String[] inparr ) {
        String[] retstr = new String[inparr.length];
        int i = 0;
        for ( String s : inparr ) {
            retstr[i++] = s;
        }
        i = 0;
        for ( String s : retstr ) {
            char[] alphword = s.toCharArray();
            Arrays.sort( alphword );
            s = new String( alphword );
            retstr[i++] = s;
        }
        return retstr;
    }

}