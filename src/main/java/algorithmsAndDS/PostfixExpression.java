package algorithmsAndDS;

/**
 * http://geeksquiz.com/stack-set-4-evaluation-postfix-expression/
 * 
Following is algorithm for evaluation postfix expressions.
1) Create a stack to store operands (or values).
2) Scan the given expression and do following for every scanned element.
…..a) If the element is a number, push it into the stack
…..b) If the element is a operator, pop operands for the operator from stack. Evaluate the operator and push the result back to the stack
3) When the expression is ended, the number in the stack is the final answer
 */
public class PostfixExpression {

    public static void main( String[] args ) {
        new PostfixExpression().process();
    }

    private void process() {
        char[] exp = "231*+9-".toCharArray();
        int res = evaluatePostfix(exp);
        System.out.println(res);
    }

    private int evaluatePostfix( char[] exp ) {
        Stack s = new Stack( 100 );
        for ( int i = 0; i < exp.length; i++ ) {
            if ( isNumber( exp[i] ) ) {
                push( s, exp[i]+"" );
            } else {
                // It should be operator
                int v = -1;
                int val1 = Integer.parseInt( pop( s ) + "" );
                int val2 = Integer.parseInt( pop( s ) + "" );
                switch ( exp[i] ) {
                    case '+':
                        v = val2 + val1;
                        push( s, v + "" );
                        break;
                    case '-':
                        v = val2 - val1;
                        push( s, v + "" );
                        break;
                    case '*':
                        v = val2 * val1;
                        push( s, v + "" );
                        break;
                    case '/':
                        v = val2 / val1;
                        push( s, v + "" );
                        break;
                }
            }
        }

        return Integer.parseInt( pop( s ) );
    }

    private boolean isNumber( char c ) {
        try {
            Integer.parseInt( c + "" );
        } catch ( NumberFormatException e ) {
            return false;
        }
        return true;
    }

    private class Stack {
        int top = -1;

        String[] array;

        int capacity = -1;

        public Stack( int capacity ) {
            this.capacity = capacity;
            array = new String[capacity];
        }
    }

    public boolean isEmpty(Stack stack){
        if(stack.top == -1){
            return true;
        } else {
            return false;
        }
    }
    
    public String peek(Stack stack){
        return stack.array[stack.top];
    }
    
    public String pop(Stack stack){
        if(!isEmpty( stack )){
            String c = stack.array[stack.top];
            stack.top--;
            return c;
        }else {
            return "$";
        }
    }
    public void push(Stack stack,String c){
        stack.array[++stack.top] = c;
    }
}
