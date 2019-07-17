package etc;

public class InnerClassExample {

    public static void main( String[] args ) {
        InnerClassExample ob = new InnerClassExample();
        ob.action();
        
        staticAction();
    }

    private static void staticAction() {
        Inner in = new Inner( "staticAction" );
        in.display();
    }

    private void action() {
        Inner in = new Inner( "action" );
        in.display();
    }

}

class Inner {

    String msg;

    public Inner( String msg ) {
        this.msg = msg;
    }

    public void display() {
        System.out.println( "Inner - " + msg );
    }
}