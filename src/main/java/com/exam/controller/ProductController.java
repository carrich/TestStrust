package com.exam.controller;


import com.exam.entity.Product;
import com.exam.model.ProductModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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


   private List<Product> products;
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductController() {
        ProductModel productModel = new ProductModel();
        this.products = productModel.findAll();
    }

    public String index() {
        ProductModel productModel = new ProductModel();
        this.products = productModel.findAll();
        return "index?faces-redirect=true";
    }




    }


