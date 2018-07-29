/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.airline.model;


 
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;


 
@ManagedBean
public class AutoCompleteView {
     
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
