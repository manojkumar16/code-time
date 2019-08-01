package algo.ds;

/*Write a program to add one to a given number. You are not allowed to use operators like 
 * ‘+’, ‘-’, ‘*’, ‘/’, ‘++’, ‘–’ …etc.

Examples:
Input: 12
Output: 13

Input: 6
Output: 7

*/
public class AddOneToNumber {

    public static void main( String[] args ) {
        System.out.println(addOne(12));
    }

    /*
     * To add 1 to a number x (say 0011000111), we need to flip all the bits after the rightmost 0 bit (we get
     * 0011000000). Finally, flip the rightmost 0 bit also (we get 0011001000) and we are done.
     */
    private static int addOne( int n ) {
        int m = 1;
        /* Flip all the set bits until we find a 0 */
        while((n & m) == 1){
            n = n^m;
            m = m <<1;
        }
        /* flip the rightmost 0 bit */
        n = n^m;
        return n;
    }

}
