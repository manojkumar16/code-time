package etc;

public class ThreadSafeString {

    public static void main( String[] args ) {
        StringBuilder sbb = new StringBuilder( "hello" );
        System.out.println(sbb);
        myMethod(sbb);
        System.out.println(sbb);
    }

    public static  void myMethod(StringBuilder sb){
        sb.append( "world" );
        
    }
}
