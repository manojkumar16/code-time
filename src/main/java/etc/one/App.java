package etc.one;
import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class App {
    public static void main( String[] args ) {
        try {
            DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setNamespaceAware( true );
            DocumentBuilder builder = domFactory.newDocumentBuilder();
            Document doc = builder.parse( "C:\\Users\\IBM_ADMIN\\Desktop\\temp\\student.xml" );
           
            XPath xPath = XPathFactory.newInstance().newXPath();
            xPath.setNamespaceContext( new NamespaceContext() {
                public String getPrefix( String namespaceURI ) {
                    return null;
                }
                public Iterator getPrefixes( String namespaceURI ) {
                    return null;
                }
                @Override
                public String getNamespaceURI( String prefix ) {
                    if ( prefix == null ) {
                        throw new IllegalArgumentException( "No prefix provided!" );
                    } else if ( prefix.equals( "xsi" ) ) {
                        return "http://www.w3.org/2001/XMLSchema-instance";
                    } else if ( prefix.equals( "ns1" ) ) {
                        return "http://www.abc.com/Student/1.0";
                    } else {
                        return XMLConstants.NULL_NS_URI;
                    }
                }
            } );

            String key = "//ns1:STUDENT/xsi:FIRST_NAME/text()";
            String value = "RRRR";
            
            //Replace
            //Document doc2 = replace(doc, key, value);
            
            NodeList nodes = (NodeList) xPath.evaluate( key,doc,XPathConstants.NODESET);
            nodes.item( 0 ).setTextContent( "mkppppppppp" );
            
            
            
            String result = xPath.evaluate( key, doc );
            System.out.println( "XPath result is " + result );
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }

   
}
