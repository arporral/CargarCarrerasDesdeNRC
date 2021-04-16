/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.carreras;

import java.util.ArrayList;

public class CarreirasNRC {
    
    private String id;
    private String type;
    private String app_id;
    private int start_epoch_ms;
    private int end_epoch_ms;
    private int last_modified;
    private int active_duration_ms;
    private boolean session;  
    private boolean delete_indicator;
    private ArrayList<Summaries> summaries;    
    private String sources;
    private ArrayList<Tags> tags;
    private String change_tokens;
    private String metric_types;
    private String metrics;
    private ArrayList<Moments> moments;
    
    public CarreirasNRC(String id, String type, String app_id, int start_epoch_ms, int end_epoch_ms, int last_modified, int active_duration_ms, boolean session,
    boolean delete_indicator, String sources, String change_tokens, String metric_types, String metrics) {
        this.id = id;
        this.type = type;
        this.app_id = app_id;
        this.start_epoch_ms = start_epoch_ms;
        this.end_epoch_ms = end_epoch_ms;
        this.last_modified = last_modified;
        this.active_duration_ms = active_duration_ms;
        this.session = session;  
        this.delete_indicator = delete_indicator;
        this.summaries = new ArrayList();    
        this.sources = sources;
        this.tags = new ArrayList();
        this.change_tokens = change_tokens;
        this.metric_types = metric_types;
        this.metrics = metrics;
        this.moments = new ArrayList();
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

    public int getStart_epoch_ms() {
        return start_epoch_ms;
    }

    public void setStart_epoch_ms(int start_epoch_ms) {
        this.start_epoch_ms = start_epoch_ms;
    }

    public int getEnd_epoch_ms() {
        return end_epoch_ms;
    }

    public void setEnd_epoch_ms(int end_epoch_ms) {
        this.end_epoch_ms = end_epoch_ms;
    }

    public int getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(int last_modified) {
        this.last_modified = last_modified;
    }

    public int getActive_duration_ms() {
        return active_duration_ms;
    }

    public void setActive_duration_ms(int active_duration_ms) {
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

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public ArrayList<Tags> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tags> tags) {
        this.tags = tags;
    }

    public String getChange_tokens() {
        return change_tokens;
    }

    public void setChange_tokens(String change_tokens) {
        this.change_tokens = change_tokens;
    }

    public String getMetric_types() {
        return metric_types;
    }

    public void setMetric_types(String metric_types) {
        this.metric_types = metric_types;
    }

    public String getMetrics() {
        return metrics;
    }

    public void setMetrics(String metrics) {
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
        return "CarreirasNRC{" + "id=" + id + ", type=" + type + ", app_id=" + app_id + ", start_epoch_ms=" + start_epoch_ms + ", end_epoch_ms=" + end_epoch_ms
                + ", last_modified=" + last_modified + ", active_duration_ms=" + active_duration_ms + ", session=" + session + ", delete_indicator=" + delete_indicator
                + ", summaries=" + summaries + ", sources=" + sources + ", tags=" + tags + ", change_tokens=" + change_tokens + ", metric_types=" + metric_types + ", metrics="
                + metrics + ", moments=" + moments + '}';
    }
}