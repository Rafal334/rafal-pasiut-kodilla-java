package com.kodilla.stream.invoice.simple;

public final class SimpleProduct {
    private final String productName;
    private final double productPrice;

    public SimpleProduct(final String productName, final double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public SimpleProduct(final SimpleProduct simpleProduct){
        this.productName = simpleProduct.getProductName();
        this.productPrice = simpleProduct.getProductPrice();
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleProduct that = (SimpleProduct) o;

        return productName.equals(that.productName);
    }

    @Override
    public int hashCode() {
        return productName.hashCode();
    }
}
