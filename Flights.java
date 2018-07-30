/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.model;

import com.airlinereservation.ejb.FlightsModifierLocal;
import com.airlinereservation.entity.Flight;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

/**
 *
 * @author adcheruk
 */
@Named(value = "flight")
@SessionScoped
public class Flights implements Serializable {
    
    
    @EJB
    FlightsModifierLocal local;
    private static int flightId=0;
    private int routeId;
    private int planeId;
    private String deptTime;
    private String arrTime;
    
    

    /**
     * Creates a new instance of Flights
     */
    public Flights() {
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public String getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(String deptTime) {
        this.deptTime = deptTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }
    
    
    public String addflight()
    {
        Flight flights = new Flight();
        flights.setFlightId((long)flightId);
        flights.setRouteId(routeId);
        flights.setPlaneId(planeId);
        try {
        flights.setDeptTime((new SimpleDateFormat("dd/MM/yyyy")).parse(deptTime));
        flights.setArrTime((new SimpleDateFormat("dd/MM/yyyy")).parse(arrTime));
        } catch (ParseException ex) {
           ex.printStackTrace();
        }
        local.addFlight(flights);
        flightId++;
       return "Success";
    }
    
}
