/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodels;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rasmus
 */
public class Order {
    private List<OrderItem> orderItems;
    private int totalPrice;
    
    public Order() {
        orderItems = new ArrayList<OrderItem>();
        //totalPrice = 0;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for(OrderItem x: orderItems) {
            sb.append(x.toString());
        }
        
        sb.append(" \n Total cost: " + totalPrice + " DKK");
        return sb.toString();
    }
    
}
