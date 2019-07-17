package etc;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EmployeeXmlReaderWriter {
    private static List<Employee1> employees = new ArrayList<Employee1>();

    public static void main( String[] args ) {
        String source = "c:\\employee.xml";
        String destination = "c:\\employee_out.xml";
        
        File xmlFile = new File( source );
        readXMLFile( xmlFile );

        save();

        fetchFromDB();
        
        String xmlString = getEmployeeXMLInformationInString();
        writeXMLFile(xmlString, destination);
    }

    private static void writeXMLFile( String xmlString, String destination ) {
        String xmlHeader = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n";
        System.out.print(xmlHeader);
        System.out.println(xmlString);
        
        try {
            File outFile = new File(destination);
            BufferedWriter out = new BufferedWriter(new FileWriter( outFile ));
            out.write( xmlHeader );
            out.write( xmlString );
            out.close();
            System.out.println("----------------------");
            System.out.println("File has been written...");
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    private static String getEmployeeXMLInformationInString() {
           Document doc = null;
        try {
                // Creating an empty XML Document

               // We need a Document
               DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
               DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
               doc = docBuilder.newDocument();
               
               // Creating the XML tree

               // create the root element and add it to the document
               Element root = doc.createElement("xml");
               doc.appendChild(root);
               
               Element empl = doc.createElement("EMPLOYEES");
               root.appendChild(empl);
               
               for(int i=0; i<employees.size(); i++) {
                   //Get Employee object one by one...
                   Employee1 emp = employees.get( i );
                   
                   Element employee = doc.createElement("EMPLOYEE");
                   empl.appendChild(employee);

                   Element employee_id = doc.createElement( "ID" );
                   employee_id.setTextContent( emp.getEmployeeId() );
                   employee.appendChild( employee_id );

                   Element firstName = doc.createElement( "FIRSTNAME" );
                   firstName.setTextContent( emp.getFirstName() );
                   employee.appendChild( firstName );
                   
                   Element lastName = doc.createElement( "LASTNAME" );
                   lastName.setTextContent( emp.getLastName() );
                   employee.appendChild( lastName );
                   
                   Element designation = doc.createElement( "DESIGNATION" );
                   designation.setTextContent( emp.getDesignaiton() );
                   employee.appendChild( designation );
                   
                   Element organization = doc.createElement( "ORGANIZATION" );
                   organization.setTextContent( emp.getOrganization() );
                   employee.appendChild( organization );
                   
                   Element location = doc.createElement( "LOCATION" );
                   location.setTextContent( emp.getLocation() );
                   employee.appendChild( location );
                   
                   Element jobtype = doc.createElement( "JOBTYPE" );
                   jobtype.setTextContent( emp.getJobType() );
                   employee.appendChild( jobtype );
               }
        } catch ( DOMException e ) {
            e.printStackTrace();
        } catch ( ParserConfigurationException e ) {
            e.printStackTrace();
        }

        return DocumentAsAString(doc);
    }

    private static String DocumentAsAString( Document doc ) {
        String xmlString = "";
        // Output the XML
        try {
            // set up a transformer
            TransformerFactory transfac = TransformerFactory.newInstance();
            Transformer trans = transfac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            // create string from xml tree
            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(doc);
            trans.transform(source, result);

            xmlString = sw.toString();
        } catch ( TransformerConfigurationException e ) {
            e.printStackTrace();
        } catch ( IllegalArgumentException e ) {
            e.printStackTrace();
        } catch ( TransformerFactoryConfigurationError e ) {
            e.printStackTrace();
        } catch ( TransformerException e ) {
            e.printStackTrace();
        }
        
        return xmlString;
    }

    private static void fetchFromDB() {
        // Fetch employee information from database and save the information by calling setter
        // For instance,
        // String firstname = getFirstNameFromDB();
        // Employee emp = new Employee();
        // employees.add(emp);
        // emp.setFirstName(firstname);
        
    }

    private static void save() {
        // You have employee information with you now... Save it into database...
        
    }
    
    private static void readXMLFile( File xmlFile ) {

        try {
            DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
            Document doc = docBuilder.parse( xmlFile );

            NodeList list = doc.getElementsByTagName( "EMPLOYEE" );

            for ( int i = 0; i < list.getLength(); i++ ) {
                Employee1 emp = new Employee1();
                
                Node node = list.item( i );
                if ( node.getNodeType() == Node.ELEMENT_NODE ) {
                    Element elem = (Element) node;
                    
                    String employee_id = getValue("ID", elem);
                    System.out.println("EMPLOYEE ID : " + employee_id);
                    emp.setEmployeeId( employee_id );
                    
                    String firstname = getValue( "FIRSTNAME", elem );
                    System.out.println( "FIRST NAME : " + firstname );
                    emp.setFirstName( firstname );
                    
                    String lastname = getValue( "LASTNAME", elem );
                    System.out.println( "LAST NAME : " + lastname );
                    emp.setLastName( lastname );
                    
                    String designation = getValue( "DESIGNATION", elem );
                    System.out.println( "DESIGNATION : " + designation );
                    emp.setDesignation( designation );
                    
                    String org = getValue( "ORGANIZATION", elem );
                    System.out.println( "ORGANIZATION : " + org );
                    emp.setOrganization( org );
                    
                    String location = getValue( "LOCATION", elem );
                    System.out.println( "LOCATION : " + location );
                    emp.SetLocation( location );
                    
                    String jobtype = getValue( "JOBTYPE", elem );
                    System.out.println( "JOBTYPE : " + jobtype );
                    emp.setJobType( jobtype );
                    
                    //Add employee details entry into employees arrayList
                    employees.add(emp);
                }
                
                System.out.println( "-----------------------" );
            }

        } catch ( ParserConfigurationException e ) {
            e.printStackTrace();
        } catch ( SAXException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }

    }

    private static String getValue( String tag, Element elem ) {
        NodeList list = elem.getElementsByTagName( tag ).item( 0 ).getChildNodes();
        Node value = (Node) list.item( 0 );
        return value.getNodeValue();
    }
}

class Employee {
    private String employeeId;
    private String fName;
    private String lName;
    private String designation;
    private String organization;
    private String loc;
    private String jobType;
    
    public void setEmployeeId(String id) {
        this.employeeId = id;
    }
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setFirstName(String fName) {
        this.fName = fName;
    }
    
    public String getFirstName() {
        return fName;
    }
    
    public void setLastName(String lName) {
        this.lName = lName;
    }
    
    public String getLastName() {
        return lName;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public String getDesignaiton() {
        return designation;
    }
    
    public void setOrganization(String org) {
        this.organization = org;
    }
    
    public String getOrganization() {
        return organization;
    }
    
    public void SetLocation(String loc) {
        this.loc = loc;
    }
    
    public String getLocation() {
        return loc;
    }
    
    public void setJobType(String job) {
        this.jobType = job;
    }
    
    public String getJobType() {
        return jobType;
    }
}