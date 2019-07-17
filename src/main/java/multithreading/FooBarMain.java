package multithreading;


public class FooBarMain implements Foo {

    public static void main( String[] args ) {
        try {
            Bar b = new Bar();
            System.out.println("try entering...");
            b.print();
            System.out.println("It will never be printed");
        } finally{
            System.out.println("finally");
        }
    }

    @Override
    public void abc() {
        
    }
}

class Bar {
    int f1=1;
    int f2=2;
    int f3=3;
    public void print() {
        System.out.println("in Bar...");
        System.exit( 5 );
    }
}
