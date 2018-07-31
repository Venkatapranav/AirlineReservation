/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vensinga
 */
@Entity
@Table(name = "ROUTE")
@NamedQueries({
    @NamedQuery(name = "Route.findAll", query = "SELECT r FROM Route r")
    , @NamedQuery(name = "Route.findByRouteid", query = "SELECT r FROM Route r WHERE r.routeid = :routeid")
    , @NamedQuery(name = "Route.findByStartingfrom", query = "SELECT r FROM Route r WHERE r.startingfrom = :startingfrom")
    , @NamedQuery(name = "Route.findByDestination", query = "SELECT r FROM Route r WHERE r.destination = :destination")
        ,


    @NamedQuery(name="Route.Idfindbysource",query="SELECT r.routeid FROM Route r WHERE r.startingfrom = :source" )
})
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ROUTEID")
    private Integer routeid;
    @Size(max = 20)
    @Column(name = "STARTINGFROM")
    private String startingfrom;
    @Size(max = 20)
    @Column(name = "DESTINATION")
    private String destination;
    @OneToMany(mappedBy = "routeid")
    private List<Flight> flightList;

    public Route() {
    }

    public Route(Integer routeid) {
        this.routeid = routeid;
    }

    public Integer getRouteid() {
        return routeid;
    }

    public void setRouteid(Integer routeid) {
        this.routeid = routeid;
    }

    public String getStartingfrom() {
        return startingfrom;
    }

    public void setStartingfrom(String startingfrom) {
        this.startingfrom = startingfrom;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (routeid != null ? routeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Route)) {
            return false;
        }
        Route other = (Route) object;
        if ((this.routeid == null && other.routeid != null) || (this.routeid != null && !this.routeid.equals(other.routeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airlinereservation.entity.Route[ routeid=" + routeid + " ]";
    }
    
}
