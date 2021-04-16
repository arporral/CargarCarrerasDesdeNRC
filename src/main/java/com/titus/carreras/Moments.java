/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.carreras;

import java.math.BigInteger;

public class Moments {
    
    private String key;
    private String value;
    private BigInteger timestamp;
    private String app_id;
    private String source;

    public Moments(String key, String value, BigInteger timestamp, String app_id, String source){
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
        this.app_id = app_id;
        this.source = source;
    }
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BigInteger getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }    

    @Override
    public String toString() {
        return "Moments{" + "key=" + key + ", value=" + value + ", timestamp=" + timestamp + ", app_id=" + app_id + ", source=" + source + '}';
    }    
}