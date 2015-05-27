/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;

/**
 *
 * @author Rasmus
 */
public class PurchaseOrder {
    private ShippingInformation shippingInformation;
    private Order order;
    
    public PurchaseOrder() {
        shippingInformation = new ShippingInformation();
        order = new Order();
    }

    public ShippingInformation getShippingInformation() {
        return shippingInformation;
    }

    public void setShippingInformation(ShippingInformation shippingInformation) {
        this.shippingInformation = shippingInformation;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    @Override
    public String toString(){
        return "Buyer: " + shippingInformation.toString() + "\n\n Purchase order: " + order.toString();
    }
    
}
