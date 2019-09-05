package etc.two;

public class Employee {

    long timestamp;
    String fname;
    String lname;
    
    Employee(String f, String l, long ts) {
        this.timestamp = ts;
        this.fname = f;
        this.lname = l;
    }
}
