package com.kodilla.good.patterns.challenges.food2door.order;

import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.user.User;

import java.util.HashSet;

public class Order {

    private User user;
    private HashSet<Product> products;
    private String supplierName;

    public Order(User user, HashSet<Product> products, String supplierName) {
        this.user = user;
        this.products = products;
        this.supplierName = supplierName;
    }
}
