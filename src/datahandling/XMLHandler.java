/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datahandling;
//import org.w3c.dom.Document;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Rasmus
 */
public class XMLHandler {
    
    public void addNewOrderItem(String productName, String price) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        File xmlFile = new File("src/XML/productOrder.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        Element root = document.getDocumentElement();
        NodeList nodes = root.getElementsByTagName("Order");
        
        Node childNode = document.createElement("Item");
        Node productNode = document.createElement("ns1:Product");
        productNode.appendChild(document.createTextNode(productName));
        Node priceNode = document.createElement("ns1:Price");
        priceNode.appendChild(document.createTextNode(price));
        childNode.appendChild(productNode);
        childNode.appendChild(priceNode);
       // nodes.item(0).appendChild(childNode);
        root.getElementsByTagName("ns1:Order").item(0).appendChild(childNode);
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        File outputFile = new File("src/XML/productOrderOutput.xml");
        StreamResult result = new StreamResult(outputFile);
        transformer.transform(source, result);
    }
    
}
