package com.kodilla.good.patterns.challenges.store.online.service.order;

import com.kodilla.good.patterns.challenges.store.online.product.Product;
import com.kodilla.good.patterns.challenges.store.online.user.User;

public class OrderRequest {

    private User user;
    private Product product;
    private int quantity;

    public OrderRequest(final User user, final Product product, final int quantity) {
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
