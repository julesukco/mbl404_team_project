package com.jfrankum.week4;

public class Clinic {

    private long id;
    private String title;
    private String address;
    private String city;
    private String state;
    private String position;
    private String name;
    private String phone;
    private String website;
    private String status;
    private String lat;
    private String lon;

    public Clinic() {
    }

    public Clinic(long id, String title, String address, String city, String state,
                  String position, String name, String phone, String website,
                  String status, String lat, String lon) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.city = city;
        this.state = state;
        this.position = position;
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.status = status;
        this.lat = lat;
        this.lon = lon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
