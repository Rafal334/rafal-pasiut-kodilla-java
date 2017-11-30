package com.kodilla.good.patterns.challenges.food2door.service.information;

import com.kodilla.good.patterns.challenges.food2door.order.Order;

public class EmailService implements InformationService {

    @Override
    public void notifieUser(Order order) {
        System.out.println("Sending email to: " + order.getUser().getEmail());
    }
}
