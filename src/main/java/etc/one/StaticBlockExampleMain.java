package etc.one;
class StaticBlockExample {
    public int i=10;
    static {
        int i=20;
        System.out.println(i);
    }
}

public class StaticBlockExampleMain {
    public static void main( String[] args ) {
        StaticBlockExample obj = new StaticBlockExample();
        System.out.println(obj.i);
    }
}
