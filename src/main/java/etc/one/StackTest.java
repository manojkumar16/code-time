package etc.one;
public class StackTest {
    public static void main( String[] args ) {
        StackLocal s = new StackLocal();
        s.push( 1 );
        s.push( 2 );
        s.push( 3 );
        s.push( 4 );
        
        System.out.println(s.pop());
        System.out.println(s.pop());
        
        s.push( 5 );
        
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        
    }
}

class StackLocal {
    int[] a = new int[10];
    int size = 0;

    public void push( int item ) {
        a[size++] = item;
    }

    public int pop() {
        int item = a[size-1];
        a[size] = 0;
        size--;
        return item;
    }
}