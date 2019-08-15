package com.exam.entity;

import javax.persistence.*;
import java.util.Calendar;

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

            this.id = Calendar.getInstance().getTimeInMillis();


    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
