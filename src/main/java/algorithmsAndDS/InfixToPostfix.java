package algorithmsAndDS;

//http://geeksquiz.com/stack-set-2-infix-to-postfix/

/**
Algorithm
1. Scan the infix expression from left to right.
2. If the scanned character is an operand, output it.
3. Else,
…..3.1 If the precedence of the scanned operator is greater than the precedence of the operator in the stack(or the stack is empty), push it.
…..3.2 Else, Pop the operator from the stack until the precedence of the scanned operator is less-equal to the precedence of the operator residing on the top of the stack. Push the scanned operator to the stack.
4. If the scanned character is an ‘(‘, push it to the stack.
5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
6. Repeat steps 2-6 until infix expression is scanned.
7. Pop and output from the stack until it is not empty.
 */
public class InfixToPostfix {

    public static void main( String[] args ) {
        new InfixToPostfix().process();
    }

    private void process() {
        char exp[] = "a+b*(c^d-e)^(f+g*h)-i".toCharArray();
        char[] exp_res = infixToPostfix( exp );
        System.out.println( exp_res );
    }

    // converts infix to postfix expression
    private char[] infixToPostfix( char[] exp ) {
        char[] exp_res = new char[exp.length];
        Stack s = new Stack( 1000 );
        int k = -1;
        for ( int i = 0; i < exp.length; i++ ) {
            // If the scanned character is an operand, output it.
            if ( isOperand( exp[i] ) ) {
                exp_res[++k] = exp[i];
            } else if ( exp[i] == '(' ) {
                // If the scanned character is an ‘(‘, push it to the stack.
                push( s, exp[i] );
            } else if ( exp[i] == ')' ) {
                // If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
                while ( !isEmpty( s ) && peek( s ) != '(' ) {
                    exp_res[++k] = pop( s );
                }

                pop( s ); // pop '('
            
            } else {
                // an operator is encountered
                // If the precedence of the scanned operator is greater than the precedence of the operator in the
                // stack(or the stack is empty), push it.
                // Else, Pop the operator from the stack until the precedence of the scanned operator is less-equal
                // to the precedence of the operator residing on the top of the stack. Push the scanned operator to
                // the stack.
                while ( !isEmpty( s ) && (Prec( exp[i] ) <= Prec( peek( s )) ) )
                    exp_res[++k] = pop( s );

                push( s, exp[i] );
            }
        }

        // pop all the operators from the stack
        while ( !isEmpty( s ) )
            exp_res[++k] = pop( s );
        
        exp_res[++k]='\0';
        return exp_res;
    }

    // A utility function to return precedence of a given operator
    // Higher returned value means higher precedence
    public int Prec( char ch ) {
        switch ( ch ) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
 
    // A utility function to check if the given character is operand
    public boolean isOperand( char ch ) {
        return ( ch >= 'a' && ch <= 'z' ) || ( ch >= 'A' && ch <= 'Z' );
    }

    private class Stack {
        int top = -1;

        char[] array;

        int capacity = -1;

        public Stack( int capacity ) {
            this.capacity = capacity;
            array = new char[capacity];
        }
    }

    public boolean isEmpty(Stack stack){
        if(stack.top == -1){
            return true;
        } else {
            return false;
        }
    }
    
    public char peek(Stack stack){
        return stack.array[stack.top];
    }
    
    public char pop(Stack stack){
        if(!isEmpty( stack )){
            char c = stack.array[stack.top];
            stack.top--;
            return c;
        }else {
            return '$';
        }
    }
    public void push(Stack stack,char c){
        stack.array[++stack.top] = c;
    }
    
}
