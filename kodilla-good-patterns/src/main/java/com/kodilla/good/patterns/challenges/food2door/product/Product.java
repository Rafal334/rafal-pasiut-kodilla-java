package com.kodilla.good.patterns.challenges.food2door.product;

import java.math.BigDecimal;

public class Product {

    private String description;
    private String name;
    private BigDecimal price;
    private Integer quantity;

    public Product(String description, String name, BigDecimal price, Integer quantity) {
        this.description = description;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return description.equals(product.description) && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
