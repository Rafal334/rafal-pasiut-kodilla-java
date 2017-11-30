package com.kodilla.good.patterns.challenges.food2door.product.cart;

import com.kodilla.good.patterns.challenges.food2door.product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getSampleShoppingCart() {
        Product eggs = new Product("Fresh eggs", "Eggs", new BigDecimal("0.99"), 10);
        Product milk = new Product("Straight from cow - 1l bottle", "Milk", new BigDecimal("1.99"), 2);

        products.add(eggs);
        products.add(milk);

        return products;
    }

}