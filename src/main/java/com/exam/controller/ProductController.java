package com.exam.controller;


import com.exam.entity.Product;
import com.exam.model.ProductModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SessionScoped
@ManagedBean(name = "productController")
public class ProductController {
    private   String name = "";
    private   String address = "";
    private   String phoneNumber= "";

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private  ArrayList<Product> products
            = new ArrayList<Product>(Arrays.asList(
            new Product("Product1", "Very nice ", 3000,"brand1"),
            new Product("Product2", "Very nice ", 300,"brand2"),
            new Product("Product3", "Very nice ", 2000,"brand3"),
            new Product("Product4", "Very nice ", 4000,"brand4"),
            new Product("Product5", "Very nice ", 1000,"brand5")

    ));

    public  ArrayList<Product> getProducts() {
        return products;
    }

    public String index() {

        return "index?faces-redirect=true";
    }




    }


