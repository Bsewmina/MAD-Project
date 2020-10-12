package com.example.pizzaexpress.model;

public class FeedbackDB {
    private String inquiry;
    private String Title;
    private String fName;
    private String lName;
    private String email;
    private String country;
    private Integer pNo;
    private String msg;

    public FeedbackDB() {
    }

    public String getInquiry() {
        return inquiry;
    }

    public void setInquiry(String inquiry) {
        this.inquiry = inquiry;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getpNo() {
        return pNo;
    }

    public void setpNo(Integer pNo) {
        this.pNo = pNo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
