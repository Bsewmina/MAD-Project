package com.example.pizzaexpress;

public class User {

    String email;
    String password;
    String name;
    String phoneNo;
    String address;
    String points;

    public   User(){
    }

    public User(String email, String password, String name, String phoneNo, String address, String points) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNo = phoneNo;
        this.address = address;
        this.points = points;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public void setAddress(String points) {
        this.address = address;
    }

}


