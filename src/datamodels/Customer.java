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
public class Customer {
    private String firstName;
    private String lastName;
    private Address address;
    
    public Customer() {
        address = new Address();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "\n Name: " + firstName + " " + lastName + " \n Address: \n " + address.getStreet() + " \n " + address.getPostalCode() + " " + address.getCity() + " \n " + address.getCountry();
    }
}
