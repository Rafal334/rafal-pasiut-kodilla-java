package com.kodilla.good.patterns.challenges.food2door.supplier;

import com.kodilla.good.patterns.challenges.food2door.product.Product;

import java.util.HashSet;

public abstract class Supplier {

    private String supplierName;
    private HashSet<Product> products;

    public Supplier(String supplierName, HashSet<Product> products) {
        this.supplierName = supplierName;
        this.products = products;
    }

    //public abstract void process();

    public void showAllProducts() {
        products.forEach(System.out::println);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        return supplierName.equals(supplier.supplierName);
    }

    @Override
    public int hashCode() {
        return supplierName.hashCode();
    }
}
