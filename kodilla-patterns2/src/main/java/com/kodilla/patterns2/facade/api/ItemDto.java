package com.kodilla.patterns2.facade.api;

public class ItemDto {

    private final Long productId;
    private final double quantity;

    public ItemDto(Long productId, double quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public double getQuantity() {
        return quantity;
    }
}
