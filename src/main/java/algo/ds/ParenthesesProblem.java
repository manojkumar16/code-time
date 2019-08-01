package algo.ds;

/**
 * http://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/ Write a function to generate all
 * possible n pairs of balanced parentheses.
 * 
 * For example, if n=1 [ {} ], for n=2 [ {}{}, {{}} ]
 * 
 * Algorithm: Keep track of counts of open and close brackets. Initialize these counts as 0. Recursively call the
 * _printParenthesis() function until open bracket count is less than the given n. If open bracket count becomes more
 * than the close bracket count, then put a closing bracket and recursively call for the remaining brackets. If open
 * bracket count is less than n, then put an opening bracket and call _printParenthesis() for the remaining brackets.
 * 
 * @author mkprasad
 * 
 */
public class ParenthesesProblem {
    static char[] str = new char[100];

    public static void main( String[] args ) {
        int n = 5;
        printParenthesis( n );
    }

    private static void printParenthesis( int n ) {
        if ( n > 0 )
            _printParenthesis( 0, n, 0, 0 );
        return;
    }

    private static void _printParenthesis( int pos, int n, int open, int close ) {

        if ( close == n ) {
            System.out.println( str );
            return;
        }
        if ( open > close ) {
            str[pos] = '}';
            _printParenthesis( pos + 1, n, open, close + 1 );
        }
        if ( open < n ) {
            str[pos] = '{';
            _printParenthesis( pos + 1, n, open + 1, close );
        }
    }

}
