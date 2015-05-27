/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datahandling;

/**
 *
 * @author Rasmus
 */
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import datamodels.*;

// Create a subclass of DefaultHandler and override certain inherited methods in this subclass
public class XMLSAXHandler extends DefaultHandler {

    private PurchaseOrder purchaseOrder = null;
    private OrderItem orderItem = null;

    boolean bShippingInformation = false;
    boolean bOrder = false;

    boolean bFirstName = false;
    boolean bLastName = false;

    boolean bStreet = false;
    boolean bPostalCode = false;
    boolean bCity = false;
    boolean bCountry = false;

    boolean bProductName = false;
    boolean bPrice = false;

    boolean bTotalPrice = false;

    private List<OrderItem> orderItemsList = null;
    private List<PurchaseOrder> purchaseOrderList;

    public List<OrderItem> getOrderItemsList() {
        return purchaseOrder.getOrder().getOrderItems();
    }
    
    public List<PurchaseOrder> getPurchaseOrderList() {
        return purchaseOrderList;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    @Override
    public void startElement(String uri, String localName, String nodeName, Attributes attributes) throws SAXException {
        if (nodeName.equalsIgnoreCase("ns1:PurchaseOrder")) {
            purchaseOrder = new PurchaseOrder();

            // initialize list
            if (orderItemsList == null) {
                orderItemsList = new ArrayList<>();
            }
            if(purchaseOrderList == null) {
                purchaseOrderList = new ArrayList<>();
            }
        }
        if (nodeName.equalsIgnoreCase("ns1:Item")) {
            orderItem = new OrderItem();
        }

        // see what you have read
        if (nodeName.equalsIgnoreCase("ns1:ShippingInformation")) {
            bShippingInformation = true;
        } else if (nodeName.equalsIgnoreCase("ns1:Order")) {
            bOrder = true;
        } else if (nodeName.equalsIgnoreCase("ns1:Street")) {
            bStreet = true;
        } else if (nodeName.equalsIgnoreCase("ns1:PostalCode")) {
            bPostalCode = true;
        } else if (nodeName.equalsIgnoreCase("ns1:City")) {
            bCity = true;
        } else if (nodeName.equalsIgnoreCase("ns1:Country")) {
            bCountry = true;
        } else if (nodeName.equalsIgnoreCase("ns1:FirstName")) {
            bFirstName = true;
        } else if (nodeName.equalsIgnoreCase("ns1:LastName")) {
            bLastName = true;
        } else if (nodeName.equalsIgnoreCase("ns1:Product")) {
            bProductName = true;
        } else if (nodeName.equalsIgnoreCase("ns1:Price")) {
            bPrice = true;
        } else if (nodeName.equalsIgnoreCase("ns1:TotalPrice")) {
            bTotalPrice = true;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bProductName) {
            orderItem.setProductName(new String(ch, start, length));
            bProductName = false;
        }
        if (bPrice) {
            orderItem.setPrice(Integer.parseInt(new String(ch, start, length)));
            bPrice = false;
        } else if (bStreet) {
            purchaseOrder.getShippingInformation().getCustomer().getAddress().setStreet(new String(ch, start, length));
            bStreet = false;
        } else if (bPostalCode) {
            purchaseOrder.getShippingInformation().getCustomer().getAddress().setPostalCode(new String(ch, start, length));
            bPostalCode = false;
        } else if (bCity) {
            purchaseOrder.getShippingInformation().getCustomer().getAddress().setCity(new String(ch, start, length));
            bCity = false;
        } else if (bCountry) {
            purchaseOrder.getShippingInformation().getCustomer().getAddress().setCountry(new String(ch, start, length));
            bCountry = false;
        } else if (bFirstName) {
            purchaseOrder.getShippingInformation().getCustomer().setFirstName(new String(ch, start, length));
            bFirstName = false;
        } else if (bLastName) {
            purchaseOrder.getShippingInformation().getCustomer().setLastName(new String(ch, start, length));
            bLastName = false;
        } else if (bTotalPrice) {
            purchaseOrder.getOrder().setTotalPrice(Integer.parseInt(new String(ch, start, length)));
            bTotalPrice = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String nodeName) throws SAXException {
        if (nodeName.equalsIgnoreCase("ns1:Item")) {
            //add Employee object to list
            purchaseOrder.getOrder().getOrderItems().add(orderItem);
        }
        if (nodeName.equalsIgnoreCase("ns1:PurchaseOrder")) {
            purchaseOrderList.add(purchaseOrder);
        }/*
         if (nodeName.equalsIgnoreCase("ShippingInformation"))
         {
         purchaseOrder.setShippingInformation(shippingInformation);
         }
         if (nodeName.equalsIgnoreCase("Order"))
         {
         purchaseOrder.setOrder(order);
         }
         if (nodeName.equalsIgnoreCase("Customer"))
         {
         shippingInformation.setCustomer(customer);
         }
         if (nodeName.equalsIgnoreCase("Address"))
         {
         customer.setAddress(address);
         }*/

    }
}
