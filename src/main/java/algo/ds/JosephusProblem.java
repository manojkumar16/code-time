package algo.ds;

/**
 * There are people standing in a circle waiting to be executed. The counting out begins at some point in the circle and
 * proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the next
 * person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed
 * people are removed), until only the last person remains, who is given freedom.
 * 
 * The task is to choose the place in the initial circle so that you are the last one remaining and so survive.
 * 
 * @author mkprasad
 * 
 */
public class JosephusProblem {

    public static void main( String[] args ) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
        int n = arr.length;
        int k = 2;
        int ind = josephus( n, k, 1 );
        System.out.println(ind);
    }

    private static int josephus( int n, int k, int startingPoint ) {
        if ( n == 1 )
            return 1;
        int newSp = ( startingPoint + k - 2 ) % n + 1;

        int survivor = josephus( n - 1, k, newSp );
        if ( survivor < newSp ) {
            return survivor;
        } else
            return survivor + 1;
    }

}
