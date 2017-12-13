package com.kodilla.patterns.strategy;

public class CorporateCustomer extends Customer{

    public CorporateCustomer(String name) {
        super(name);
        buyPredictor = new BalancedPredictor();
    }

}
