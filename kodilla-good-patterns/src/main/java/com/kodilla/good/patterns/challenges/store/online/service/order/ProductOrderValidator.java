package com.kodilla.good.patterns.challenges.store.online.service.order;

public class ProductOrderValidator implements OrderValidator {

    @Override
    public void validate(OrderDto orderDto) {
        if (orderDto.isOrdered) {
            System.out.println("Products ordered successfully!");
        } else {
            System.out.println("Order failed.");
        }
    }
}
