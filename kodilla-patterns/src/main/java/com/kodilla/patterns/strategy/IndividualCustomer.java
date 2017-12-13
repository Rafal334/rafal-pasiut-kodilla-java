package com.kodilla.patterns.strategy;

public class IndividualCustomer extends Customer {

    public IndividualCustomer(String name) {
        super(name);
        buyPredictor = new ConservativePredictor();
    }
}
