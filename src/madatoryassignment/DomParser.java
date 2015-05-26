/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madatoryassignment;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Nichlas
 */
public class DomParser {
    public DomParser(){
    try {
            File myxmlfile = new File("fruitTest.xml");
            // File myfile = new File("drivers.xml");

            // Use DocumentBuilderFactory instance to create a DocumentBuilder instance - it will be the DOM parser
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            // Parse an XML file using the Java DOM parser and get a Document object to represent the XML document
            Document doc = builder.parse(myxmlfile);

            // Now the document is ready for traversing
            // Start with getDocumentElement() that returns the root element
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            // Accessing the child elements, if any
            if (doc.hasChildNodes()) {
                printNode(doc.getChildNodes());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printNode(NodeList nodeList) {
    // a loop: one iteration per node
        // most methods come from org.w3c.dom package (see http://docs.oracle.com/javase/7/docs/api/org/w3c/dom/package-summary.html)
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node mynode = nodeList.item(i);
            if (mynode.getNodeType() == Node.ELEMENT_NODE) {
                // get the new node
                System.out.print("\n");
                System.out.println("Node " + mynode.getNodeName() + " opened");
                System.out.print("Node " + mynode.getNodeName() + " value:");
                System.out.println(" { " + mynode.getTextContent() + " }");

                // Accessing the attributes of an element, if any
                if (mynode.hasAttributes()) {
                    // get attributes of the node: names and values
                    NamedNodeMap nodeMap = mynode.getAttributes();

                    for (int j = 0; j < nodeMap.getLength(); j++) {
                        Node attnode = nodeMap.item(j);
                        System.out.print("Node " + mynode.getNodeName() + " attributes: ");
                        System.out.print(" [attr name = " + attnode.getNodeName());
                        System.out.print(", attr value = " + attnode.getNodeValue() + "]\n");
                    }
                }

                if (mynode.hasChildNodes()) {
                    // Recursion: same procedure for the new children
                    printNode(mynode.getChildNodes());
                }
                System.out.println("Node " + mynode.getNodeName() + " closed");
            }

        }
    }
    
}
