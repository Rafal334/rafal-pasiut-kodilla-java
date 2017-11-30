package com.kodilla.good.patterns.challenges.food2door.supplier;

import com.kodilla.good.patterns.challenges.food2door.product.Product;

import java.util.HashSet;

public class HealthyShop extends Supplier {

    private static final String SUPPLIER_NAME = "HealthyShop";

    public HealthyShop(HashSet<Product> products) {
        super(SUPPLIER_NAME, products);
    }
}
