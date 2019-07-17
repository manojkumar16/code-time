package etc;

import java.util.Iterator;

public class IteratorMain {

    public static void main( String[] args ) {
        SimpleIterator<String> al = new SimpleIteratorList<String>();
        al.add("C");
        al.add("A");
        al.add("E");

        System.out.print("Original contents of al: ");
        Iterator itr = al.iterator();
        while(itr.hasNext()) {
           String str = (String)itr.next();
           itr.get
           System.out.print(str + " ");
        }
        System.out.println();
    }

}
