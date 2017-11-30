package com.kodilla.good.patterns.challenges.food2door.order;

public class OrderProcessDto {

    private boolean orderOK;
    private Order order;

    public OrderProcessDto(boolean orderOK, Order order) {
        this.orderOK = orderOK;
        this.order = order;
    }

    public boolean isOrderOK() {
        return orderOK;
    }

    public Order getOrder() {
        return order;
    }
}
