package com.kodilla.good.patterns.challenges.food2door.product;

public class ProductSearchResult {

    private boolean productFound;
    private boolean productsQuantityOK;
    private String productName;

    public ProductSearchResult(boolean productFound, boolean productsQuantityOK, String productName) {
        this.productFound = productFound;
        this.productsQuantityOK = productsQuantityOK;
        this.productName = productName;
    }

    public void printSearchResult() {
        if (productFound) {
            System.out.print(productName + " found. ");
            if (productsQuantityOK) {
                System.out.print("Quantity OK.\n");
            } else {
                System.out.print("Quantity NOK.\n");
            }
        } else {
            System.out.println(productName + " not found at supplier.");
        }
    }


    public boolean isProductFound() {
        return productFound;
    }

    public boolean isProductsQuantityOK() {
        return productsQuantityOK;
    }
}
