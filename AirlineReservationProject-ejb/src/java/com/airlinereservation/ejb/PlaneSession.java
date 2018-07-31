/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.ejb;

import com.airlinereservation.entity.Plane;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vensinga
 */
@Stateless(mappedName="airlinereservation/ejb/plane")
public class PlaneSession implements PlaneSessionLocal {

    @PersistenceContext(name = "AirlineReservationProject-ejbPU")
            
    EntityManager manager;
    
    @Override
    public Plane getPlane(Integer planeId) {
        
        Query q=manager.createNamedQuery("Plane.findByPlaneid",Plane.class);
        q.setParameter("planeid", planeId);
        
        Plane p=(Plane)q.getSingleResult();
        
        return p;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
