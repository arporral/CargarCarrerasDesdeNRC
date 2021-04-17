/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titus.carreras;

import com.google.gson.annotations.SerializedName;

public class Tags {

    private String emotion;
    private String location;
    private String note;
    private String shoes;
    private String temperature;
    private String terrain;
    private String weather;
    @SerializedName("com.nike.name")
    private String comNikeName;
    @SerializedName("com.nike.running.goaltype")
    private String comNikeRunningGoaltype;
    @SerializedName("com.nike.temperature")
    private String comNikeTemperature;
    @SerializedName("com.nike.weather")
    private String comNikeWeather;
    private String shoe_id;

    public Tags(String emotion, String location, String note, String shoes, String temperature, String terrain, String weather, String comNikeName, String comNikeRunningGoaltype,
            String comNikeTemperature, String comNikeWeather, String shoe_id) {
        this.emotion = emotion;
        this.location = location;
        this.note = note;
        this.shoes = shoes;
        this.temperature = temperature;
        this.terrain = terrain;
        this.weather = weather;
        this.comNikeName = comNikeName;
        this.comNikeRunningGoaltype = comNikeRunningGoaltype;
        this.comNikeTemperature = comNikeTemperature;
        this.comNikeWeather = comNikeWeather;
        this.shoe_id = shoe_id;
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

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
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

    public String getComNikeName() {
        return comNikeName;
    }

    public void setComNikeName(String comNikeName) {
        this.comNikeName = comNikeName;
    }

    public String getComNikeRunningGoaltype() {
        return comNikeRunningGoaltype;
    }

    public void setComNikeRunningGoaltype(String comNikeRunningGoaltype) {
        this.comNikeRunningGoaltype = comNikeRunningGoaltype;
    }

    public String getComNikeTemperature() {
        return comNikeTemperature;
    }

    public void setComNikeTemperature(String comNikeTemperature) {
        this.comNikeTemperature = comNikeTemperature;
    }
    
    public String getComNikeWeather() {
        return comNikeWeather;
    }

    public void setComNikeWeather(String comNikeWeather) {
        this.comNikeWeather = comNikeWeather;
    }
    
    public String getShoe_id() {
        return shoe_id;
    }

    public void setShoe_id(String shoe_id) {
        this.shoe_id = shoe_id;
    }

    @Override
    public String toString() {
        return "Tags{" + "emotion=" + emotion + ", location=" + location + ", note=" + note + ", shoes=" + shoes + ", temperature=" + temperature + ", terrain=" + 
                terrain + ", weather=" + weather + ", comNikeName=" + comNikeName + ", comNikeRunningGoaltype=" + comNikeRunningGoaltype + ", comNikeTemperature=" + 
                comNikeTemperature + ", comNikeWeather=" + comNikeWeather + ", shoe_id=" + shoe_id + '}';
    }
}