
package validation;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;

/**
 *
 * @author Dora
 */

/**
 * 
 * First create an XSD Schema instance from the XSD schema file, then create a Validator instance from the schema instance. 
 * This Validator instance can then be used to validate an XML file represented with the DOM interface or the SAX interface
 * For schema language see http://www.w3.org/TR/xmlschema-0/
 */

public class XMLDOMValidate 
{
    public static void main(String[] args) 
    {
        File myxmlfile = new File("src/XML/productOrder.xml");
        File myschemafile = new File("src/XML/ProductOrder.xsd");
        
        Schema schema = null;
        
        // load an XML Schema into the Schema instance
        try 
        {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            schema = factory.newSchema(myschemafile);
            
            // Parse the XML document to DOM Document, and then validate it
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            builderFactory.setNamespaceAware(true);
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(myxmlfile);
            DOMSource source = new DOMSource(doc);
          
            Validator validator = schema.newValidator();
            validator.validate(source);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }  
    }

}
