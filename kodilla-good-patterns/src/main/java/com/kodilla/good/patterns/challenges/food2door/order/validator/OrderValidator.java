package com.kodilla.good.patterns.challenges.food2door.order.validator;

import com.kodilla.good.patterns.challenges.food2door.order.OrderProcessDto;

public class OrderValidator implements Validator {

    @Override
    public void validateOrder(OrderProcessDto processDto) {
        if (processDto.isOrderOK()) {
            System.out.println("Order finished successfully");
        } else {
            System.out.println("Order unsuccessful");
        }
    }
}
