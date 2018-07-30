/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.ejb;

import com.airlinereservation.entity.Flight;
import javax.ejb.Local;

/**
 *
 * @author adcheruk
 */
@Local
public interface FlightsModifierLocal {
    public boolean addFlight(Flight flight);
}
