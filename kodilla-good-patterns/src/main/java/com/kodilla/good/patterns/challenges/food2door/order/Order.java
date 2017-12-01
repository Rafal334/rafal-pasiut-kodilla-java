package com.kodilla.good.patterns.challenges.food2door.order;

import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.supplier.Supplier;
import com.kodilla.good.patterns.challenges.food2door.user.User;

import java.util.ArrayList;

public class Order {

    private User user;
    private ArrayList<Product> products;
    private Supplier supplier;

    public Order(User user, ArrayList<Product> products, Supplier supplier) {
        this.user = user;
        this.products = products;
        this.supplier = supplier;
    }

    public OrderProcessDto process(){
        return supplier.process(this);
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
