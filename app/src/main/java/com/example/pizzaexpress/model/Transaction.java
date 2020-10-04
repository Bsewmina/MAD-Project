package com.example.pizzaexpress.model;

public class Transaction {
    private String Hno;
    private String street;
    private String city;

    public Transaction() {
    }

    public String getHno() {
        return Hno;
    }

    public void setHno(String hno) {
        Hno = hno;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
