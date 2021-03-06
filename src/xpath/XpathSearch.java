
package xpath;

import java.io.File;
import java.io.IOException;
import javax.swing.JTextArea;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Nichlas
 */
public class XpathSearch {
    
    public void getShippingInformationByCountry (JTextArea textArea, String Querry) throws SAXException, IOException, XPathExpressionException, ParserConfigurationException{
       
            File myxmlfile = new File("productOrder.xml");
            textArea.setText("");
            // Path expressions
            //String str1 = "//Employee[name='Jarl']/role/text()";
            //String str2 = "count(//Employee[role='Manager'])";
            String str1 = "//ShippingInformation[Country='"+Querry+"']/*/text()";
           // String str2 = "";
            // standard for reading an XML file
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(myxmlfile);
            // create an XPathFactory and an XPath object
            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xpath = xFactory.newXPath();
            XPathExpression expr1, expr2;
            // compile the XPath expression to get the role of Jarl
            expr1 = (XPathExpression) xpath.compile(str1);
            // run the query and get a nodeset as a result
            Object result = expr1.evaluate(doc, XPathConstants.NODESET);
            // cast the result to a DOM NodeList
            NodeList results = (NodeList) result;
            for (int i=0; i<results.getLength(); i++)
            {
                System.out.println(results.item(i).getNodeValue());
                textArea.append(results.item(i).getNodeValue() + "\n");
            }   
        if (results.getLength() == 0) {
            textArea.setText("Not found Search for another please");
        }
            
            // new XPath expression to get the number of Managers
            //  expr2 = (XPathExpression) xpath.compile(str2);
            // run the query and get the number of nodes, returned result is Double
            //Double number = (Double) expr2.evaluate(doc, XPathConstants.NUMBER);
            //System.out.printf("Number of Managers:%2.0f\n", number);
        
    }
    
    public String getChildElements(String elementName) throws XPathExpressionException, SAXException, ParserConfigurationException, IOException {
        File xmlFile = new File("productOrder.xml");
        StringBuilder stringBuilder = new StringBuilder();
        
        String xPathQuery = "//"+ elementName +"/*//text()";
        
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            
            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xpath = xFactory.newXPath();
            XPathExpression expr1, expr2;
            
            expr1 = (XPathExpression) xpath.compile(xPathQuery);
            
            Object result = expr1.evaluate(doc, XPathConstants.NODESET);
            
            NodeList results = (NodeList) result;
            
            int count = 0;
            
            for (int i=0; i<results.getLength(); i++)
            {
                stringBuilder.append(results.item(i).getNodeValue() + "\n");
                count++;
            }
            
            stringBuilder.append("\n Found " + count + " elements");
            return stringBuilder.toString();        
    }
    
        public String getElement(String elementName) throws XPathExpressionException, SAXException, ParserConfigurationException, IOException {
        File xmlFile = new File("productOrder.xml");
        StringBuilder stringBuilder = new StringBuilder();
        
        String xPathQuery = "//"+ elementName +"/text()";
        
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            
            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xpath = xFactory.newXPath();
            XPathExpression expr1, expr2;
            
            expr1 = (XPathExpression) xpath.compile(xPathQuery);
            
            Object result = expr1.evaluate(doc, XPathConstants.NODESET);
            
            NodeList results = (NodeList) result;
            
            int count = 0;
            
            for (int i=0; i<results.getLength(); i++)
            {
                stringBuilder.append(results.item(i).getNodeValue() + "\n");
                count++;
            }
            
            stringBuilder.append("\n Found " + count + " occurences of element " + elementName);
            return stringBuilder.toString();        
    }
    
        public String getCustomQuery(String customQuery) throws XPathExpressionException, SAXException, ParserConfigurationException, IOException {
        File xmlFile = new File("productOrder.xml");
        StringBuilder stringBuilder = new StringBuilder();
        
        String xPathQuery = customQuery;
        
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            
            XPathFactory xFactory = XPathFactory.newInstance();
            XPath xpath = xFactory.newXPath();
            XPathExpression expr1, expr2;
            
            expr1 = (XPathExpression) xpath.compile(xPathQuery);
            
            Object result = expr1.evaluate(doc, XPathConstants.NODESET);
            
            NodeList results = (NodeList) result;
            for (int i=0; i<results.getLength(); i++)
            {
                stringBuilder.append(results.item(i).getNodeValue() + "\n");
            }
            
            return stringBuilder.toString();        
    }
    
    
}
