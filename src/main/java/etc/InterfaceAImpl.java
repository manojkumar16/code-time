package etc;

import java.util.ArrayList;

public class InterfaceAImpl extends classB {
    public static void main( String[] args ) {
        ArrayList<Object> obj = new ArrayList<Object>();
        InterfaceAImpl ob = new InterfaceAImpl();
        obj.add( ob );
        
        if(obj.get( 0 ) instanceof InterfaceA ) {
            System.out.println("Yes...It    ---- is");
        }
    }
    
}
