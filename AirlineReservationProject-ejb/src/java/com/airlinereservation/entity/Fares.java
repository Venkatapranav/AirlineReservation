/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vensinga
 */
@Entity
@Table(name = "FARES")
@NamedQueries({
    @NamedQuery(name = "Fares.findAll", query = "SELECT f FROM Fares f")
    , @NamedQuery(name = "Fares.findByRouteId", query = "SELECT f FROM Fares f WHERE f.routeId = :routeId")
    , @NamedQuery(name = "Fares.findByEconomyFare", query = "SELECT f FROM Fares f WHERE f.economyFare = :economyFare")
    , @NamedQuery(name = "Fares.findByBusinessFare", query = "SELECT f FROM Fares f WHERE f.businessFare = :businessFare")
    , @NamedQuery(name = "Fares.findByPlaneType", query = "SELECT f FROM Fares f WHERE f.planeType = :planeType")})
public class Fares implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROUTE_ID")
    private Integer routeId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ECONOMY_FARE")
    private Double economyFare;
    @Column(name = "BUSINESS_FARE")
    private Double businessFare;
    @Size(max = 20)
    @Column(name = "PLANE_TYPE")
    private String planeType;

    public Fares() {
    }

    public Fares(Integer routeId) {
        this.routeId = routeId;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
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

    public String getPlaneType() {
        return planeType;
    }

    public void setPlaneType(String planeType) {
        this.planeType = planeType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeId != null ? routeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fares)) {
            return false;
        }
        Fares other = (Fares) object;
        if ((this.routeId == null && other.routeId != null) || (this.routeId != null && !this.routeId.equals(other.routeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airlinereservation.entity.Fares[ routeId=" + routeId + " ]";
    }
    
}
