/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.model;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author vensinga
 */
@Named(value = "flightDisplay")
@SessionScoped
public class FlightDisplay implements Serializable {

    Integer flightId;
    String type;
    Double economyFare;
    Double businessFare;
    Date deptTime;
    Date arrTime;

    public Integer getFlightId() {
        return flightId;
    }

    @Override
    public String toString() {
        return "FlightDisplay{" + "flightId=" + flightId + ", type=" + type + ", economyFare=" + economyFare + ", businessFare=" + businessFare + ", deptTime=" + deptTime + ", arrTime=" + arrTime + '}';
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getEconomyFare() {
        return economyFare;
    }

    public void setEconomyFare(Double economyFare) {
        this.economyFare = economyFare;
    }

    public Double getBusinessFare() {
        return businessFare;
    }

    public void setBusinessFare(Double businessFare) {
        this.businessFare = businessFare;
    }

    public Date getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(Date deptTime) {
        this.deptTime = deptTime;
    }

    public Date getArrTime() {
        return arrTime;
    }

    public void setArrTime(Date arrTime) {
        this.arrTime = arrTime;
    }
    
    /**
     * Creates a new instance of FlightDisplay
     */
    public FlightDisplay() {
    }
    
}
