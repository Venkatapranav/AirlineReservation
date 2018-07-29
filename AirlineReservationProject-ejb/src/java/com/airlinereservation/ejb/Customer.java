/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.ejb;

import com.airlinereservation.entity.CustomerCs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vensinga
 */
@Stateless(mappedName="airlinereservation/ejb/customer")
public class Customer implements CustomerLocal {

    @PersistenceContext(name = "AirlineReservationProject-ejbPU")
    EntityManager manager;
   
    @Override
    public boolean addCustomer(CustomerCs cust) {
        
       manager.merge(cust);
       return true;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public CustomerCs verifyCustomer(String email) {
        
        Query q=manager.createNamedQuery("CustomerCs.findByEmail",CustomerCs.class);
        q.setParameter("email", email);
        
        return (CustomerCs)q.getSingleResult();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
