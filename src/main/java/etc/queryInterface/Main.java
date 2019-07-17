package etc.queryInterface;

public class Main {

    /**
     * @param args
     */
    public static void main( String[] args ) {

        QueryInterface<?> obj = new QueryInterfaceClassImpl();

        obj.display();
        obj.setNumber( 50 );
        obj.display();

        QueryInterfaceClassImpl newObj = (QueryInterfaceClassImpl) obj.getQueryInterface();
        newObj.methodA();
    }

}
