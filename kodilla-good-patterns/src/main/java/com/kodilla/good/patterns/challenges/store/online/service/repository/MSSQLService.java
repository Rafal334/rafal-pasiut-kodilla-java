package com.kodilla.good.patterns.challenges.store.online.service.repository;

import com.kodilla.good.patterns.challenges.store.online.service.order.OrderRequest;

public class MSSQLService implements OrderRepository {

    @Override
    public void logOrder(OrderRequest orderRequest) {
        System.out.println("Logging order to database...");
        System.out.println("Logged order: " + orderRequest);
    }
}
