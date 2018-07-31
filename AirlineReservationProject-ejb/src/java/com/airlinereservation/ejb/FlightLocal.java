/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.ejb;

import com.airlinereservation.entity.Flight;
import java.sql.Date;

import java.util.List;

import javax.ejb.Local;

/**
 *
 * @author vensinga
 */
@Local
public interface FlightLocal {
    public List<Flight> getFlights(Date doj,Integer routeId);
}
