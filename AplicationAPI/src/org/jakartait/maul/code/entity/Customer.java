/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jakartait.maul.code.entity;
import java.io.Serializable;

public class Customer implements Serializable {
    
    private Long customerid;
    private String name;
    private String address;
    private String city;
   
    public Long getCustomerId() {
        return customerid;
    }
    public void setCustomerId(Long customerid) {
        this.customerid = customerid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }public String getAddress() {
        return address;
    }public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }public void setCity(String city) {
        this.city = city;
    }
}
