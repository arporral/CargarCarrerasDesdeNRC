/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.carreras;

public class Tags {

    private String emotion;
    private String location;
    private String note;
    private String shoes;
    private String terrain;
    private String weather;

    public Tags(String emotion, String location, String note, String shoes, String terrain, String weather) {
        this.emotion = emotion;
        this.location = location;
        this.note = note;
        this.shoes = shoes;
        this.terrain = terrain;
        this.weather = weather;
    }
    
    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }

    public String getTerrain() {
        return terrain;
    }

    public void setTerrain(String terrain) {
        this.terrain = terrain;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Tags{" + "emotion=" + emotion + ", location=" + location + ", note=" + note + ", shoes=" + shoes + ", terrain=" + terrain + ", weather=" + weather + '}';
    }    
}