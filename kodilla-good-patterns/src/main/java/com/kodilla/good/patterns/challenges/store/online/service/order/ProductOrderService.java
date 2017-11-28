package com.kodilla.good.patterns.challenges.store.online.service.order;

public class ProductOrderService implements OrderService {

    @Override
    public boolean order(OrderRequest orderRequest) {
        System.out.println("Ordering...");
        System.out.println(orderRequest);
        return true;
    }
}
