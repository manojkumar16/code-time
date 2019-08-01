package algo.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Write a function to check whether two given strings are anagram of each other or not. An anagram of a string is
 * another string that contains same characters, only the order of characters can be different. For example, “abcd” and
 * “dabc” are anagram of each other.
 * 
 * @author mkprasad
 * 
 */
public class Anagram {

    public static void main( String[] args ) {
        String str1 = "abcd";
        String str2 = "dabc";//"bcdaa";
        
        //method1_sortAlgo( str1, str2 );
        //method2_hashMap( str1, str2 );
        method3_countArray( str1, str2 );
        method3_countArray( "aabbcd", "abbcd" );

    }

    /**
     * This method assumes that the set of possible characters in both strings is small. In the following
     * implementation, it is assumed that the characters are stored using 8 bit and there can be 256 possible
     * characters. 
     * 1) Create count arrays of size 256 for both strings. Initialize all values in count arrays as 0. 
     * 2) Iterate through every character of both strings and increment the count of character in the corresponding count
     * arrays. 
     * 3) Compare count arrays. If both count arrays are same, then return true.
     */
    private static void method3_countArray( String str1, String str2 ) {
     // Create two count arrays and initialize all values as 0
        int[] count1 = new int[256];
        int[] count2 = new int[256];
        int i;
     
        if(str1.length()!=str2.length()){
            System.out.println("not anagram");
            return;
        }
        // For each character in input strings, increment count in
        // the corresponding count array
        for (i = 0; i< str1.length();  i++)
        {
            count1[str1.charAt( i )]++;
            count2[str2.charAt( i )]++;
        }
     /*
        // If both strings are of different length. Removing this condition
        // will make the program fail for strings like "aaca" and "aca"
        if (str1[i] || str2[i])
          return false;*/
     
        // Compare count arrays
        for (i = 0; i < 256; i++)
            if (count1[i] != count2[i]) {
                System.out.println("not anagram...");
                return;
            }
        System.out.println("Anagram");
    }

    /**
     * Using hashmap 
     * Iterate thru str1 and put each characher in map. If map contains key, increment value by 1 
     * Iterate thru str2 and get each character from map. If map contains key, decrement value by 1. 
     * Iterate thru map and check if all keys have value set to 0. If not, then they are not anagram.
     */
    private static void method2_hashMap( String str1, String str2 ) {
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        for ( int i = 0; i < str1.length(); i++ ) {
            if ( hm.containsKey( str1.charAt( i ) ) ) {
                hm.put( str1.charAt( i ), hm.get( str1.charAt( i ) ) + 1 );
            } else {
                hm.put( str1.charAt( i ), 1 );
            }
        }

        for ( int i = 0; i < str2.length(); i++ ) {
            if ( hm.containsKey( str2.charAt( i ) ) ) {
                hm.put( str2.charAt( i ), hm.get( str2.charAt( i ) ) - 1 );
            } else {
                System.out.println( "They are not anagram." );
                return;
            }
        }

        // if key has value greater than 0, then it is not anagram
        Set<Character> keys = hm.keySet();
        for ( Character ch : keys ) {
            if ( hm.get( ch ) != 0 ) {
                System.out.println( "They are not anagram." );
                return;
            }
        }

        System.out.println( "They are anagram." );
    }

    /**
     * Use sorting algorithm. sort both strings. compare them
     */
    private static void method1_sortAlgo( String str1, String str2 ) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        Arrays.sort( ch1 );
        Arrays.sort( ch2 );

        if ( Arrays.toString( ch1 ).equals( Arrays.toString( ch2 ) ) ) {
            System.out.println( "Both strings are anagram to each other." );
        } else {
            System.out.println( "Strings are NOT anagram to each other." );
        }
    }

}
