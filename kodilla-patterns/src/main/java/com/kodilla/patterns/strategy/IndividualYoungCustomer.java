package com.kodilla.patterns.strategy;

public class IndividualYoungCustomer extends Customer {

    public IndividualYoungCustomer(String name) {
        super(name);
        buyPredictor = new AggressivePredictor();
    }
}
