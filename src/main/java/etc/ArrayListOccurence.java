package etc;
import java.util.Arrays;
import java.util.List;

/**
 * A method takes two array list as its arguments Both ArrayList have list of objects similar to the example here below
 * AL1 = {A,A,B,L,C,F,D,E,F,D,Z,R} AL2 = {C,E,X,Z,M,X,P,L,M,N,S,T,P,B,A} The aim is to create a third arraylist AL3
 * which would contain only elements that are occuring exactly twice, even after combining both AL1 and AL2. So, the
 * resultant list should be as seen here below AL3 = {B,C,F,D,Z,E,X,P,M}
 * 
 * @author mkprasad
 * 
 */
public class ArrayListOccurence {

    public static void main( String[] args ) {
        String str1 = "AABLCFDEFDZR";
        String str2 = "CEXZMXPLMNSTPBA";
        int[] ch = new int[256];

        for ( int i = 0; i < str1.length(); i++ ) {
            ch[str1.charAt( i )] = ch[str1.charAt( i )] + 1;
        }
        
        for ( int i = 0; i < str2.length(); i++ ) {
            ch[str2.charAt( i )] = ch[str2.charAt( i )] + 1;
        }
        for ( int i = 0; i < 256; i++ ) {
            if ( ch[i] == 2 ) {
                System.out.print( (char)i+" " );
            }
        }
    }

}
