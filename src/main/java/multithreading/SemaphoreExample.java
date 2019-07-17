package multithreading;

public class SemaphoreExample {

    public static void main( String[] args ) throws InterruptedException {
        final Class1 obj1 = new Class1();
        final Class2 obj2 = new Class2();

        startThread_Class1( obj1, obj2 );

        for ( int i = 0; i < 6; i++ ) {
            System.out.println(i);
            startThread_Class2( obj2, i );
            Thread.sleep( 1000 );
        }
        
        //start again
        final Class2 obj3 = new Class2();
        startThread_Class1( obj1, obj3 );

        for ( int i = 0; i < 6; i++ ) {
            System.out.println(i);
            startThread_Class2( obj3, i );
            Thread.sleep( 1000 );
        }
        

    }

    private static void startThread_Class2( final Class2 obj2, final int i ) {
        Thread T = new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    obj2.start( i );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
        } );
        T.start();
    }

    private static void startThread_Class1( final Class1 obj1, final Class2 obj2 ) {
        Thread T = new Thread( new Runnable() {
            @Override
            public void run() {
                try {
                    obj1.start( obj2 );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            }
        } );
        T.start();
    }
}
