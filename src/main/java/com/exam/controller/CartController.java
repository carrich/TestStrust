package com.exam.controller;

import com.exam.entity.Item;
import com.exam.entity.Order;
import com.exam.entity.OrderDetail;
import com.exam.entity.Product;
import com.exam.model.ProductModel;
import com.exam.util.HibernateUtil;
import com.sun.tools.javac.jvm.Items;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SessionScoped
@ManagedBean(name = "cartController")
public class CartController {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private List<Item> items;

    public CartController() {
        this.items = new ArrayList<Item>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String buy(Product product, String name) {
        int index = this.exists(product);

        if (index == -1) {
            this.items.add(new Item(product, 1));
        } else {
            int quantity = this.items.get(index).getQuantity() + 1;
            this.items.get(index).setQuantity(quantity);
        }
        return "cart?faces-redirect=true";
    }


    public double total() {
        double totalAmount = 0;

        for (Item item : this.items) {
            totalAmount += item.getProduct().getPrice() * item.getQuantity();
        }
        if (totalAmount >= 5000) {
            totalAmount = totalAmount * 0.7;
        }
        return totalAmount;
    }

    private int exists(Product product) {
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getProduct().getName() == product.getName()) {
                return i;
            }
        }
        return -1;
    }

    public String checkout(String name, String address, String phoneNumber) {

        Order order = new Order();
        order.setName(name);
        order.setAddress(address);
        order.setPhone(phoneNumber);

        order.setTotalPrice(total());
        Set<OrderDetail> itemsSet = new HashSet<OrderDetail>();
        for (Item item :
                this.items) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setName(item.getProduct().getName());
            orderDetail.setPrice(item.getProduct().getPrice());
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setOrder(order);
            itemsSet.add(orderDetail);


        }
        order.setOrderDetails(itemsSet);
        ProductModel productModel = new ProductModel();

        productModel.checkout(order);

        return "index?faces-redirect=true";
    }
}
