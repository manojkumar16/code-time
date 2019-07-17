package etc.xml;

import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import etc.xml.ProvisioningProperties.Properties.Property;


public class XmlEditor {

    final Document doc;

    final ProvisioningProperties props;

    final XPath xPath;

    public XmlEditor( Document doc, ProvisioningProperties props ) {
        this.doc = doc;
        this.props = props;
        xPath = getXPath( props );
    }

    public Document process() {

        List<Property> list = props.getProperties().getProperty();
        if ( list == null || list.size() == 0 ) {
            return null;
        }
        for ( Property p : list ) {
            modify( doc, p.getKey(), createTextNode( p.getValue() ) );
        }

        return this.doc;
    }

    private Node createTextNode( String value ) {
        Text text = this.doc.createTextNode( value );
        return text;
    }

    private Node modify( Document doc2, String key, Node n ) {
        Node node = getNode( doc2, key );
        if ( node != null ) {
            setChild( n, node );
            return node;
        } else {
            return modify( doc2, getPredecessors( key ), wrap( getCurrent( key ), n ) );
        }
    }

    private Node wrap( String current, Node n ) {
        Element node1 = null;
        String[] str = current.split( ":" );
        if ( str.length == 2 ) {
            node1 = doc.createElementNS( xPath.getNamespaceContext().getNamespaceURI( str[0] ), str[1] );
            node1.setPrefix( str[0] );
        } else {
            node1 = doc.createElement( current );
        }

        setChild( n, node1 );
        return (Node) node1;
    }

    private void setChild( Node n, Node node1 ) {
        if ( n instanceof Text ) {
            node1.setTextContent( n.getTextContent() );
        } else {
            node1.appendChild( n );
        }
    }

    private String getCurrent( String key ) {
       // String pattern = "([^/]+)(/?)$";
        String pattern = "(?<=.*)([^/]+)(?=/?$)";
        Pattern p = Pattern.compile( pattern );
        Matcher matcher = p.matcher( key );

        if ( matcher.find() ) {
            return matcher.group();
        }

        return null; // TODO MKPP - Throw exception...
    }

    private String getPredecessors( String key ) {
        return key.substring( 0, key.lastIndexOf( getCurrent(key) ) - 1 );
    }

    private Node getNode( Document doc2, String key ) {
        try {

            NodeList nodes = (NodeList) xPath.evaluate( key, doc2, XPathConstants.NODESET );

            if ( nodes != null ) {
                return nodes.item( 0 );
            }

            return null;
        } catch ( XPathExpressionException e ) {
            e.printStackTrace();
            return null;// TODO kill this , throw exception
        }
    }

    public static XPath getXPath( final ProvisioningProperties props ) {
        XPath xPath = XPathFactory.newInstance().newXPath();
        xPath.setNamespaceContext( new XmlNamespaceContext( props ) );
        return xPath;
    }

    static class XmlNamespaceContext implements NamespaceContext {

        private ProvisioningProperties props;

        public XmlNamespaceContext( ProvisioningProperties props ) {
            this.props = props;
        }

        @Override
        public String getNamespaceURI( String prefix ) {
            if ( prefix == null ) {
                throw new IllegalArgumentException( "No prefix provided!" );
            }

            List<ProvisioningProperties.Namespaces.Namespace> nslist = props.getNamespaces().getNamespace();
            for ( ProvisioningProperties.Namespaces.Namespace ns : nslist ) {
                if ( ns.getNs().equals( prefix ) ) {
                    return ns.getUri();
                }
            }

            return XMLConstants.NULL_NS_URI;
        }

        @Override
        public String getPrefix( String namespaceURI ) {
            throw new RuntimeException( "Not implemented." );
        }

        @Override
        public Iterator getPrefixes( String namespaceURI ) {
            throw new RuntimeException( "Not implemented." );
        }
    }

    /**
     * Converts an XML Document to String.
     * 
     * @param doc the XML document
     * @return String representation of the Document
     * @throws XmlProcessingException xml exception
     */
    public String serialize( Document doc ) {

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.setOutputProperty( OutputKeys.INDENT, "yes" );

            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult( sw );
            DOMSource source = new DOMSource( doc );
            t.transform( source, result );
            return sw.toString();
        } catch ( TransformerConfigurationException e ) {
            e.printStackTrace();
        } catch ( TransformerException e ) {
            e.printStackTrace();
        }
        return null;
    }
}
