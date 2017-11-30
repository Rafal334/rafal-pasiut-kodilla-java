package com.kodilla.good.patterns.challenges.food2door.order.validator;

import com.kodilla.good.patterns.challenges.food2door.order.OrderProcessDto;

public interface Validator {

    void validateOrder(OrderProcessDto processDto);
}
