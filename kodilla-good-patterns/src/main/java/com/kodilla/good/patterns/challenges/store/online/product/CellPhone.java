package com.kodilla.good.patterns.challenges.store.online.product;

import java.math.BigDecimal;

public class CellPhone extends Product {

    public CellPhone(BigDecimal price) {
        super(price);
    }

    @Override
    public String toString() {
        return "CellPhone";
    }
}
