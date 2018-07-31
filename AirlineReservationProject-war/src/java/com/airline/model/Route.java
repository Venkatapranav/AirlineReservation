/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.model;

import com.airlinereservation.ejb.FaresSessionLocal;
import com.airlinereservation.ejb.FlightLocal;
import com.airlinereservation.ejb.PlaneSessionLocal;
import com.airlinereservation.ejb.RouteLocal;
import com.airlinereservation.entity.Fares;
import com.airlinereservation.entity.Flight;
import com.airlinereservation.entity.Plane;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.ejb.EJB;
import javax.persistence.Column;
import javax.validation.constraints.Size;

/**
 *
 * @author vensinga
 */
@Named(value = "route")
@SessionScoped
public class Route implements Serializable {

    /**
     * Creates a new instance of Route
     */
    public Route() {
    }
    @EJB
    RouteLocal localRoute;
    
    @EJB
    FlightLocal localFlight;
    
    @EJB
    PlaneSessionLocal localPlane;
    
    @EJB
    FaresSessionLocal localFare;
    
    private Integer routeId;
  
    private String startingFrom;
   
    private String destinaion;
    
    private Date date;

    public PlaneSessionLocal getLocalPlane() {
        return localPlane;
    }

    public void setLocalPlane(PlaneSessionLocal localPlane) {
        this.localPlane = localPlane;
    }

    public FaresSessionLocal getLocalFare() {
        return localFare;
    }

    public void setLocalFare(FaresSessionLocal localFare) {
        this.localFare = localFare;
    }

    public RouteLocal getLocalRoute() {
        return localRoute;
    }

    public void setLocalRoute(RouteLocal localRoute) {
        this.localRoute = localRoute;
    }

    public FlightLocal getLocalFlight() {
        return localFlight;
    }

    public void setLocalFlight(FlightLocal localFlight) {
        this.localFlight = localFlight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }

    public String getStartingFrom() {
        return startingFrom;
    }

    public void setStartingFrom(String startingFrom) {
        this.startingFrom = startingFrom;
    }

    public String getDestinaion() {
        return destinaion;
    }

    public void setDestinaion(String destinaion) {
        this.destinaion = destinaion;
    }
    
    public String getRouteID(){
        
        
        List<FlightDisplay> flightDisplay;
        flightDisplay = new ArrayList<>();
       Integer rId= localRoute.getRouteId(startingFrom, destinaion);
       java.sql.Date sqlDate = new java.sql.Date(date.getTime());
      
      List<Flight> flight=localFlight.getFlights(sqlDate, rId);
      // planeType;
      FlightDisplay fd=new FlightDisplay();
      
     flight.forEach((Flight f) -> {
          Double Efare, Bfare;
           Plane    p=f.getPlaneid();
           String   planeType=p.getType();
          
         Fares fare=localFare.getfare(rId,planeType);
         Efare=fare.getBusinessFare();
         Bfare=fare.getEconomyFare();
     
           fd.setType(planeType);
           fd.setFlightId(f.getFlightId());
           fd.setBusinessFare(Bfare);
           fd.setEconomyFare(Efare);
           fd.setArrTime( f.getArrTime());
           fd.setDeptTime( f.getDeptTime());
           
           flightDisplay.add(fd);
           
        });
      
     System.out.println(flightDisplay.get(0).toString());
      //Plane p=localPlane.getPlane(flight.getPlaneid());
      
      
      
      
      
      
      
      
      
      
      return "success";
       
    }
    private String txt1;

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1;
    }
    
     
    
    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add("city" + i);
        }
         
        return results;
    }
}
