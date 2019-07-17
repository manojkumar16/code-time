package etc;

public class ClassA extends superClass {

    public static void main( String[] args ) {
        ClassA obj = new ClassA();
        
        obj.display();
    }
    
    public void display() {
        super.display();
        System.out.println("In class A");
    }

}
