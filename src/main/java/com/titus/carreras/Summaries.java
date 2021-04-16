/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.carreras;

public class Summaries {

    private String metric;
    private String summary;
    private String asource;
    private String app_id;
    private double value;

    public Summaries(String metric, String summary, String asource, String app_id, double value){
        this.metric = metric;
        this.summary = summary;
        this.asource = asource;
        this.app_id = app_id;
        this.value = value;
    }
    
    public String getMetric() {
        return metric;
    }

    public void setMetric(String metric) {
        this.metric = metric;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAsource() {
        return asource;
    }

    public void setAsource(String asource) {
        this.asource = asource;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Summaries{" + "metric=" + metric + ", summary=" + summary + ", asource=" + asource + ", app_id=" + app_id + ", value=" + value + '}';
    }    
}