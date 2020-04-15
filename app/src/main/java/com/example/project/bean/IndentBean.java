package com.example.project.bean;

public class IndentBean {
    private int ordernumber;
    private String name;
    private String color;
    private int price;
    private int quantity;
    private int total;

    public IndentBean() {
        this.ordernumber = ordernumber;
        this.name = name;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public int getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(int ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
