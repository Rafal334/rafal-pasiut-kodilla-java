package com.kodilla.good.patterns.challenges.store.online.product;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public abstract class Product {

    private BigDecimal price;

    public Product(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "price= " + new DecimalFormat("#0.##").format(price);
    }
}
