package etc.one;

public class MainClass {
    AggregatedState as ; 
    
    public static void main( String[] args ) {
        MainClass obj = new MainClass();
        
        obj.setStatus(AggregatedState.fromValue( "FAILED" ));
        
        System.out.println(obj.getStatus().value());
    }

    private AggregatedState getStatus() {
        return as;
    }

    private void setStatus( AggregatedState v ) {
        as = v;
    }

}
