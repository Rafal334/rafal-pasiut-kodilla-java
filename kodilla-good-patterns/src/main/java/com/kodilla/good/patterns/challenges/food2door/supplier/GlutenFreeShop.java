package com.kodilla.good.patterns.challenges.food2door.supplier;

import com.kodilla.good.patterns.challenges.food2door.product.Product;

import java.util.HashSet;

public class GlutenFreeShop extends Supplier {

    private static final String SUPPLIER_NAME = "GlutenFreeShop";

    public GlutenFreeShop(HashSet<Product> products) {
        super(SUPPLIER_NAME, products);
    }
}
