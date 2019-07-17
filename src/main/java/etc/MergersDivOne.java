package etc;
import java.util.Arrays;


public class MergersDivOne {

    public static void main( String[] args ) {
        
        int [] a = new int[]{10, -10, 100, -100, 1000, -1000};
        double res = findMaximum(a);
        
        System.out.println(res);
    }

    public static double findMaximum( int[] a ) {
        
        Arrays.sort( a );
        double avg = a[0];
        for(int i=0; i<a.length-1; i++) {
            double sum = avg + a[i+1];
            avg  = sum/2;
        }
            
        return avg;
    }

}
