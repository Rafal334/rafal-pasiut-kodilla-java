package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.order.Order;
import com.kodilla.good.patterns.challenges.food2door.order.*;
import com.kodilla.good.patterns.challenges.food2door.order.validator.*;
import com.kodilla.good.patterns.challenges.food2door.service.information.EmailService;
import com.kodilla.good.patterns.challenges.food2door.service.repository.DatabaseRepository;

public class Food2DoorRunner {

    public static void main(String[] args) {

        OrderRetreiver orderRetreiver = new OrderRetreiver();
        Order order = orderRetreiver.getSampleOrder("ExtraFoodShop");

        OrderProcessor orderProcessor = new OrderProcessor(order,new EmailService(),new DatabaseRepository());
        OrderProcessDto orderProcessDto = orderProcessor.processOrder();

        Validator validator = new OrderValidator();
        validator.validateOrder(orderProcessDto);

    }


}
