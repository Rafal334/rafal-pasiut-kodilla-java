package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Random;

public final class Country {

    private final BigDecimal peopleQuantity;

    public Country() {
        Random rand = new Random();
        peopleQuantity = new BigDecimal(rand.nextInt(1000000000) + 1000000);
    }

    public BigDecimal getPeopleQuantity() {
        return new BigDecimal(peopleQuantity.toString());
    }
}
