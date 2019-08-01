package etc.one;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLExample {

    public static void main( String[] args ) {
        new XMLExample().xmlStreamReaderExample();
    }

    private void xmlStreamReaderExample() {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        try {

            XMLStreamReader streamReader = factory
                .createXMLStreamReader( new FileReader(
                    "/home/mkprasad/MEGDevelopment/B2BGateway/com.ibm.b2b.build.libertymaterialization/target/Members/Operational/usr/servers/Operational/x2.xml" ) );


            while ( streamReader.hasNext() ) {
                streamReader.next();
                if ( streamReader.getEventType() == XMLStreamReader.START_ELEMENT ) {
                    if("PayloadInfo".equalsIgnoreCase( streamReader.getLocalName() )) {
                    //    streamReader.getAttributeValue( null,  )
                        String type = streamReader.getAttributeValue( "/PartInfo/PartProperties/Property/MimeType", "MimeType" );
                        System.out.println("MKPP: "+type);
                        String type2 = streamReader.getAttributeValue( "PartInfo", "MimeType" );
                        System.out.println("MKPP: "+type2);
                        
                        System.out.println(streamReader.getAttributeValue( null, "PartInfo" ));
                        
                    }
                }
            }

        } catch ( XMLStreamException e ) {
            e.printStackTrace();
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        }
    }
}
