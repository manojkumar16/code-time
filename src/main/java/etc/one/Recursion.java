package etc.one;
public class Recursion {

    public static void main( String[] args ) {
        Recursion obj = new Recursion();

        System.out.println( obj );

        Recursion obj2 = obj;

        System.out.println( obj2 );

        Recursion obj3 = new Recursion();
        System.out.println( obj3 );
        
        
        System.out.println("Hello world.");
int m=90;        
        
        
        
        System.out.println( new Recursion() );

        // display( 10 );

    }

    private static void display( int num ) {
        System.out.println( num );
        if ( num > 1 ) {
            display( num - 1 );
        }
    }

}
