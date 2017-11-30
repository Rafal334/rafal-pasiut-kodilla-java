package com.kodilla.good.patterns.challenges.food2door.supplier;

import com.kodilla.good.patterns.challenges.food2door.order.Order;
import com.kodilla.good.patterns.challenges.food2door.order.OrderProcessDto;
import com.kodilla.good.patterns.challenges.food2door.product.Product;
import com.kodilla.good.patterns.challenges.food2door.product.ProductSearchResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Supplier {

    private String supplierName;
    private ArrayList<Product> products;

    public Supplier(String supplierName, ArrayList<Product> products) {
        this.supplierName = supplierName;
        this.products = products;
    }

    public abstract OrderProcessDto process(Order order);

    public void showAllProducts() {
        products.forEach(System.out::println);
    }

    protected ProductSearchResult checkForProduct(Product product) {
        if (products.contains(product)) {
            if (products.get(products.indexOf(product)).getQuantity() >= product.getQuantity()) {
                return new ProductSearchResult(true, true, product.getName());
            } else {
                return new ProductSearchResult(true, false, product.getName());
            }
        } else {
            return new ProductSearchResult(false, false, product.getName());
        }
    }

    protected boolean checkOrder(Order order) {
        List<ProductSearchResult> searchResult = order.getProducts().stream().map(this::checkForProduct).collect(Collectors.toList());
        searchResult.forEach(ProductSearchResult::printSearchResult);
        return searchResult.stream().map(result -> result.isProductFound() && result.isProductsQuantityOK()).allMatch(x -> x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        return supplierName.equals(supplier.supplierName);
    }

    @Override
    public int hashCode() {
        return supplierName.hashCode();
    }
}
