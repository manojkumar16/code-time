package etc.one;

import java.io.DataInputStream;
import java.io.IOException;

// Reverse input char using recursion. assume w --> backspace, and n --> newline
public class ReverseCharRecursion {
    public static void main( String[] args ) {
        char ch = getchar();
        fun( ch, new Count( 0 ) );
        System.out.println( ch );
    }

    static void fun( char ch, Count count ) {
        if ( ch == 'n' ) {
            return;
        }
        ch = getchar();
        fun( ch, count );
        if ( ch == 'n' ) {
            return;
        }
        if ( ch == 'w' ) {
            count.count = count.count + 1;
            return;
        }
        if ( count.count == 0 ) {
            System.out.println( ch );
        } else {
            count.count = count.count - 1;
            return;
        }
    }

    private static char getchar() {
        char ch = 0;
        try {
            DataInputStream in = new DataInputStream( System.in );
            byte b = in.readByte();
            ch = (char) b;
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return ch;
    }
}

class Count {
    int count;

    public Count( int c ) {
        this.count = c;
    }
}