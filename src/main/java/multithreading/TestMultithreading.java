package multithreading;

public class TestMultithreading {

    public static void main( String[] args ) {
        new TestMultithreading().start();
    }

    private void start() {
        Bar o = new Bar();
        int z = o.f1;
        synchronized ( o ) {
            int x = o.f2;
            int y = o.f3;
            o.f3 = x + y;
            System.out.println(z);
            System.out.println(o.f1);
            synchronized ( o ) {
                System.out.println("Hello world.");
                synchronized ( o ) {
                    System.out.println("Hello world again");
                }
            }
        }
        
        System.out.println(o.f1);
        System.out.println(o.f2);
        System.out.println(o.f3);
    }

}
