/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.ejb;

import com.airlinereservation.entity.Fares;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vensinga
 */
@Stateless(mappedName="airlinereservation/ejb/fare")

public class FaresSession implements FaresSessionLocal {
    

     @PersistenceContext(name = "AirlineReservationProject-ejbPU")
    
        EntityManager manager;
     
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

   

    @Override
    public Fares getfare( Integer routeId,String type) {
       
        Query q=manager.createNativeQuery("SELECT * FROM FARES WHERE ROUTE_ID=? and PLANE_TYPE=? ",Fares.class);
        q.setParameter(1, routeId);
        q.setParameter(2, type);
        return (Fares)q.getSingleResult();
        
        
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
