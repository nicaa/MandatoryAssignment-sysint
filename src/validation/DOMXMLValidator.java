/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Rasmus
 */
public class DOMXMLValidator {
    
    public String validateXmlFile(String xmlPath, String xsdPath) {
        File myxmlfile = new File(xmlPath);
        File myschemafile = new File(xsdPath);
        
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
            return "Validation failed";
        }
        
        return "Succesfully validated xml file against its schema";
    }
}
