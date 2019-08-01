package etc.one;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import static java.lang.System.out;

public class FileOperation {

    private long quiesceTimeout;

    private int IN = 100;

    private String STR = "MANOJ";

    static public void main( String args[] ) throws Exception {
        readPattern();
        //ReentrantLock
        //Lock
        //ReadWriteLock
       // timeEfficinency();
     //   trimExample();
       // System.out.println( ( (Double) (Math.random() * 10000 ) ).intValue() ); 
        
        //   calendar();
      //  int dist = hammingDistance(4,9);
      //  println(dist);
        
      //  callOtherGuys();
        
       // operatorPrecedence();
      // time();
    }

    private static void readPattern() {
        int count = 0;
        File f = new File("/home/mkprasad/mkprasad/Study-Materials/Algorithm-videos/Patterns/");
        if(f.isDirectory()) {
            String[] ls = f.list();
            for(String file : ls) {
                if(file.endsWith( "mp4" )) {
                    System.out.println(file);
                  String str = file.substring( file.indexOf( '(' ), file.indexOf( ')' ));
                  System.out.println(str);
                    count++;
                }
            }
        }
        System.out.println("Total file count: "+count);
    }

    private static void trimExample() {
        String str1 = "hello        ";
        String str2 = "world ";
        System.out.println("["+str1+"]");
        System.out.println("["+str2+"]");
        
        System.out.println("["+str1.trim()+"]");
        System.out.println("["+str2.trim()+"]");
        
        int num=121;
        System.out.println(121/10);
    }

    private static void timeEfficinency() throws InterruptedException {
        for(int i=0; i<10; i++) {
            long t_s = System.currentTimeMillis();
           
            long t1 = System.currentTimeMillis();
            long t2 = System.currentTimeMillis();
            if ( t1 == t2 ) {
                //Thread.sleep( 5 );
               // System.out.println("Equal time");
            } else {
                System.out.println("Not equal time");
            }
            
            long t_e = System.currentTimeMillis();
            
            if(t_s == t_e) {
                System.out.println("equal....");
            } else {
                System.out.println("not equal...");
            }
        }
    }

