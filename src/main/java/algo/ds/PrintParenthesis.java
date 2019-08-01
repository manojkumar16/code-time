package algo.ds;

import java.util.ArrayList;
import java.util.List;

/*
 * http://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
 * 
 * Print all combinations of balanced parentheses September 24, 2010 Write a function to generate all possible n pairs
 * of balanced parentheses.
 * 
 * For example, if n=1 {} 
 * for n=2 
 * {}{} 
 * {{}}
 * 
 * Algorithm: 
 * Keep track of counts of open and close brackets. Initialize these counts as 0. Recursively call the
 * printParenthesis() function until open bracket count is less than the given n. If open bracket count becomes more
 * than the close bracket count, then put a closing bracket and recursively call for the remaining brackets. If open
 * bracket count is less than n, then put an opening bracket and call printParenthesis() for the remaining brackets.
 */
public class PrintParenthesis {
    public static void main( String[] args ) {
        validatePairOfBraces();
       // printParenthesis( 4, 0, 0, "" );
    }

    private static void validatePairOfBraces() {
        String str1 = "{{}}{}";
        String str2 = "{{{}}{}";
        String str3 = "}{{}}{}";
        String str4 = "{{}}{}{";
        String str5 = "{{}}{}}";
        List<String> ls = new ArrayList<String>();
        ls.add( str1 );
        ls.add( str2 );
        ls.add( str3 );
        ls.add( str4 );
        ls.add( str5 );
        for ( String str : ls ) {
            int open = 0;
            int close = 0;
            int ind = 0;
            if ( str.charAt( 0 ) == '}' || str.charAt( str.length() - 1 ) == '{' ) {
                System.out.println( "Invalid pair of braces...-" + str );
                continue;
            }
            for ( int i = ind; i < str.length(); i++ ) {
                char ch = str.charAt( i );
                if ( ch == '{' ) {
                    open++;
                } else {
                    close++;
                }
            }
            if ( open == close ) {
                System.out.println( "Valid pair of braces. - " + str );
            } else {
                System.out.println( "Invalid pair of braces. - " + str );
            }
        }

    }

    private static void printParenthesis( int n, int open, int close, String str ) {
        if ( close == n ) {
            System.out.println( str );
            return;
        } else {
            if ( open > close ) {
                printParenthesis( n, open, close + 1, str + "}" );
            }
            if ( open < n ) {
                printParenthesis( n, open + 1, close, str + "{" );
            }
        }

    }

}
