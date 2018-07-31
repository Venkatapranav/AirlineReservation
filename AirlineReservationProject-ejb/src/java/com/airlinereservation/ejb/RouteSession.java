/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.ejb;

import com.airlinereservation.entity.Route;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vensinga
 */
@Stateless(mappedName="airlinereservation/ejb/route")
public class RouteSession implements RouteLocal {
    
@PersistenceContext(name = "AirlineReservationProject-ejbPU")
    
        EntityManager manager;
    
    
    @Override
    public Integer getRouteId(String source, String destination) {
       
        
       Query q1= manager.createNamedQuery("Route.findByStartingfrom",RouteSession.class);
             //+ "and r.destination=:destination",Route.class);
           q1.setParameter("startingfrom", source);
           
           Query q2=manager.createNamedQuery("Route.findByDestination",RouteSession.class);
           q2.setParameter("destination", destination);
           
           List<Integer>routelList=new ArrayList<>();
           
           q2.getResultList().retainAll(q1.getResultList());
             //System.out.println((Route)q.getSingleResult()+"hjhwjfhje");
             //q.setParameter("destination", destination);
             
           //Query q=manager.createNamedQuery("Route.findAll",Route.class);
           
                //  Integer result=(Integer) q.getSingleResult().hashCode();
                //  return source.indexOf("H");
              
              //  if(source.equals("Hyderabad")&&destination.equals("Banglore"))return 1;
               Route r=(Route) q2.getSingleResult();
              
              //com.airlinereservation.entity.Route r=(com.airlinereservation.entity.Route) q2.getSingleResult();
              return  r.getRouteid();
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
