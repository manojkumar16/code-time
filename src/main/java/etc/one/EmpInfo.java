package etc.one;

public class EmpInfo {
    String str;
    public EmpInfo( String str ) {
        this.str = str;
    }
    
    public void display() {
        System.out.println("Display: "+this.str);
    }

}
