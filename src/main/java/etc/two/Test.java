package etc.two;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    // Test(String str) throws Exception {
    // throw new Exception( "Intention "+str );
    // }

    private static String str = "hello";

    private static final ExecutorService THREADPOOL_EXECUTOR = Executors.newCachedThreadPool();

    public static void main( String[] args ) throws IOException {
        //nonzeroElements();
        final String str = new String("hello");
        System.out.println(str);
    }

    /**
     * Write an algorithm that brings all nonzero elements to the left of the array, and returns the number of nonzero
     * elements. The algorithm should operate in place, i.e. shouldn't create a new array. The order of nonzero elements
     * does not matter
     */
    private static void nonzeroElements() {
        int[] a = { 1, 0, 2, 0, 0, 3, 4 }; // 1,0,0,0,2,3,0,0
        int s_z = -1;

        for ( int i = 0; i < a.length; i++ ) {
            if ( a[i] == 0 && s_z == -1 ) {
                s_z = i;
            } else if ( a[i] != 0 && s_z != -1 ) {
                swap( a, i, s_z );
                s_z++;
            }
        }
        System.out.println( Arrays.toString( a ) );
    }

    private static void swap( int[] a, int i, int j ) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void bitSumCombination() {
        int i = 17;
        int count = 1;
        while ( count <= i ) {
            System.out.println( i & count );
            count = count << 1;
        }        
    }

    private static int power( int a, int b ) {
        if ( a == 0 || a == 1 || b == 1 )
            return a;
        return a * power( a, b - 1 );
/*        if ( ( b & 0x1 ) == 0 ) {
            int x = power( a, b >> 1 );
            return x * x;
        } else
            return a * power( a, b - 1 );*/
    }

    private static void change( int[] rc ) {
        rc[0] = 2;
        rc[1] = 3;
    }


    public static boolean hasAnagramSubstring( String src, String target ) {
        if ( target.length() > src.length() )
            return false;

        int srcLen = src.length(), targetLen = target.length();
        int targetCount[] = new int[128], count[] = new int[128], i, j;

        // initialize
        for ( i = 0; i < target.length(); ++i ) {
            ++targetCount[target.charAt( i )];
            ++count[src.charAt( i )];
        }
        // loop
        i = 0;
        while ( true ) {
            // check if substring is an anagram
            for ( j = 0; j < targetLen; ++j ) {
                if ( count[target.charAt( j )] != targetCount[target.charAt( j )] )
                    break;
            }
            if ( j == targetLen )
                return true;
            // slide window
            if ( i + 1 + targetLen > srcLen )
                break;
            --count[src.charAt( i )];
            ++count[src.charAt( i + targetLen )];
            ++i;
        }

        return false;
    }

    private static void TreeMapExample() {
        Comparator<? super Integer> comparator = new Comparator<Integer>() {

            @Override
            public int compare( Integer o1, Integer o2 ) {
                return o1 < o2 ? -1 : o1 == o2 ? 0 : 1;
            }
        };
        Map<Integer, Integer> tm = new TreeMap<Integer, Integer>( comparator );
        tm.put( 4, 1234 );
        tm.put( 3, 2345 );
        tm.put( 1, 3456 );
        tm.put( 2, 5667 );
        Set<Entry<Integer, Integer>> entries = tm.entrySet();// tm.keySet();
        for ( Entry<Integer, Integer> e : entries ) {
            System.out.println( e.getKey() + ", " + e.getValue() );
        }
        System.out.println( tm );
    }

    private static void xor( int x ) {
        int[] a = new int[x];
        for ( int i = 0; i < a.length; i++ ) {
            a[i] = 1;
        }
        int k = 0;
        for ( int i = 0; i < a.length; i++ ) {

        }
    }

    // Code for computing a^b and optimize it.
    private static int apowerb( int x, int y ) {
        if ( y == 1 ) {
            return x;
        }
        if ( y % 2 == 0 ) {
            return apowerb( x, y / 2 ) * apowerb( x, y / 2 );
        } else {
            return apowerb( x, ( y - 1 ) / 2 ) * apowerb( x, ( y - 1 ) / 2 ) * x;
        }
    }

    private static void swap( char a, char b ) {
        System.out.println( a + ", " + b );
        a = (char) ( a ^ b );
        b = (char) ( b ^ a );
        a = (char) ( a ^ b );

        System.out.println( a + ", " + b );
    }

    public static void compute_active_users( Integer n, Integer b ) {
        System.out.println( (int) Math.floor( n * ( 100 - b ) / 100 ) );
    }

    public static void main6( String[] args ) {
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        // UTC, GMT, America/Los_Angeles
        sdf.setTimeZone( TimeZone.getTimeZone( "US/Eastern" ) );
        String utcTime = sdf.format( new Date() );
        System.out.println( utcTime );
    }

    public static void main5( String[] args ) throws NoSuchFieldException, SecurityException,
        IllegalArgumentException, IllegalAccessException {
        TestMethod tm = new TestMethod();
        Class cls = tm.getClass();
        Field sField = cls.getField( "AS4_USER_EXIT_INVOCATION_FAILED_ERROR_EXPLANATION" );
        System.out.println( "Public field found: " + sField.toString() );

        System.out.println( tm.getValue( "AS4_USER_EXIT_INVOCATION_FAILED_ERROR_EXPLANATION" ) );

        System.out.println( tm.getValue( TestMethod.AS4_USER_EXIT_INVOCATION_FAILED_ERROR_EXPLANATION ) );
    }

    public static void main4( String args[] ) throws InterruptedException {
        System.out.println( Integer.MAX_VALUE / 1000 );
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println( "starting uninterruptible task 1" );
                    Thread.sleep( 10000 );
                    System.out.println( "stopping uninterruptible task 1" );
                } catch ( InterruptedException e ) {
                    System.out.println( "mkpp-interrupted...\n" );
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread( runnable );
        t1.start();
        Thread.sleep( 1000 );
        System.out.println( "interrupting it." );
        Thread.sleep( 2000 );
        t1.interrupt();
        System.out.println( "interrupt signal sent." );

    }

    public static void main3( String[] args ) throws IOException {
        BufferedReader br = new BufferedReader( new FileReader( "saml.xml" ) );
        StringBuilder xmlstr = new StringBuilder();
        String line = br.readLine();

        while ( line != null ) {
            xmlstr.append( line );
            line = br.readLine();
        }
        // System.out.println( StringEscapeUtils.escapeXml( xmlstr.toString() ) );
    }

    int p = 20;

    public static void main2( String[] args ) {
        /*
         * Map<String, String> hm = new HashMap<String, String>(); hm.put( "a", "aaaa" ); hm.put( "b", "bbbb" ); hm.put(
         * "c", "cccc" ); System.out.println(hm);
         */
        // call1();

        List<String> credentialIds = new ArrayList<String>();
        credentialIds.add( "mkpp" );

        if ( credentialIds.size() > 0 ) {
            System.out.println( "mkpp: " + credentialIds.get( 0 ) );
        }

    }

    private static void call1() {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();
        for ( StackTraceElement s : st ) {
            System.out.println( s.getMethodName() );
        }
        System.out.println();
        System.out.println( Thread.currentThread().getStackTrace()[2].getMethodName() );
    }

    public static void main1( String args[] ) {
        int level = 4;
        System.out.println( level & 1 );

        // System.out.println(Thread.currentThread().getContextClassLoader());
        // Class.forName( "sadf", true, ClassLoader.getSystemClassLoader() )
        /*
         * Test test = new Test(); String iAmOfAnArgumentativeNature = "I am born new";
         * test.m1(iAmOfAnArgumentativeNature); System.out.print(iAmOfAnArgumentativeNature);
         * 
         * List<String> ls1 = new ArrayList<String>(); List<String> ls2 = new ArrayList<String>(); ls1.add( "a" );
         * ls1.add( "b" ); System.out.println(ls2); ls2.addAll( ls1 ); System.out.println(ls2); // bitwise();
         * 
         * String str1 = "helloworld"; String str2 = str1.substring( 2, 4 ); System.out.println(str2);
         * 
         * StringBuilder sb1 = new StringBuilder( "helloworld" ); String str3 = sb1.substring( 2, 4 );
         * System.out.println(str3);
         * 
         * System.out.println( "====================================" );
         * 
         * final Test t = new Test(); Test t11 = new Test(); System.out.println( t.p + "  " +t.t2.n); t.p = 30; t.t2 =
         * new Test2(25); System.out.println( t.p + "  " +t.t2.n);
         */

    }

    public void m1( String arg1 ) {
        arg1 = "Am I going to disappear?";
    }
}
