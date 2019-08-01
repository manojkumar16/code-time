package etc.one;

public class ObjectSizeFetcher {

    public static void main( String[] args ) {
        System.out.println(Runtime.getRuntime().freeMemory());
        
        System.out.println(Runtime.getRuntime().totalMemory());
        
        ObjectSizeFetcher ob = new ObjectSizeFetcher();
        
    }
    

}
