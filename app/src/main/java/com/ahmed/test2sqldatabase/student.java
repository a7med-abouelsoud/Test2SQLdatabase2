package com.ahmed.test2sqldatabase;

import android.media.Rating;

public class student {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private float rate;
    private Integer image;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public student(Integer id, String name, String address, String phone, float rate, Integer image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone= phone;
        this.rate = rate;
        this.image = image;
    }

    public student(String name, String address, String phone,float rate, Integer image) {
        this.name = name;
        this.address = address;
        this.phone=phone;
        this.rate = rate;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float evaluation) {
        this.rate = evaluation;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }
}
