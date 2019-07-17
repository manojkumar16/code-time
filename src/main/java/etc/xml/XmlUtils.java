package etc.xml;

import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlUtils {

    public static void main( String[] args ) throws IOException, URISyntaxException, SAXException,
        ParserConfigurationException {
        Document doc = buildDocument( "/UpdatableProperties.xml" );

        ProvisioningProperties props = new ProvisioningProperties();
        List<ProvisioningProperties.Properties.Property> list = fillPPWithNonExistField( props );

        populateNamespace( props );

        XmlEditor x = new XmlEditor( doc, props );
        
        System.out.println("-------old xml-------");
        System.out.println(x.serialize( doc ));

        Document updatedDoc = x.process();

        if ( updatedDoc != null ) {
            System.out.println("-------new xml-------");
            System.out.println( x.serialize( updatedDoc ) );
        }

    }

    private static List<ProvisioningProperties.Properties.Property> fillPPWithNonExistField(
        ProvisioningProperties props ) {
        ProvisioningProperties.Properties prp = new ProvisioningProperties.Properties();
        props.setProperties( prp );
        List<ProvisioningProperties.Properties.Property> list = prp.getProperty();

        list.add( getProperty( "ns7:ProvisioningRequest/Body/ns30:ThreadPoolType/ns16:name", "Set to 20 threads" ) );
        list.add( getProperty( "ns7:ProvisioningRequest/Body/ns30:ThreadPoolType/priority", "5" ) );
        list.add( getProperty( "ns7:ProvisioningRequest/Body/ns30:ThreadPoolType/priority", "10" ) );
        list.add( getProperty(
            "ns7:ProvisioningRequest/Body/ns30:ThreadPoolType/ns16:AccessControl/UserPermission", "RWX" ) );

        list.add( getProperty(
            "ns7:ProvisioningRequest/Body/ns30:ThreadPoolType/ns16:AccessControl/GroupPermission", "RWX" ) );

        list.add( getProperty(
            "ns7:ProvisioningRequest/Body/ns30:ThreadPoolType/ns16:AccessControl/ThreadGroup/ChildGroup/ns19:isDaemon",
            "true" ) );
        list.add( getProperty( "//ns30:ThreadPoolType/ns16:AccessControl/ThreadGroup/ChildGroup/ns19:isDaemon",
            "false" ) );

        return list;
    }

    private static void populateNamespace( ProvisioningProperties props ) {
        ProvisioningProperties.Namespaces ns = new ProvisioningProperties.Namespaces();
        props.setNamespaces( ns );
        List<ProvisioningProperties.Namespaces.Namespace> nslist = ns.getNamespace();

        nslist.add( getNamespace( "ns20",
            "http://www.ibm.com/b2b/apiint/messagedefinitions/messages/xml/exchange/webservice" ) );

        nslist.add( getNamespace( "ns7",
            "http://www.ibm.com/b2b/apiint/messagedefinitions/messages/xml/provisioning" ) );
        nslist.add( getNamespace( "ns30",
            "http://www.ibm.com/b2b/apiint/messagedefinitions/messages/xml/exchange/threadpool" ) );
        nslist.add( getNamespace( "ns16",
            "http://www.ibm.com/b2b/apiint/messagedefinitions/messages/xml/exchange/commons" ) );
        nslist
            .add( getNamespace( "ns19", "http://www.ibm.com/b2b/apiint/messagedefinitions/messages/xml/exchange" ) );
    }

    private static ProvisioningProperties.Namespaces.Namespace getNamespace( String ns, String uri ) {
        ProvisioningProperties.Namespaces.Namespace n = new ProvisioningProperties.Namespaces.Namespace();
        n.setNs( ns );
        n.setUri( uri );
        return n;
    }

    private static ProvisioningProperties.Properties.Property getProperty( String key, String value ) {
        ProvisioningProperties.Properties.Property p = new ProvisioningProperties.Properties.Property();
        p.setKey( key );
        p.setValue( value );
        return p;
    }

    private static Document buildDocument( String path ) throws SAXException, IOException,
        ParserConfigurationException, URISyntaxException {
        URL res = XmlUtils.class.getResource( path );
        byte[] bytes = Files.readAllBytes( Paths.get( res.toURI() ) );
        String xml = new String( bytes );

        // System.out.println( xml );
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setNamespaceAware( true );
        return f.newDocumentBuilder().parse( new InputSource( new StringReader( xml ) ) );
    }

}
