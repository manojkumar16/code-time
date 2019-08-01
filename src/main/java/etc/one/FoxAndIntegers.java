package etc.one;

public class FoxAndIntegers {

    public static void main( String[] args ) {
        
        int [] a = get(-27,14,13,22);
        
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
    }

    private static int[] get( int i, int j, int k, int l ) {
        
        boolean bflag = false;
        
        int[] arr = new int[3];
        arr[0] = (i+k)/2;
        arr[1] = (k-i)/2;
        arr[2] = l-arr[1];
        
        System.out.println(arr);
        if( i==arr[0]-arr[1] && j==arr[1]-arr[2] && k==arr[0]+arr[1] && l==arr[1]+arr[2]) {
            bflag = true;
        } else {
            System.out.println("not found");
        }
        
        if(bflag)
            return arr;
        else
            return new int[0];
    }

}
