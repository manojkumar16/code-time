package etc.one;
public class StringOperation {

    public static void main( String[] args ) {
        reverseStringRecursion();
    }

    private static void reverseStringRecursion() {
        String str = "hello";
        char[] ch = str.toCharArray();
        reverse(ch, 0, str.length()-1);
    }

    private static void reverse( char[] ch, int ind, int len ) {
        if(ind > len) {
            System.out.println(ch);
            return;
        }
        swap(ch, ind, len);
        reverse(ch, ind+1, len-1);
        /*reverse(str, newStr, ind+1, len);
        System.out.print(str.charAt( ind ));
        */
    }

    private static void swap( char[] ch, int first, int last ) {
        char c = ch[last];
        ch[last] = ch[first];
        ch[first] = c;
    }

/*    private static void reverse( String str, String newStr, int len, int ind ) {
        if ( ind >= len ) {
            System.out.println( newStr );
            return;
        }
        reverse(str.charAt( ind ));
    }*/

}
