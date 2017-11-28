package com.kodilla.good.patterns.challenges.store.online;

import com.kodilla.good.patterns.challenges.store.online.service.information.EmailService;
import com.kodilla.good.patterns.challenges.store.online.service.order.*;
import com.kodilla.good.patterns.challenges.store.online.service.repository.MSSQLService;

public class ProductOrderRunner {

    public static void main(String[] args) {
        OrderRequestRetreiver orderRequestRetreiver = new OrderRequestRetreiver();
        OrderRequest orderRequest = orderRequestRetreiver.retreive();

        OrderProcessor orderProcessor = new OrderProcessor(new EmailService(), new ProductOrderService(), new MSSQLService());
        OrderDto orderDto = orderProcessor.process(orderRequest);

        OrderValidator orderValidator = new ProductOrderValidator();
        orderValidator.validate(orderDto);
    }
}
