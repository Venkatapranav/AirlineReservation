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
@Table(name = "PLANE")
@NamedQueries({
    @NamedQuery(name = "Plane.findAll", query = "SELECT p FROM Plane p")
    , @NamedQuery(name = "Plane.findByPlaneid", query = "SELECT p FROM Plane p WHERE p.planeid = :planeid")
    , @NamedQuery(name = "Plane.findByType", query = "SELECT p FROM Plane p WHERE p.type = :type")})
public class Plane implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLANEID")
    private Integer planeid;
    @Size(max = 20)
    @Column(name = "TYPE")
    private String type;
    @OneToMany(mappedBy = "planeid")
    private List<Flight> flightList;

    public Plane() {
    }

    public Plane(Integer planeid) {
        this.planeid = planeid;
    }

    public Integer getPlaneid() {
        return planeid;
    }

    public void setPlaneid(Integer planeid) {
        this.planeid = planeid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (planeid != null ? planeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plane)) {
            return false;
        }
        Plane other = (Plane) object;
        if ((this.planeid == null && other.planeid != null) || (this.planeid != null && !this.planeid.equals(other.planeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.airlinereservation.entity.Plane[ planeid=" + planeid + " ]";
    }
    
}
