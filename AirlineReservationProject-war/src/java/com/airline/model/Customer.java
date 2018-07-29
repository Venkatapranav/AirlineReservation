/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.model;

import com.airlinereservation.ejb.CustomerLocal;
import com.airlinereservation.entity.CustomerCs;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


/**
 *
 * @author vensinga
 */
@Named(value = "customer")
@SessionScoped
public class Customer implements Serializable {

    /**
     * Creates a new instance of Customer
     */
    static int iteratorId=0;
    public Customer() {
    }
    private Integer customerId;
    
    private String customerPh;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    
    private String email;
    
    private String ssn;
   
    private String address;
   
    private String password;
    
    private String name;
    
    @EJB
    CustomerLocal local;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerLocal getLocal() {
        return local;
    }

    public void setLocal(CustomerLocal local) {
        this.local = local;
    }
    public String addCustomer(){
       iteratorId++;
       CustomerCs cust=new CustomerCs();
       cust.setName(name);
       cust.setAddress(address);
       cust.setEmail(email);
       cust.setSsn(ssn);
       cust.setCustomerPh(customerPh);
       cust.setPassword(password);
       cust.setCustomerId(iteratorId);
       local.addCustomer(cust);
       return "success";
   }
    public String verifyCustomer(){
        
        CustomerCs cust=local.verifyCustomer(email);
        if(cust.getPassword().equals(password)){
            return "success";
        }
        
        else return "fail";
    }
    public void logout() throws IOException {
    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
    ec.invalidateSession();
    ec.redirect(ec.getRequestContextPath() + "/welcomePrimefaces.xhtml");
}
}
