package com.kodilla.good.patterns.challenges.store.online.service.order;

import com.kodilla.good.patterns.challenges.store.online.service.information.InformationService;
import com.kodilla.good.patterns.challenges.store.online.service.repository.OrderRepository;

public class OrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public OrderProcessor(final InformationService informationService, final OrderService orderService, final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered = orderService.order(orderRequest);

        if (isOrdered) {
            informationService.sendInformation(orderRequest);
            orderRepository.logOrder(orderRequest);
            return new OrderDto(true, orderRequest);
        } else {
            return new OrderDto(false, orderRequest);
        }
    }
}
