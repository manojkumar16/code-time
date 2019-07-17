
public class InterfaceExample extends ABCDEF {

    public static void main( String[] args ) {
        Interface1 i = new Interface1() {
            
            @Override
            public void method1( String str ) {
                System.out.println(str);
            }
        };
        
        i.method1( "hi" );
        
        ABCDEF ob = new InterfaceExample();
      //  ob.message( "message" );
    }

    //Wrong!!!!
    @Override
    public void message(String str){
        System.out.println("Override: "+str);
    }
}

class ABCDEF {
    public void message(long str){
        System.out.println(str);
    }
}
interface Interface1 {
    void method1(String str);
}