    private static void calendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.add( Calendar.HOUR, 0 );
        System.out.println(calendar.getTime());        
    }

    private static int hammingDistance( int x, int y ) {
        int dist = 0, val = x ^ y;

        // Count the number of set bits
        while ( val > 0 ) {
            ++dist;
            val &= val - 1;
        }
        return dist;
    }

    private static void operatorPrecedence() {
        Long l = 60000L;
        
        int x = 5;
        int y = 10;
        x = x + y - ( y = x );
        println(x);        
    }

    private static void time() {
        Long t2 = (long) ( 7*24*3600*1000 );
        println(t2);
        /*  Long t1 = System.currentTimeMillis();
        System.out.println(new Date(t1));
       
        // 7 days
        
        // 1 hour
        //Long t2 = (long) ( 1*3600*1000 );
        System.out.println(t2);
        System.out.println(new Date(t1+t2));*/
        
    }

    private static void println( Object x ) {
        out.println(x);
    }

    private static void print( Object x ) {
        out.print(x);
    }
    
    private static void calendarExample() {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTimeZone().getDisplayName());
        cal.setTimeZone(   TimeZone.getTimeZone("EDT")   );
        System.out.println(cal.getTimeZone().getDisplayName());
        cal.setTimeInMillis( 1366247264084L );
        System.out.println(cal.getTime());
    }

    private static void loadXmlFileIntoDOM( File xmlFile ) {
        // Load the POM XML into the XML parser
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware( true ); // never forget this!
        DocumentBuilder builder = null;
        try {
            builder = domFactory.newDocumentBuilder();
        } catch ( ParserConfigurationException exc ) {
            exc.printStackTrace();
        }
        Document doc;
        try {
            doc = builder.parse( xmlFile );
            System.out.println(doc);
        } catch ( SAXException exc ) {
            exc.printStackTrace();
        } catch ( IOException exc ) {
            exc.printStackTrace();
        }
    }

    
    private static void instanceofExample() {
        System.out.println( new Date( 1363804561149L ) );

        if ( null instanceof FileOperation ) {
            System.out.println( "Instance of" );
        } else {
            System.out.println( "MKPP Not instnace of" );
        }
    }

    private static void collectionExample() {
        List<String> str = new ArrayList<String>();
        str.add( "a" );
        str.add( "b" );
        str.add( "c" );
        str.add( "d" );
        System.out.println(str);
        //displayCollection( str );
    }

    private static void displayCollection( final Collection keyList ) {
        Iterator iter = keyList.iterator();
        while ( iter.hasNext() ) {
            System.out.println( iter.next() );
        }
    }

    private static void passwordExample() {
        String str = "password";
        Object obj = str;
        char[] ch = ( (String) obj ).toCharArray();
        System.out.println( ch );

        Object pw = "Password";
        System.out.println( "String: " + pw );

        pw = "Password".toCharArray();
        System.out.println( pw );
    }

    private static void wordFrequency() {
        String str = "Our word frequency counter allows you to count the frequency usage of each word in your text. "
            + "Paste or type in your text below, and click submit";

        // String[] arr = str.split( " " );

        char[] arr = str.toCharArray();
        Map<Character, Integer> hm = new HashMap<Character, Integer>();

        for ( int i = 0; i < arr.length; i++ ) {
            if ( hm.containsKey( arr[i] ) ) {
                int value = hm.get( arr[i] );
                value = value + 1;
                hm.put( arr[i], value );
            } else {
                hm.put( arr[i], 1 );
            }
        }
        System.out.println( hm );
    }

    private static void max2() {
        int[] a = new int[] { 2, 3, 4, 5, 9, 8, 4, 19, 7 };
        // max2 = 9

        int max = a[0];
        int max2 = a[0];
        for ( int i = 1; i < a.length; i++ ) {
            if ( max < a[i] ) {
                max2 = max;
                max = a[i];
            }
        }
        System.out.println( max );
        System.out.println( max2 );

    }

    private static void setExample() {
        Set<String> hs = new HashSet<String>();

/*        int[] a = new int[] { 2, 3, 4, 5, 9, 8, 4, 6, 3, 6 };

        for ( int i = 0; i < a.length; i++ ) {
            if ( !hs.contains( a[i] ) ) {
                hs.add( a[i] );
            } else {
                System.out.println( "Duplicate number is " + a[i] );
            }
        }*/
        
        hs.add( "cccc" );
        hs.add( "aaaa" );
        hs.add( "bbbb" );
        
        for( String str : hs) {
            System.out.println(str);
        }

    }

    private static void stringTokenizerEx() {
        String str1 = "a,b,c,d";
        String str2 = "a";
        String str3 = ",";
        String str4 = "a,b,";
        String str5 = " ";
        String[] str = str5.split( "," );
        for ( String s : str ) {
            System.out.println( "element - " + s );
        }
    }

    private static void callOtherGuys() throws InterruptedException {
        //calendarExample();
        // instanceofExample();
        // collectionExample();
        // passwordExample();
        // wordFrequency();
        // max2();
         setExample();
        // stringTokenizerEx();
        // arrayAsListExample();
        // loadXmlFileIntoDOM(new File("/home/mkprasad/MEGDevelopment/B2BGateway/meg-base-aggregator-purge/.project"));
        // truncateString();
        // regExample();
        // hmExample();
        // hello(true);
        // fileReadExample();
        // xmlExample();
        // dateExample();
        // byteArrayExample();
        // consoleExample();
        // dataStructuresExamples();
        // fileExample(args);
       // randomNumberExample();
        // new FileOperation().classExample();
        // operatorExample();
        // System.out.println(System.currentTimeMillis());
        // methodParameters("hello", "world", "manoj", "kumar");
        // objectExample();
        // new FileOperation().displayLong();
        // factorial(10);
        // hashMapExample();
        // createFile();
        // fileOperation1();
        // fileOperation2();
        // fileOperation3();
        // fileOperation4();
        // ipaddressExample();
        // writefile();
        // filePatternExample_oro();
        // filePatternExample();
        // filePattern();
        // intExample();
        // file1();
        // dateExample();
        // indexExample();
        // fileDelete();
        // ternaryOperation();
        // localDirectory();
        // readfile(args);
        // createFileWithSize();
        // filePermission();
        // executeCMD();
        // writeFile2("c:\\t.txt", 1024);
        // HashMapExample();
        // classExample();
        // ArrayListExample();
        // latchExample();
        // StringOperation();
        // classExample();
        // parseTime();
        // objectExample();
        // systemPropertiesExample();
        // runtimeExample();
        // reverseList();
        // arrayExample();
        // debugStringExample();
        // evenOddExample();
        // xpathExample();
        // new FileOperation().display();
        // hashMapExample();
    }

    private static void arrayAsListExample() {
        List<String> LIFECYCLE_STATE = new ArrayList<String>();
        LIFECYCLE_STATE.addAll( Arrays.asList( "STARTED", "STOPPED", "QUIESCED", "START_FAILED", "STOP_FAILED",
            "STARTING", "STOPPING", "RETRY_SCHEDULED" ) );

        System.out.println( LIFECYCLE_STATE );

        if ( LIFECYCLE_STATE.contains( "QUIESCED" ) ) {
            System.out.print( "It has it..." );
        } else {
            System.out.print( "It does not have it..." );
        }

    }

    private static void truncateString() {
        String str = "ns7:ProvisioningRequest/Body/ns30:ThreadPoolType/ns16:AccessControl/ThreadGroup/ChildGroup/ns19:isDaemon/";
        System.out.println( str );
        System.out.println( str.length() );
        System.out.println( str.substring( 0, 10 ) );
    }

    private static void regExample() {
        String str1 = "ns7:ProvisioningRequest/Body/ns30:ThreadPoolType/ns16:AccessControl/ThreadGroup/ChildGroup/ns19:isDaemon/";
        String str2 = "ns7:ProvisioningRequest/Body/ns30:ThreadPoolType/ns16:AccessControl/ThreadGroup/ChildGroup/ns19:isDaemon";

        // String pattern = "([^/]+)/?$";
        String pattern = "(?<=.*)([^/]+)(?=/?$)";
        Pattern p = Pattern.compile( pattern );
        Matcher matcher = p.matcher( str2 );

        if ( matcher.find() ) {
            String s = matcher.group();
            System.out.println( s );
            System.out.println( str1.substring( 0, str1.lastIndexOf( s ) - 1 ) );

        }

    }

    private static void hmExample() {
        Map<String, String> hm = new HashMap<String, String>();

        hm.put( "a", "apple" );
        hm.put( "b", "bapple" );
        hm.put( "c", "capple" );
        List<String> ls = new ArrayList<String>( hm.values() );
        System.out.println( ls );
    }

    private static void hello( String str ) {
        // check whether the string is null, empty, or have some values
        if ( str == null ) {
            System.out.println( "The provided string is null." );
        } else if ( str.length() == 0 ) {
            System.out.println( "The provided string is empty" );
        } else {
            System.out.println( "The provided string is having some values." );
        }
    }

    private static void fileReadExample() throws IOException {
        Map<String, String> hm = new HashMap<String, String>();
        String fileName = "C:\\EclipseWorkspaces\\B2BGateway\\MEGSQLClient\\src\\main\\resources\\sql.properties";
        List<String> lines = Files.readAllLines( FileSystems.getDefault().getPath( fileName ),
            StandardCharsets.UTF_8 );
        for ( String str : lines ) {
            String[] res = str.split( "=" );
            if ( res.length == 2 ) {
                hm.put( res[0], res[1] );
            } else {
                hm.put( res[0], null );
            }
        }

        displayHashMap( hm );

    }

    private static void displayHashMap( Map<String, String> hm ) {
        Iterator<Entry<String, String>> iter = hm.entrySet().iterator();
        while ( iter.hasNext() ) {
            Entry<String, String> entry = iter.next();
            System.out.println( entry.getKey() + "=" + entry.getValue() );
        }
    }

    private static void xmlExample() throws SAXException, IOException, ParserConfigurationException {
        String xml_ns = "http://www.ibm.com/b2b/apiint/messagedefinitions/messages/xml/provisioning";
        String tagName = "ProvisioningProperties";

        String contents = loadFile( "C:\\EclipseWorkspaces\\B2BGateway\\fewExamples\\src\\ProvisioningRequest.xml" );
        Document doc = buildDocument( contents );
        Element element = doc.getDocumentElement();

        String tag = element.getTagName();
        String prefix = element.getPrefix();
        String ns = element.getNamespaceURI();

        if ( tag.equals( prefix + ":" + tagName ) ) {
            System.out.println( "True" );
        } else {
            System.out.println( "False" );
        }
        System.out.println( element.getNamespaceURI() );
        System.out.println( element.getPrefix() );

    }

    public static Document buildDocument( String xml ) throws SAXException, IOException,
        ParserConfigurationException {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setNamespaceAware( true );
        return f.newDocumentBuilder().parse( new InputSource( new StringReader( xml ) ) );

    }

    private static String loadFile( String fileName ) throws SAXException, IOException,
        ParserConfigurationException {
        File file = new File( fileName );
        InputStream inputStream = new FileInputStream( file );
        return createRequestAsString( inputStream );
    }

    private static String createRequestAsString( InputStream inputStream ) throws SAXException, IOException,
        ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware( true );
        Document doc = documentBuilderFactory.newDocumentBuilder().parse( inputStream );
        String docStr = convertDomToString( doc );
        // System.out.println( "doc Str: " + docStr );
        return docStr;
    }

    private static String convertDomToString( Document dom ) {
        StringWriter stw = new StringWriter();
        Transformer serializer = null;
        try {
            serializer = TransformerFactory.newInstance().newTransformer();
        } catch ( TransformerConfigurationException e ) {
            e.printStackTrace();
        } catch ( TransformerFactoryConfigurationError e ) {
            e.printStackTrace();
        }
        try {
            serializer.transform( new DOMSource( dom ), new StreamResult( stw ) );
        } catch ( TransformerException e ) {
            e.printStackTrace();
        }
        return stw.toString();

    }

    private static void byteArrayExample() {
        byte[] b1 = new byte[] { 97, 98, 99 };

        String s2 = new String( b1 );
        System.out.println( s2 );
    }

    private static void consoleExample() {
        System.out.println( "Enter User name: " );

        try {
            BufferedReader bufferRead = new BufferedReader( new InputStreamReader( System.in ) );
            String s = bufferRead.readLine();

            System.out.println( s );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    private static void fileExample( String[] args ) {
        System.out.println( args[0] );
        System.out.println( args[1] );
    }

    private static void randomNumberExample() {
        /*
         * Random rn = new Random(); System.out.println(rn.nextBoolean()); System.out.println( ( (Double) (
         * Math.random() * 10000 ) ).intValue() );
         */

        System.out.println( new Date( 1362544916113L ) );
        System.out.println( new Date( 1362544931130L ) );

        System.out.println( new Date( 1362544931140L ) );

    }

    private void classExample() {
        FileOperation obj1 = new FileOperation();
        if ( obj1.getClass() == this.getClass() ) {
            System.out.println( "Same class..." );
        }
    }

    private static void dataStructuresExamples() {
        /*
         * FileOperation obj = new FileOperation();
         * 
         * List<String> rinki = new ArrayList<String>(); rinki.add( "dsaf" ); rinki.add( "manoj" ); rinki.add( "kumar"
         * ); System.out.println( rinki ); System.out.println(obj);
         * 
         * Vector<String> list = new Vector<String>();
         */
        /*
         * Map<String, Integer> rinki2 = new HashMap<String, Integer>(); rinki2.put( "Rinki", 1212 ); rinki2.put(
         * "manoj", 4444 ); rinki2.put( "Rinki", 2222 ); rinki2.put("rinki", 22433); System.out.println(rinki2);
         */

        Set<String> rinki3 = new HashSet<String>();
        rinki3.add( "manoj" );
        rinki3.add( "kumar" );
        String obj1 = new String( "manoj" );
        String obj2 = new String( "manoj" );
        rinki3.add( obj1 );
        rinki3.add( obj2 );
        System.out.println( rinki3 );
        StringBuffer str = new StringBuffer();
    }

    private static void operatorExample() {
        ArrayList<String> list = new ArrayList<String>();
        list.add( "PARTIAL" );
        list.add( "PARTIAL" );
        list.add( "PARTIAL" );
        list.add( "PARTIAL" );
        list.add( "PARTIAL" );
        int startCount = 0;
        int failedCount = 0;
        for ( int i = 0; i < list.size(); i++ ) {
            if ( allowedStartedState( list.get( i ) ) ) {
                startCount++;
            } else if ( allowedFailedState( list.get( i ) ) ) {
                failedCount++;
            }
        }
        if ( startCount == list.size() ) {
            System.out.println( "STARTED" );
        } else if ( failedCount == list.size() ) {
            System.out.println( "FAILED" );
        } else {
            System.out.println( "PARTIAL" );
        }

    }

    private static boolean allowedFailedState( String state ) {
        if ( state.equals( "FAILED" ) ) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean allowedStartedState( String state ) {
        if ( state.equals( "STARTED" ) ) {
            return true;
        } else {
            return false;
        }

    }

    private static void methodParameters( String... str ) {
        for ( int i = 0; i < str.length; i++ ) {
            System.out.println( str[i] );
        }
    }

    private static void factorial( int num ) {
        int res = 1;
        while ( num >= 1 ) {
            res = res * num;
            num = num - 1;
        }

        System.out.println( res );
    }

    private void displayLong() {
        if ( quiesceTimeout > 0 ) {
            System.out.println( quiesceTimeout );
        } else if ( quiesceTimeout == 0 ) {
            System.out.println( "Equal to zero..." );
        }
    }

    private static void xpathExample() throws IOException {
        // byte[] xmlContent = getXmlContent();
        try {
            // System.out.println(new String(xmlContent));
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware( false ); // never forget this!
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder
                .parse( "C://EclipseWorkspaces//B2BGateway//fewExamples//src//ProfileService.xml" );

            XPathFactory factory = XPathFactory.newInstance();
            XPath xpath = factory.newXPath();
            XPathExpression expr = xpath.compile( "//ProtocolProfileData/senderId/text()" );

            /*
             * Object result = expr.evaluate( doc, XPathConstants.STRING ); System.out.println( "MKP::::" + (String)
             * result );
             */
            Object result = expr.evaluate( doc, XPathConstants.STRING );
            /*
             * NodeList nodes = (NodeList) result; for (int i = 0; i < nodes.getLength(); i++) {
             * System.out.println(nodes.item(i).getNodeValue()); }
             */
            System.out.println( (String) result );

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    private static byte[] getXmlContent() throws IOException {
        InputStream is = FileOperation.class.getResourceAsStream( "/ProfileService.xml" );
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int line;
        while ( ( line = is.read() ) != -1 ) {
            baos.write( line );
        }
        baos.flush();
        return baos.toByteArray();
    }

    private static void evenOddExample() {
        String res = "";
        int[] arr = new int[10];
        for ( int i = 0; i < arr.length; i++ ) {
            arr[i] = i + 1;
        }

        for ( int i = 0; i < arr.length; i++ ) {
            if ( arr[i] % 2 != 0 ) {
                res = res + i;
            }
        }

        System.out.println( res );

        for ( int i = 0; i < res.length(); i++ ) {
            for ( int j = i + 1; j < res.length(); j++ ) {
                System.out.println( res.charAt( i ) + "," + res.charAt( j ) );
            }
        }
    }

    private static void debugStringExample() {
        FileOperation fo = new FileOperation();
        System.out.println( "in debugStringExample()" );
    }

    private static void arrayExample() {
        ArrayList<String> al = new ArrayList<String>();
        al.add( "a" );
        al.add( "b" );
        al.add( "c" );
        al.add( "d" );
        al.add( "e" );

        System.out.println( al );

        Object[] arr = al.toArray();
        System.out.println( arr.length );

    }

    private static void reverseList() {
        ArrayList<String> al = new ArrayList<String>();
        al.add( "a" );
        al.add( "b" );
        al.add( "c" );
        al.add( "d" );
        al.add( "e" );

        System.out.println( al );

        Collections.reverse( al );

        System.out.println( al );
    }

    private static void runtimeExample() {
        System.out.println( Runtime.getRuntime().availableProcessors() );
    }

    private static void systemPropertiesExample() {

        System.out.println( "os arch: " + System.getProperty( "os.arch" ) );
    }

    private static void objectExample() {
        System.out.println( System.currentTimeMillis() );
        /*
         * Class<?>[] klasses = { FoxAndIntegers.class, junit3.class }; Object[] ar = (Object[]) klasses; for ( int i =
         * 0; i < ar.length; i++ ) { System.out.println( (Class<?>) ar[i] ); }
         */

        String str1 = new String( "Hello" );
        String str2 = str1;
        System.out.println( str2 );
        str2 = "world";
        System.out.println( str2 );
        System.out.println( str1 );

        ArrayList ls = new ArrayList( 20 );

    }

    private static void parseTime() {
        Date d = new Date( System.currentTimeMillis() );
        SimpleDateFormat format = new SimpleDateFormat( "yyyy.MM.dd zzz" );
        String parsedDate = format.format( d );
        System.out.println( parsedDate );
    }

    private static void StringOperation() {
        /*
         * String ignoreBundlesState = "gateway,*osgi,socket*,sftpserver*"; String[] str = ignoreBundlesState.split( ","
         * ); for ( int i = 0; i < str.length; i++ ) { System.out.println( str[i] ); }
         */

        String tag = "ns30:ThreadPoolType";
        String str = tag.substring( tag.lastIndexOf( ':' ) + 1 );
        System.out.println( str );
    }

    private static void latchExample() throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch( 2 );
        new Thread( new Worker( doneSignal ) ).start();
        System.out.println( "hello world" );
        doneSignal.await( 1, TimeUnit.SECONDS );
        System.out.println( "Hello world part 2" );
    }

    private static void ArrayListExample() {
        ArrayList<String> al1 = new ArrayList<String>();
        al1.add( "a" );
        al1.add( "b" );
        al1.add( "c" );

        ArrayList<String> al2 = new ArrayList<String>();
        al2.add( "a2" );
        al2.add( "b2" );
        al2.add( "c2" );

        ArrayList<String> al = new ArrayList<String>();
        al.addAll( al1 );
        al.addAll( al2 );

       // System.out.println( al );
        
        
        List<String> r = new ArrayList<String>();
        System.out.println(r);
        Map<String, String> hm = new HashMap<String, String>();
        hm.put( "a", "apple" );
        hm.put( "b", "book" );
        hm.put( "c", "cat" );
        r.addAll( hm.values() );
        System.out.println(r);
        
        
    }

    public void display() {
        StringBuffer sb = new StringBuffer();
        Class c = this.getClass();
        Field[] fields = c.getDeclaredFields();
        sb.append( c.getName() ).append( " >\n" );
        for ( int i = 0; i < fields.length; i++ ) {
            try {
                sb.append( fields[i].getName() ).append( '=' ).append( fields[i].get( this ) ).append( '\n' );
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        }
        System.out.println( sb.toString() );

    }

    private static void HashMapExample() {

        for ( int i = 0; i < 100000; i++ ) {
            HashMap<String, String> hm = new HashMap<String, String>();

            hm.put( "a", "apple" );
            hm.put( "b", "banana" );
            hm.put( "c", "cherry" );
            hm.put( "d", "date" );

            Iterator<Entry<String, String>> it = hm.entrySet().iterator();

            String str = "";
            while ( it.hasNext() ) {
                Entry<String, String> pairs = it.next();
                str = str + pairs.getKey() + "=" + pairs.getValue();
            }
            if ( !str.equalsIgnoreCase( "a=appleb=bananac=cherryd=date" ) ) {
                System.out.println( "FALSE" );
                throw new IllegalArgumentException( "NOT EQUAL..." );
            }

            hm = null;

        }
    }

    private static void writeFile2( String src, long size ) {
        byte[] block = new byte[32768];
        // initialize buffer
        for ( int loop = 0; loop < 32768; loop++ ) {
            block[loop] = 'a';
        }

        String path = src; // provide file name which you want to generate
        long loop = ( size * 1024 ) / 32768; // If arg1=10 means, 10 KB file will be created
        File f = new File( path );
        FileOutputStream fos;
        try {
            if ( !f.exists() ) {
                f.createNewFile();
            }
            fos = new FileOutputStream( f );
            for ( ; loop > 0; loop-- ) {
                fos.write( block );
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    private static void executeCMD() throws IOException, InterruptedException {
        Process pr = Runtime.getRuntime().exec( "ssh -version" );
        // pr.waitFor();

        int exitVal = pr.waitFor();
        System.out.println( "Exited with error code" + exitVal );

        // Get input streams
        BufferedReader stdInput = new BufferedReader( new InputStreamReader( pr.getInputStream() ) );
        BufferedReader stdError = new BufferedReader( new InputStreamReader( pr.getErrorStream() ) );

        // Read command standard output
        String s;
        System.out.println( "Standard output: " );
        while ( ( s = stdInput.readLine() ) != null ) {
            System.out.println( s );
        }

        // Read command errors
        System.out.println( "Standard error: " );
        while ( ( s = stdError.readLine() ) != null ) {
            System.out.println( s );
        }
    }

    private static void filePermission() {
        FilePermission fp = new FilePermission( "fileRead.txt", "read" );
    }

    private static void createFileWithSize() throws IOException {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile( "c:\\t.txt", "rw" );
            raf.setLength( 1024 * 1024 * 1024 );
            System.out.println( "done" );
        } finally {
            if ( raf != null ) {
                raf.close();
            }
        }
    }

    private static void readfile( String[] args ) {
        String fileLoc = args[0].substring( args[0].indexOf( '=' ) + 1 );
        System.out.println( "MKP----" + fileLoc );
        try {
            InputStream in = new FileInputStream( fileLoc );
            Properties props = new Properties();
            props.load( in );

            System.out.println( props.getProperty( "REMOTE_HOST" ) );
            System.out.println( props.getProperty( "REMOTE_PORT" ) );
            System.out.println( props.getProperty( "REMOTE_USER" ) );
            System.out.println( props.getProperty( "REMOTE_PASSWORD" ) );

        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    private static void localDirectory() {
        String currDir = System.getProperty( "user.dir" );
        String os = System.getProperty( "os.name" );
        System.out.println( currDir );
        System.out.println( File.separator );
    }

    private static void ternaryOperation() {
        String src = "C:/delete/collect/dest/";
        int lastIndex = src.lastIndexOf( '/' ) == -1 ? src.lastIndexOf( '\\' ) == -1 ? -1 : src.lastIndexOf( '\\' )
            : src.lastIndexOf( '/' );

        String parentFolder = "";
        String filePattern = "";
        if ( lastIndex == -1 ) {
            // Current directory
            parentFolder = ".";
            filePattern = src;
        } else {
            parentFolder = src.substring( 0, lastIndex + 1 );
            filePattern = src.substring( lastIndex + 1 );
        }

        System.out.println( lastIndex );

        final String filteredPattern = filteredFilePattern( filePattern );
        if ( filteredPattern.equalsIgnoreCase( "" ) ) {
            String[] s = new String[0];
            System.out.println( "stirng temp:" + s.length );
        }
        File f = new File( parentFolder );

        // FilenameFilter filter = new GlobFilenameFilter( filePattern );
        // String[] fileNames = f.list( filter );

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept( File dir, String name ) {
                // return name.matches( pattern );
                return name.endsWith( filteredPattern );
            }
        };

        String[] fileNames = f.list( filter );

        // Get Absolute file names
        if ( !parentFolder.equals( "." ) && fileNames != null ) {
            for ( int i = 0; i < fileNames.length; i++ ) {
                fileNames[i] = parentFolder + fileNames[i];
            }
        }

        System.out.println( "Parent:" + parentFolder + "   filePattern:" + filePattern + "    filteredPattern:"
            + filteredPattern );

        for ( int i = 0; i < fileNames.length; i++ )
            System.out.println( fileNames[i] );

    }

    private static void fileDelete() {
        File f = new File( "C:\\delete\\collect\\wrongMailbox2\\hhhh*" );
        File[] fileArray = f.listFiles();
        for ( int i = 0; i < fileArray.length; i++ )
            System.out.println( fileArray[i].getName() );
        // f.delete();
        // System.out.println( "Local file deleted: " + fileName );
    }

    private static void indexExample() {
        String fName = "c:\\programs\\hello.txt";
        String docId = "";
        if ( fName.contains( "." ) ) {
            int ind = fName.lastIndexOf( '.' );
            docId = fName.substring( 0, ind ) + "_" + "appendCopy" + fName.substring( ind, fName.length() );
        } else {
            docId = fName + "_" + "appendCopy";
        }

        System.out.println( "DocId:" + docId );
    }

    private static void file1() {
        String str = "/";
        if ( str.endsWith( "/" ) ) {
            System.out.println( str.indexOf( "/" ) );
        } else {
            System.out.println( "Not found..." );
        }
    }

    private static void intExample() {

        String port = "4098";
        BigInteger m = new BigInteger( port );
        System.out.println( "Port:" + m );
    }

    private static void filePattern() {

        String parentFolder = "C:\\EclipseWorkspaces\\B2BGateway\\fewExamples";
        String filePattern = "*.txt";

        String filteredPattern = filteredFilePattern( filePattern );

        System.out.println( "Filtered file pattern: " + filteredPattern );

        File f = new File( parentFolder );

        String[] listFiles = f.list();

        for ( int i = 0; i < listFiles.length; i++ ) {
            if ( listFiles[i].endsWith( filteredPattern ) ) {
                System.out.println( "Filtered file name: " + listFiles[i] );
            }
        }

    }

    private static String filteredFilePattern( String filePattern ) {

        if ( filePattern.startsWith( "*" ) ) {
            return filePattern.substring( 1 );
        }

        return filePattern;
    }

    private static void filePatternExample_oro() {/*
                                                   * 
                                                   * String parentFolder =
                                                   * "C:\\EclipseWorkspaces\\B2BGateway\\fewExamples"; String
                                                   * filePattern = "*.txt";
                                                   * 
                                                   * File f = new File( parentFolder );
                                                   * 
                                                   * FilenameFilter filter = new GlobFilenameFilter( filePattern );
                                                   * String[] listFiles = f.list( filter );
                                                   * 
                                                   * for ( int i = 0; i < listFiles.length; i++ ) { System.out.println(
                                                   * "Filter file name with oro: " + listFiles[i] ); }
                                                   */
    }

    private static void filePatternExample() {
        final String pattern = "file*.txt";
        File f = new File( "C:\\EclipseWorkspaces\\B2BGateway\\fewExamples" );

        final String filteredPattern = filteredFilePattern( pattern );

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept( File dir, String name ) {
                // return name.matches( pattern );
                return name.endsWith( filteredPattern );
            }
        };

        String[] listFiles = f.list( filter );

        for ( int i = 0; i < listFiles.length; i++ ) {
            System.out.println( "Filter file name NO ORO:" + listFiles[i] );
        }
    }

    private static void writefile() throws IOException {
        String file = "C:\\Users\\IBM_ADMIN\\1.5gb_get";

        int offset = 0;
        int COPY_BUFFER_SIZE = 1024;
        byte[] buffer = new byte[COPY_BUFFER_SIZE];

        FileInputStream fis = new FileInputStream( file );

        String localFileName = "get1.5gb";
        File flocal = new File( localFileName );
        flocal.createNewFile();
        FileOutputStream fos = new FileOutputStream( flocal );

        while ( true ) {
            System.out.println( "MKP: In while loop.offset:" + offset );

            int bytesRead = fis.read();
            if ( bytesRead < 0 ) {
                System.out.println( "MKP: No more bytes to read..." );
                break;
            }

            fos.write( buffer, 0, bytesRead );
            offset = offset + bytesRead;
            System.out.println( "MKP: Transferred bytes: " + bytesRead );
            System.out.println( "MKP: Offset: " + offset );
        }

        int bytesRead = 0;
        while ( ( bytesRead = fis.read() ) != -1 ) {
            fos.write( bytesRead );
        }

        fis.close();
        fos.close();

    }

    private static void fileOperation4() {
        // Create file with size
        String fname = "filesize.txt";
        try {
            BufferedOutputStream fos = new BufferedOutputStream( new FileOutputStream( fname ) );
            String str = "AAAAAAAAAA";

            byte[] b = str.getBytes();
            fos.write( b );
            fos.close();

            File f = new File( fname );
            System.out.println( "File size: " + f.length() );

            Long filesize = 1024 * 1024 * 1524L;
            RandomAccessFile ff = new RandomAccessFile( "C:\\Users\\IBM_ADMIN\\1.5gb", "rw" );
            ff.setLength( filesize );

        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

    private static void ipaddressExample() {
        try {
            InetAddress thisIp = InetAddress.getLocalHost();
            System.out.println( "IP:" + thisIp.getHostAddress() );
        } catch ( UnknownHostException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void dateExample() throws InterruptedException {
        System.out.println( new Date( 1361776249161L ).toString() );
        System.out.println( new Date( 1361776248104L ).toString() );
        System.out.println( new Date( 1361776248094L ).toString() );
        System.out.println( new Date( 1361776249000L ).toString() );
        System.out.println( new Date( 1361776247886L ).toString() );
        System.out.println( new Date( 1361776249410L ).toString() );

        long start_time = System.currentTimeMillis();
        // Thread.sleep( 2300 );
        long end_time = System.currentTimeMillis();
        long execution_time = end_time - start_time;

        TimeTracker.executionTaken.put( "time1", new TimeTracker( start_time, end_time, execution_time ) );

        // Thread.sleep( 1200 );

        TimeTracker t_ms = TimeTracker.executionTaken.get( "time1" );
        String execTime = t_ms.parseTime( t_ms.getExecutionTime() );
        String sTime = t_ms.parseDate( t_ms.getStartTime() );
        String eTime = t_ms.parseDate( t_ms.getEndTime() );

        System.out.println( "-----------------------------" );
        System.out.println( "Exec time:" + execTime );
        System.out.println( "Start time:" + sTime );
        System.out.println( "End time:" + eTime );
    }

    private static void fileOperation3() {
        File f = new File( "MySftpClient.java" );
        Long fsize = f.length();
        System.out.println( fsize );

        String str = String.valueOf( fsize );
        System.out.println( str );

        Long l = 100L;
        System.out.println( l );
    }

    private static void hashMapExample() {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put( "a", "am" );
        hm.put( "p", "pm" );

        // String str = hm.get( "h" );
        // System.out.println( "MANOJ: " + str );

        Set<String> keys = hm.keySet();
        for ( String key : keys ) {
            System.out.println( key );
        }
    }

    private static void fileOperation2() {/*
                                           * 
                                           * String parentFolder = ""; String filePattern = ""; String src =
                                           * "c:/delete/*.xml"; int lastIndex = src.lastIndexOf( "/" ); if ( lastIndex
                                           * == -1 ) { // Current directory parentFolder = "."; filePattern = src; }
                                           * else { parentFolder = src.substring( 0, lastIndex + 1 ); filePattern =
                                           * src.substring( lastIndex + 1 ); }
                                           * 
                                           * System.out.println( "Parent Folder:" + parentFolder ); System.out.println(
                                           * "File pattern:" + filePattern ); File f = new File( parentFolder );
                                           * 
                                           * FilenameFilter filter = new GlobFilenameFilter( filePattern ); String[]
                                           * files = f.list( filter ); for ( int i = 0; i < files.length; i++ ) {
                                           * System.out.println( files[i] + "," ); }
                                           */
    }

    private static void fileOperation1() {
        // File fileObj = new File("/");
        // // File f = new File();
        //
        // String absPath = fileObj.getAbsolutePath();
        //
        // System.out.println("fileName: "+fileObj.getPath());
        //
        // System.out.println("Absolute path: "+absPath);
        //
        // String path = "/home/mkprasad/delete/dir/";
        // String userFileName = path.substring("/".length() - 1);
        // System.out.println("path: "+path);
        // System.out.println("userfilename: "+userFileName);
        //
        // String pName = getAbsolutePath( path );
        //
        // int slashIndex = pName.lastIndexOf("/");
        // String parentDir = pName.substring(0, slashIndex + 1);
        //
        // System.out.println(pName);
        // System.out.println(parentDir);

    }

    private static void createFile() {

        try {
            BufferedOutputStream fos = new BufferedOutputStream( new FileOutputStream( "tempfile22" ) );
            String str = "This is a flat file...";
            byte[] b = str.getBytes();
            fos.write( b );
            fos.close();
        } catch ( FileNotFoundException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch ( IOException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static String getAbsolutePath( String fName ) {

        // strip the last '/' if necessary [ full path to file. If file is "/home/mkprasad/delete/dir/" -->
        // /home/mkprasad/delete/dir will be returned ]
        String fullName = fName;
        int filelen = fullName.length();
        if ( ( filelen != 1 ) && ( fullName.charAt( filelen - 1 ) == '/' ) ) {
            fullName = fullName.substring( 0, filelen - 1 );
        }

        return fullName;
    }

}
