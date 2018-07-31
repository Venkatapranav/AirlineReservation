/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airlinereservation.ejb;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vensinga
 */
@Local
public interface RouteLocal {
    public Integer getRouteId(String source, String destination);
}
