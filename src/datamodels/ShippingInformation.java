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
public class ShippingInformation {
    private Customer customer;

    public ShippingInformation() {
        customer = new Customer();
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    @Override
    public String toString() {
        return customer.toString();
    }
}
