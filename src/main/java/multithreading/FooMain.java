package multithreading;

public class FooMain extends f1 implements Foo1, Foo2 {

    public static void main( String[] args ) {
        System.out.println("hello");
        Foo1 f = new FooMain();
        f.abc();
        
    }

    @Override
    public void abc() {
        System.out.println("class FooMain");
    }

}


interface Foo1 {
    void abc();
}

interface Foo2 {
    void abc();
}

class f1 implements Foo1{
    public void abc(){
        System.out.println("abstract f1");
    }
}