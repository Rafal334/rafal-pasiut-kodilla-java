package com.kodilla.good.patterns.challenges.store.online.service.repository;

import com.kodilla.good.patterns.challenges.store.online.service.order.OrderRequest;

public interface OrderRepository {

    void logOrder(OrderRequest orderRequest);
}
