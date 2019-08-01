package algo.ds;

import java.io.IOException;

public class DynamicConnectivityClient {

    public static void main( String[] args ) throws IOException {
        int N = StdIn.readInt();

        UF uf = new UF( N );

        while ( !StdIn.isEmpty() ) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if ( !uf.connected( p, q ) ) {
                uf.union( p, q );
                System.out.println( p + " " + q );
            }
        }
    }

}
