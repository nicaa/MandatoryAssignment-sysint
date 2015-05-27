/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datahandling;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;
import org.xml.sax.SAXException;

/**
 *
 * @author Rasmus
 */
public class ElementTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException, XPathExpressionException {
        XMLHandler handler = new XMLHandler();
        //handler.addNewOrderItem("Pear", "25");
        //handler.removeOrderItem("Apple");
        handler.updateOrderItem("Banana", "125");
    }
}
