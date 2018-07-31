/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.model;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author vensinga
 */
@Named(value = "flight")
@SessionScoped
public class Flight implements Serializable {

    /**
     * Creates a new instance of Flight
     */
    public Flight() {
    }
    
}
