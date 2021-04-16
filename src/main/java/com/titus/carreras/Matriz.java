/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.carreras;

import java.util.ArrayList;

public class Matriz {
    
    private ArrayList<Activities> activities; 
     
    public Matriz() {
        this.activities = new ArrayList<>();
    }
            
    public ArrayList<Activities> getActivities() {
        return activities;
    }
    
    public void setActivities(ArrayList<Activities> activities) {
        this.activities = activities;
    }    

    @Override
    public String toString() {
        return "Activities{" + "activities=" + activities + '}';
    }    
}