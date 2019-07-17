package algorithmsAndDS;

import java.util.Stack;

public class Test3 {

    public static void main( String[] args ) {
        //Test3.swapSort( "11000" );
        Test3.infixToPostfix( "*+56-78" );
        new Test3().method();
    }

    private void method() {

    }

    static String infixToPostfix( String s ) {
        char[] postfix=new char[s.length()];
        char ch;
        Stack<Character> stk = new Stack<Character>();

        int j=0;

        for(int i=0;i<s.length();i++)
        {
            ch=s.charAt(i);
            stk.push( '#');
            if(!isOperator(ch))
            {
                postfix[j++]=ch;
            }
            else if(isOperator(ch))
            {
                stk.push( ch );
            }
            else if(ch=='#')
            {
                char c  = stk.pop();
                while(c!='#')
                        {                        
                            postfix[j++]=c;
                            c= stk.pop();
                        }
            }
        }
        System.out.println(postfix);
        return null;
    }
    
/*    static String infixToPostfix( String s ) {
        int j = 0;
        Stack<Character> stk = new Stack<Character>();
        char[] postfix = new char[s.length()];
        for ( int i = 0; i < s.length(); i++ ) {
            if ( isOperator( s.charAt( i ) ) ) {
                stk.push( s.charAt( i ) );
            } else {
                postfix[j++] = s.charAt( i );
            }
            while ( !stk.empty() && stk.pop() == '#' ) {
                //stk.pop();
                postfix[j++] = stk.pop();
                if(stk.size()>0) {
                    stk.pop();
                }
            }

            stk.push( '#' );
        }
        String s1 = String.copyValueOf( postfix );
        System.out.println( s1 );
        return s1;
    }*/

    private static boolean isOperator( char c ) {
        if ( c == '+' || c == '-' || c == '*' || c == '/' ) {
            return true;
        }
        return false;
    }

    static int swapSort( String s ) {
        int[] intArray = new int[s.length()];
        for ( int i = 0; i < s.length(); i++ ) {
            if ( s.charAt( i ) == '0' ) {
                intArray[i] = 0;
            } else {
                intArray[i] = 1;
            }
        }

        int countOne = 0;
        int swapCount = 0;
        for ( int i = 0; i < intArray.length; i++ ) {
            if ( intArray[i] == 1 ) {
                countOne++;
            } else {
                swapCount += countOne;
            }
        }
        System.out.println( swapCount );
        return swapCount;

    }

    private static void staticmethod() {

    }

}
