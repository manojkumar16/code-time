package etc.one;
/**
 * You have 100 coins which needs to be distributed among 3 beggars A, B, C. In how many ways you can distribute these
 * 100 coins to all the 3 beggars. Constraint: A cannot have more than 75 coins, B cannot have more than 50 coins, C
 * cannot have more than 25 coins
 * 
 * @author mkprasad
 * 
 */
public class ABC {

    public static void main( String[] args ) {
        // A<=75 && B<=50 && C<=25
        int count = 0;

        int a = 0;
        int b = 0;
        int c = 0;

        for ( a = 25; a <= 75; a++ ) {
            for ( b = 0; b <= min( 50, 100 - a ); b++ ) {
                for ( c = 0; c <= min( 25, 100 - a - b ); c++ )
                    if ( ( a + b + c ) == 100 )
                        count++;
            }
        }

        System.out.println(count);
    }

    private static int min( int i, int j ) {
        return i < j ? i : j;
    }

}
