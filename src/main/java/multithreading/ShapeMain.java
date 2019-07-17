package multithreading;
import java.util.List;


public class ShapeMain {

    /**
     * @param args
     */
    public static void main( String[] args ) {
        ShapeMain ob = new ShapeMain();
    //    ob.addRectangle()
    }

    public void addRectangle(List<? extends Shape> shapes) {
//        shapes.add(0, new Rectangle()); // compile-time error!
       // shapes.add( new Rectangle() );
        Rectangle r = new Rectangle();
        //shapes.add( r );
        }
}
