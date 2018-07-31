/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.ejb;

import com.airlinereservation.entity.Flight;
import java.sql.Date;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vensinga
 */
@Stateless(mappedName="airlinereservation/ejb/flight")
public class FlightSession implements FlightLocal {

    
    @PersistenceContext(name = "AirlineReservationProject-ejbPU")
    
        EntityManager manager;
    @Override
    public List<Flight>  getFlights(Date doj, Integer routeId) {
        
        
       //Query q=manager.createNativeQuery("SELECT f FROM Flight f WHERE f.deptTime = :doj "
         //     + "and f.routeid=:routeid", Flight.class);
       
      // q.setParameter("routeid", routeId);
        //q.setParameter("doj", doj);

       // Query q=manager.createNamedQuery( "Flight.findAll",Flight.class);
       Query q1=manager.createNamedQuery("Flight.findByDeptTime",Flight.class);
       
       q1.setParameter("deptTime", doj);
       
       Query q2=manager.createNativeQuery("SELECT * FROM FLIGHT WHERE ROUTEID=?", Flight.class);
       q2.setParameter(1,routeId);
       //return 1;
       
      
       q2.getResultList().retainAll(q1.getResultList());
      // Flight f=(Flight) q2.getSingleResult();
       //System.out.print("Flight Found "+ f.getPlaneid());
       //if(routeId.equals(1))
         //       return f.getFlightId();
          return q2.getResultList();
//else return 0;
// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
