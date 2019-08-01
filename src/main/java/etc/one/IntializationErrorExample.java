package etc.one;
public class IntializationErrorExample {
    static int v;

    static {
        v = D.foo();
    }
    
   public static void main(String args[]) {
       System.out.println("Static");
   }
}
