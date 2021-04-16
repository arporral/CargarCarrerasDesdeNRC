/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.carreras;

import java.util.ArrayList;

public class Activities {
    
    private ArrayList<CarreirasNRC> carreirasnrc; 
     
    public Activities() {
        this.carreirasnrc = new ArrayList();
    }
            
    public ArrayList<CarreirasNRC> getCarreirasnrc() {
        return carreirasnrc;
    }
    
    public void setCarreirasnrc(ArrayList<CarreirasNRC> carreirasnrc) {
        this.carreirasnrc = carreirasnrc;
    }    

    @Override
    public String toString() {
        return "Activities{" + "carreirasnrc=" + carreirasnrc + '}';
    }    
}