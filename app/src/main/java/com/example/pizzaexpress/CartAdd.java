package com.example.pizzaexpress;

public class CartAdd {
    private String itmName;
    private String price;
    private String size;
    private String qty;
    private String itmNo;

    public CartAdd() {
    }

    public String getItmName() {
        return itmName;
    }

    public void setItmName(String itmName) {
        this.itmName = itmName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getItmNo() {
        return itmNo;
    }

    public void setItmNo(String itmNo) {
        this.itmNo = itmNo;
    }
}