/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author vensinga
 */
@Entity
@Table(name = "FLIGHT")
@NamedQueries({
    @NamedQuery(name = "Flight.findAll", query = "SELECT f FROM Flight f")
    , @NamedQuery(name = "Flight.findByFlightId", query = "SELECT f FROM Flight f WHERE f.flightId = :flightId")
    , @NamedQuery(name = "Flight.findByArrTime", query = "SELECT f FROM Flight f WHERE f.arrTime = :arrTime")
    , @NamedQuery(name = "Flight.findByDeptTime", query = "SELECT f FROM Flight f WHERE f.deptTime = :deptTime")})
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "FLIGHT_ID")
    private Integer flightId;
    @Column(name = "ARR_TIME")
    @Temporal(TemporalType.DATE)
    private Date arrTime;
    @Column(name = "DEPT_TIME")
    @Temporal(TemporalType.DATE)
    private Date deptTime;
    @JoinColumn(name = "PLANEID", referencedColumnName = "PLANEID")
    @ManyToOne
    private Plane planeid;
    @JoinColumn(name = "ROUTEID", referencedColumnName = "ROUTEID")
    @ManyToOne
    private Route routeid;

    public Flight() {
    }

    public Flight(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Date getArrTime() {
        return arrTime;
    }

    public void setArrTime(Date arrTime) {
        this.arrTime = arrTime;
    }

    public Date getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(Date deptTime) {
        this.deptTime = deptTime;
    }

    public Plane getPlaneid() {
        return planeid;
    }

    public void setPlaneid(Plane planeid) {
        this.planeid = planeid;
    }

    public Route getRouteid() {
        return routeid;
    }

    public void setRouteid(Route routeid) {
        this.routeid = routeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flightId != null ? flightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) object;
        if ((this.flightId == null && other.flightId != null) || (this.flightId != null && !this.flightId.equals(other.flightId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airlinereservation.entity.Flight[ flightId=" + flightId + " ]";
    }
    
}
