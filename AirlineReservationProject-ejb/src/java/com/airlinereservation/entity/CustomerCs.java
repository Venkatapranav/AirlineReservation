/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vensinga
 */
@Entity
@Table(name = "CUSTOMER_CS")
@NamedQueries({
    @NamedQuery(name = "CustomerCs.findAll", query = "SELECT c FROM CustomerCs c")
    , @NamedQuery(name = "CustomerCs.findByCustomerId", query = "SELECT c FROM CustomerCs c WHERE c.customerId = :customerId")
    , @NamedQuery(name = "CustomerCs.findByCustomerPh", query = "SELECT c FROM CustomerCs c WHERE c.customerPh = :customerPh")
    , @NamedQuery(name = "CustomerCs.findByEmail", query = "SELECT c FROM CustomerCs c WHERE c.email = :email")
    , @NamedQuery(name = "CustomerCs.findBySsn", query = "SELECT c FROM CustomerCs c WHERE c.ssn = :ssn")
    , @NamedQuery(name = "CustomerCs.findByAddress", query = "SELECT c FROM CustomerCs c WHERE c.address = :address")
    , @NamedQuery(name = "CustomerCs.findByPassword", query = "SELECT c FROM CustomerCs c WHERE c.password = :password")
    , @NamedQuery(name = "CustomerCs.findByName", query = "SELECT c FROM CustomerCs c WHERE c.name = :name")})
public class CustomerCs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @Size(max = 12)
    @Column(name = "CUSTOMER_PH")
    private String customerPh;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 20)
    @Column(name = "SSN")
    private String ssn;
    @Size(max = 50)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 20)
    @Column(name = "NAME")
    private String name;

    public CustomerCs() {
    }

    public CustomerCs(Integer customerId) {
        this.customerId = customerId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerCs)) {
            return false;
        }
        CustomerCs other = (CustomerCs) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airlinereservation.entity.CustomerCs[ customerId=" + customerId + " ]";
    }
    
}
