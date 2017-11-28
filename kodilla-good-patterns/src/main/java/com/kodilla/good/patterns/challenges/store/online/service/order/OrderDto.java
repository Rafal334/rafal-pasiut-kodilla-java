package com.kodilla.good.patterns.challenges.store.online.service.order;

public class OrderDto {

    public Boolean isOrdered;
    public OrderRequest orderRequest;

    public OrderDto(final Boolean isOrdered, final OrderRequest orderRequest) {
        this.isOrdered = isOrdered;
        this.orderRequest = orderRequest;
    }

    public Boolean getOrdered() {
        return isOrdered;
    }

    public OrderRequest getOrderRequest() {
        return orderRequest;
    }
}
