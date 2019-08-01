package etc.one;
public class AImplementsBC implements Binterface, CInterface, DInterface {

    public static void main( String[] args ) {
        Binterface b = new AImplementsBC();
        CInterface c = new AImplementsBC();

    //    b.m();
        c.m();
    }

    @Override
    public void m() {
        System.out.println( "hello" );
        Class<?>[] interfaces = this.getClass().getInterfaces();
        for ( Class c : interfaces ) {
            System.out.println( c.getName() );
        }
    }

    @Override
    public void m2() {
        
    }

}
