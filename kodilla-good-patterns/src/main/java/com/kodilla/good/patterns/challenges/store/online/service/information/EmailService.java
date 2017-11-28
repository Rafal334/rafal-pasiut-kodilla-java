package com.kodilla.good.patterns.challenges.store.online.service.information;

import com.kodilla.good.patterns.challenges.store.online.service.order.OrderRequest;

public class EmailService implements InformationService {

    @Override
    public void sendInformation(OrderRequest orderRequest) {
        System.out.println("Sending email to " + orderRequest.getUser().getEmail() + "...");
        System.out.println("You have ordered: " + orderRequest);
    }
}
