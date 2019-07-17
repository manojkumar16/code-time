package etc;

public class BinaryPolynomialDivTwo {

    public int countRoots( int[] a ) {
        int count = 0;
        
        //First x=0
        int sum = 0;
        int x=0;
        for(int i=0; i<a.length; i++) {
            if(x==0 && i==0) {
                sum = sum + a[i]*1;
            } else {
                sum = sum + a[i]*0;
            }
        }
        
        int rem1 = sum%2;
        System.out.println("rem1: "+rem1);
        
        x=1;
        sum = 0;
        for(int i=0; i<a.length; i++) {
            sum = sum + a[i]*1;
        }
        
        int rem2 = sum%2;
        System.out.println("rem2:"+rem2);
        if(rem1==0) {
            count++;
        }
        if(rem2==0) {
            count++;
        }
        return count;
    }
}
