package com.kodilla.good.patterns.challenges.store.online.product;

import java.math.BigDecimal;

public abstract class Product {

    private BigDecimal price;

    public Product(BigDecimal price) {
        this.price = price;
    }
}
