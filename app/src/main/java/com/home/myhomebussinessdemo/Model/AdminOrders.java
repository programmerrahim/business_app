package com.home.myhomebussinessdemo.Model;

public class AdminOrders {
    private String name,phone,address,citty,state,date,time,totolAmount;

    public AdminOrders() {
    }

    public AdminOrders(String name, String phone, String address, String citty, String state, String date, String time, String totolAmount) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.citty = citty;
        this.state = state;
        this.date = date;
        this.time = time;
        this.totolAmount = totolAmount;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCitty() {
        return citty;
    }

    public void setCitty(String citty) {
        this.citty = citty;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTotolAmount() {
        return totolAmount;
    }

    public void setTotolAmount(String totolAmount) {
        this.totolAmount = totolAmount;
    }
}
