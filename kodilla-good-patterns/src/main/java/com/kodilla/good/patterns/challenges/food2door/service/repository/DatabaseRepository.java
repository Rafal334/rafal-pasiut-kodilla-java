package com.kodilla.good.patterns.challenges.food2door.service.repository;


import com.kodilla.good.patterns.challenges.food2door.order.Order;

public class DatabaseRepository implements Repository {

    @Override
    public void logOrder(Order order) {
        System.out.println("Loging order information to database");
    }
}
