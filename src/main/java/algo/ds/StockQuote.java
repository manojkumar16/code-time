package algo.ds;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StockQuote {
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile( "\\A" );

    public static void main( String[] args ) throws IOException {
        String ubi = "http://money.rediff.com/companies/United-Bank-of-India/14030059";
        String cairn = "http://money.rediff.com/companies/Cairn-India-Ltd/15120019";
        String icici = "http://money.rediff.com/companies/ICICI-Bank-Ltd/14030056";
        Long start = System.currentTimeMillis();
        System.out.println( "United bank of india: " + getPrice( ubi ) );
        System.out.println( "Cairn India Ltd: " + getPrice( cairn ) );
        System.out.println( "ICICI bank: " + getPrice( icici ) );
        Long end = System.currentTimeMillis();
        
       // System.out.println("Time taken in sec: "+ (end - start)/100);
    }

    private static String getPrice( String name ) throws IOException {
        URL url = new URL( name );
        URLConnection site = url.openConnection();
        InputStream is = site.getInputStream();
        Scanner scanner = new Scanner( new BufferedInputStream( is ) );

        String fstring = "<span id=\"ltpid\" class=\"bold\">";
        String lstring = "</span>";
        String text = scanner.useDelimiter( EVERYTHING_PATTERN ).next();
        int from = text.indexOf( fstring, 0 );
        int to = text.indexOf( lstring, from );
        String price = text.substring( from + fstring.length(), to );
        return price;
    }

}
