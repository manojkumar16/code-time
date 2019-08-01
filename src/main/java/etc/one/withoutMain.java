package etc.one;

public class withoutMain {

/*    static {
        System.out.println("Hello world...");
    }*/
    
    public static void main( String[] args ) {
        
        System.out.println(args.length);
        for(int i=0; i<args.length; i++) {
            System.out.println(args[i]);
        }
        //stringExample();
    }

    private static void stringExample() {
        String str = "Hello";
        System.out.println(str);
        
        str="world";
        System.out.println(str);
        
        str = str+"manoj";
        System.out.println(str);
        String temp = str.replaceFirst( "orld", "kkkk" );
        System.out.println(temp);
        
    }
}
