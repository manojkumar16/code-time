package etc.one;

import java.util.List;

public class BoxMain {

    public static void main( String[] args ) {
        Box<Integer> iBox = new BoxImpl<Integer>( 3 );
        Number num = iBox.get();
        System.out.println( num );

        Box<Number> nBox = new BoxImpl<Number>( 3.2 );
        Integer i = 5;
        nBox.put( i );
        System.out.println( nBox.get() );

        nBox.put( iBox );
    }

    public static <T extends Comparable<? super T>> void sort( List<T> list ) {
    }

}
