package com.kodilla.good.patterns.challenges.store.online.service.order;

import com.kodilla.good.patterns.challenges.store.online.product.CellPhone;
import com.kodilla.good.patterns.challenges.store.online.product.Product;
import com.kodilla.good.patterns.challenges.store.online.user.User;

import java.math.BigDecimal;

public class OrderRequestRetreiver {

    public static final double CELL_PHONE_PRICE = 599.99;
    public static final int QUANTITY = 1;

    public OrderRequest retreive() {
        User user = new User("Roman", "Kowalski", "r.kowalski@gmail.com");
        Product product = new CellPhone(new BigDecimal(CELL_PHONE_PRICE));

        return new OrderRequest(user, product, QUANTITY);
    }
}
