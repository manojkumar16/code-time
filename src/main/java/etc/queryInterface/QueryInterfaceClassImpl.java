package etc.queryInterface;

public class QueryInterfaceClassImpl implements QueryInterface<QueryInterfaceClassImpl> {

    private int num;

    @Override
    public QueryInterfaceClassImpl getQueryInterface() {
        return this;
    }

    @Override
    public void display() {
        System.out.println( "Inside QueryInterfaceClassImpl.display(): " + this.num );
    }

    public void methodA() {
        System.out.println( "Inside QueryInterfaceClassImpl.methodA():" + this.num );
    }

    @Override
    public void setNumber( int number ) {
        this.num = number;
    }

}
