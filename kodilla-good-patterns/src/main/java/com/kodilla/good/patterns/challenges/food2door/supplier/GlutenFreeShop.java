package com.kodilla.good.patterns.challenges.food2door.supplier;

import com.kodilla.good.patterns.challenges.food2door.order.Order;
import com.kodilla.good.patterns.challenges.food2door.order.OrderProcessDto;
import com.kodilla.good.patterns.challenges.food2door.product.Product;

import java.util.ArrayList;

public class GlutenFreeShop extends Supplier {

    private static final String SUPPLIER_NAME = "GlutenFreeShop";

    public GlutenFreeShop(ArrayList<Product> products) {
        super(SUPPLIER_NAME, products);
    }

    @Override
    public OrderProcessDto process(Order order) {
        System.out.println("Processing order in " + SUPPLIER_NAME);
        //Specific actions for supplier
        boolean orderOK = checkOrder(order);

        return new OrderProcessDto(orderOK, order);
    }
}
