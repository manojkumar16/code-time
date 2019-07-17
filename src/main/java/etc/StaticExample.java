package etc;

class ClassA {
    int a = 5;

    int b = 15;

    public void display() {
        System.out.println( "non Static Class..." );
    }

    class innerClassA {
        int c = 2;

        int d = 4;

        public void display() {
            System.out.println( "Inner class A" );
        }
    }
}

public class StaticExample {

    static {
        System.out.println( "In Static block..." );
        int k=90;
    }

    public static void main( String[] args ) {
        System.out.println("Inside main");
        ClassA objA = new ClassA();

        objA.new innerClassA().display();
        // objA.new innerClassA()
    }
}

class ClassB {
    static int a = 10;

    int b = 20;

    public static void display() {
        System.out.println( "Static class..." );
    }
}