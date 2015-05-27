/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madatoryassignment;

import java.io.File;
import javax.swing.JTextArea;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Nichlas
 */
public class DomParser {

    public DomParser(String file, JTextArea textArea) {
        try {
            textArea.setText("");
            File myxmlfile = new File(file);
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(myxmlfile);

            textArea.append("Root element :" + doc.getDocumentElement().getNodeName());
            if (doc.hasChildNodes()) {
                printNode(doc.getChildNodes(), textArea);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            textArea.setText(e.getMessage());
        }
    }

    private static void printNode(NodeList nodeList, JTextArea textArea) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node mynode = nodeList.item(i);
            if (mynode.getNodeType() == Node.ELEMENT_NODE) {
                textArea.append("\n");
                textArea.append("Node " + mynode.getNodeName() + " opened");
                textArea.append("Node " + mynode.getNodeName() + " value:");
                textArea.append(" { " + mynode.getTextContent() + " }");
                if (mynode.hasAttributes()) {
                    NamedNodeMap nodeMap = mynode.getAttributes();
                    for (int j = 0; j < nodeMap.getLength(); j++) {
                        Node attnode = nodeMap.item(j);
                        textArea.append("Node " + mynode.getNodeName() + " attributes: ");
                        textArea.append(" [attr name = " + attnode.getNodeName());
                        textArea.append(", attr value = " + attnode.getNodeValue() + "]\n");
                    }
                }
                if (mynode.hasChildNodes()) {
                    printNode(mynode.getChildNodes(), textArea);
                }
            }

        }
    }

}
