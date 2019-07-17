package algorithmsAndDS;

public class Numbers {

    public static void main( String[] args ) {
        // print numbers from 1 to 100 without using loop?
  //      printNumbers( 100 );
        System.out.println( "\n===================================================================" );
        
        char []ch1 = new char[] {'a', 'b', 'c', 'd'};
        char []ch2 = new char[] {'a', 'b', 'a'};
        int k = 2;
        printAllKLengthStrings(ch1, ch1.length, "", k);
        System.out.println("\n-----------------------------------------");
        printAllKLengthStrings(ch2, ch2.length, "", k);
        
        System.out.println( "\n\n===================================================================" );
        printCombination(ch1, 0, ch1.length-1, "", 0, k);
        
    }

    private static void printCombination( char[] ch, int start, int end, String prefix, int index, int k ) {
        if ( index == k ) {
            System.out.print( prefix + ", " );
            return;
        }

        for(int i=start; i<=end && end-i+1 >= k-index; i++) {
            printCombination( ch, i, end, prefix + ch[i], index+1, k );
        }
    }

    private static void printAllKLengthStrings( char[] ch, int len, String prefix, int k ) {
        // Base case; if k=0, print string
        if ( k == 0 ) {
            System.out.print( prefix + ", " );
            return;
        }

        // prefix = prefix + ch[0];

        for ( int i = 0; i < len; i++ ) {
            String newPrefix = prefix + ch[i];
            printAllKLengthStrings( ch, len, newPrefix, k - 1 );
        }
    }

    private static void printNumbers( int n ) {
        if ( n <= 0 )
            return;

        printNumbers( n - 1 );
        System.out.print( n + " " );
    }

}
