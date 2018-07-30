/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.ejb;

import com.airlinereservation.entity.Flight;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adcheruk
 */
@Stateless(mappedName = "airlinereservation/ejb/flightModifier")
public class FlightsModifier implements FlightsModifierLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     @PersistenceContext(name="SampleEE-ejbPU")
    EntityManager entityManager;
    public boolean addFlight(Flight flight)
    {
        entityManager.persist(flight);
        return true;
    }
}
