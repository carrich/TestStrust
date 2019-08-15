package com.exam.entity;

import javax.persistence.*;

@Entity
@Table(name = "orderDetails")
public class OrderDetail {

    @Id
    private long id;
    private String name;
    private double price;
    private int quantity;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Order order;

    public OrderDetail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
