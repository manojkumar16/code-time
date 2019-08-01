package etc.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DocumentExample {

    public static void main( String[] args ) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        List<String> content = loadFile( "C:\\Users\\IBM_ADMIN\\aggregatorrequest" );

        for ( int i = 0; i < content.size(); i++ ) {
            System.out.println( content.get( i ) );

            createAggregatorMessage( content.get( i ) );
        }
    }

    private static void createAggregatorMessage( String content ) throws XPathExpressionException, SAXException, IOException, ParserConfigurationException {

        Object node = getNodeValue( getDocument( content ), "//AggregatorMessage/Query" );
        System.out.println("MKP::::"+node);

        /*System.out.println( getFieldValue( getDocument( content ), "//AggregatorRequest/correlationId/text()" ) );
        System.out.println( getFieldValue( getDocument( content ), "//AggregatorRequest/details/text()" ) );
        System.out.println( getFieldValue( getDocument( content ), "//AggregatorRequest/id/text()" ) );
        System.out.println( getFieldValue( getDocument( content ), "//AggregatorRequest/instanceId/text()" ) );
        System.out.println( getFieldValue( getDocument( content ), "//AggregatorRequest/memberId/text()" ) );*/
    }

    private static Object getNodeValue( Document dom, String expression ) throws XPathExpressionException {

        Object result = null;
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        XPathExpression expr = xpath.compile( expression );
        return expr.evaluate( dom );
       // result = expr.evaluate( dom, XPathConstants.NODE );
       // return result;
    
    }

    private static String getFieldValue( Document dom, String expression ) throws XPathExpressionException {
        Object result = null;
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        XPathExpression expr = xpath.compile( expression );
        result = expr.evaluate( dom, XPathConstants.STRING );
        return (String) result;
    }

    private static Document getDocument( String message ) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware( true );
        return documentBuilderFactory.newDocumentBuilder().parse( new InputSource( new StringReader( message ) ) );
    }

    private static List<String> loadFile( String fileName ) throws SAXException, IOException,
        ParserConfigurationException {
        File file = new File( fileName );
        InputStream inputStream = null;
        List<String> al = new ArrayList<String>();
        if ( file.isDirectory() ) {
            File[] files = file.listFiles();
            Arrays.sort( files );
            for ( File file1 : files ) {
                if ( file1.exists() && !file1.isDirectory() ) {
                    inputStream = new FileInputStream( file1 );
                    al.add( createRequestAsString( inputStream ) );
                }
            }
            return al;
        } else if ( file.exists() && !file.isDirectory() ) {
            inputStream = new FileInputStream( file );
            al.add( createRequestAsString( inputStream ) );
            return al;
        } else {
            throw new FileNotFoundException( fileName );
        }
    }

    private static String createRequestAsString( InputStream inputStream ) throws SAXException, IOException,
        ParserConfigurationException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware( true );
        Document doc = documentBuilderFactory.newDocumentBuilder().parse( inputStream );
        String docStr = convertDomToString( doc );
        return convertDomToString( doc );
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

}
