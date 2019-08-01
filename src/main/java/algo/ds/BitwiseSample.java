package algo.ds;

public class BitwiseSample {

    public static void main( String[] args ) {
        bit();
        int x = 64;
        int r = 8;
        
        int k = 1<<r;
        System.out.println(k);
        
        //bitwise();
    }
    private static void bit() {
        int a = -105;
        int c = a >>> 1;
        int b = a >> 1;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);        
    }
    private static void bitwise() {
        int a = 60; /* 60 = 0011 1100 */
        int b = 13; /* 13 = 0000 1101 */
        int c = 0;

        c = a << 2; /* 240 = 1111 0000 [Arithmatice shifts]*/
        System.out.println( "a << 2 = " + c );

        c = a >> 2; /* 15 = 1111 [Arithmatice shifts]*/
        System.out.println( "a >> 2  = " + c );

        c = a >>> 2; /* 215 = 0000 1111 [Logical shifts]*/
        System.out.println( "a >>> 2 = " + c );

        c = a & b; /* 12 = 0000 1100 */
        System.out.println( "a & b = " + c );

        c = a | b; /* 61 = 0011 1101 */
        System.out.println( "a | b = " + c );

        c = a ^ b; /* 49 = 0011 0001 */
        System.out.println( "a ^ b = " + c );

        c = ~a; /*-61 = 1100 0011 */
        System.out.println( "~a = " + c );

    }
}
