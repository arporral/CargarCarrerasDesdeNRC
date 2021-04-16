/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.carreras;

import java.math.BigInteger;
import java.util.ArrayList;

public class Activities {
    
    private String id;
    private String type;
    private String app_id;
    private BigInteger start_epoch_ms;
    private BigInteger end_epoch_ms;
    private BigInteger last_modified;
    private BigInteger active_duration_ms;
    private boolean session;  
    private boolean delete_indicator;
    private ArrayList<Summaries> summaries;    
    private ArrayList sources;
    private Tags tags;
    private ArrayList change_tokens;
    private ArrayList metric_types;
    private ArrayList metrics;
    private ArrayList<Moments> moments;
    
    public Activities(String id, String type, String app_id, BigInteger start_epoch_ms, BigInteger end_epoch_ms, BigInteger last_modified, BigInteger active_duration_ms, 
            boolean session, boolean delete_indicator, Tags tags) {
        this.id = id;
        this.type = type;
        this.app_id = app_id;
        this.start_epoch_ms = start_epoch_ms;
        this.end_epoch_ms = end_epoch_ms;
        this.last_modified = last_modified;
        this.active_duration_ms = active_duration_ms;
        this.session = session;  
        this.delete_indicator = delete_indicator;
        this.summaries = new ArrayList<>();    
        this.sources = new ArrayList<>();
        this.tags = tags;
        this.change_tokens = new ArrayList<>();
        this.metric_types = new ArrayList<>();
        this.metrics = new ArrayList<>();
        this.moments = new ArrayList<>();
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public BigInteger getStart_epoch_ms() {
        return start_epoch_ms;
    }

    public void setStart_epoch_ms(BigInteger start_epoch_ms) {
        this.start_epoch_ms = start_epoch_ms;
    }

    public BigInteger getEnd_epoch_ms() {
        return end_epoch_ms;
    }

    public void setEnd_epoch_ms(BigInteger end_epoch_ms) {
        this.end_epoch_ms = end_epoch_ms;
    }

    public BigInteger getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(BigInteger last_modified) {
        this.last_modified = last_modified;
    }

    public BigInteger getActive_duration_ms() {
        return active_duration_ms;
    }

    public void setActive_duration_ms(BigInteger active_duration_ms) {
        this.active_duration_ms = active_duration_ms;
    }

    public boolean isSession() {
        return session;
    }

    public void setSession(boolean session) {
        this.session = session;
    }

    public boolean isDelete_indicator() {
        return delete_indicator;
    }

    public void setDelete_indicator(boolean delete_indicator) {
        this.delete_indicator = delete_indicator;
    }

    public ArrayList<Summaries> getSummaries() {
        return summaries;
    }

    public void setSummaries(ArrayList<Summaries> summaries) {
        this.summaries = summaries;
    }

    public ArrayList getSources() {
        return sources;
    }

    public void setSources(ArrayList sources) {
        this.sources = sources;
    }
    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public ArrayList getChange_tokens() {
        return change_tokens;
    }

    public void setChange_tokens(ArrayList change_tokens) {
        this.change_tokens = change_tokens;
    }

    public ArrayList getMetric_types() {
        return metric_types;
    }

    public void setMetric_types(ArrayList metric_types) {
        this.metric_types = metric_types;
    }

    public ArrayList getMetrics() {
        return metrics;
    }

    public void setMetrics(ArrayList metrics) {
        this.metrics = metrics;
    }

    public ArrayList<Moments> getMoments() {
        return moments;
    }

    public void setMoments(ArrayList<Moments> moments) {
        this.moments = moments;
    }   

    @Override
    public String toString() {
        return "Activities{" + "id=" + id + ", type=" + type + ", app_id=" + app_id + ", start_epoch_ms=" + start_epoch_ms + ", end_epoch_ms=" + end_epoch_ms
                + ", last_modified=" + last_modified + ", active_duration_ms=" + active_duration_ms + ", session=" + session + ", delete_indicator=" + delete_indicator
                + ", summaries=" + summaries + ", sources=" + sources + ", tags=" + tags + ", change_tokens=" + change_tokens + ", metric_types=" + metric_types + ", metrics="
                + metrics + ", moments=" + moments + '}';
    }
}