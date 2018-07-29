/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.model;

import com.airlinereservation.ejb.CustomerLocal;
import com.airlinereservation.entity.CustomerCs;
import java.io.Serializable;
import javax.ejb.EJB;

import javax.inject.Named;

import javax.faces.bean.SessionScoped;


/**
 *
 * @author vensinga
 */
@Named(value = "customerWizard")
@SessionScoped
public class CustomerWizard implements Serializable{

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public CustomerLocal getLocal() {
        return local;
    }

   
    /**
     * Creates a new instance of CustomerWizard
     */
    public CustomerWizard() {
    }
    
    @EJB
    CustomerLocal local;
   
    private boolean skip;
    private Integer customerId;
    
    private String customerPh;

    private String email;
   
    private String ssn;
    
    private String address;
    
    private String password;
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public void setLocal(CustomerLocal local) {
        this.local = local;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerPh() {
        return customerPh;
    }

    public void setCustomerPh(String customerPh) {
        this.customerPh = customerPh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
   public String addCustomer(){
       
       CustomerCs cust=new CustomerCs();
       cust.setName(name);
       cust.setAddress(address);
       cust.setEmail(email);
       cust.setSsn(ssn);
       cust.setCustomerPh(customerPh);
       cust.setPassword(password);
       cust.setCustomerId(1);
       local.addCustomer(cust);
       return "success";
   }
    public void save() {        
        
        addCustomer();
    }
   
    

}

