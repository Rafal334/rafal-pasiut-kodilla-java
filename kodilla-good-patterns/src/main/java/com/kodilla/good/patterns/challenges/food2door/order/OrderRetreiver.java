package com.kodilla.good.patterns.challenges.food2door.order;

import com.kodilla.good.patterns.challenges.food2door.product.cart.ShoppingCart;
import com.kodilla.good.patterns.challenges.food2door.supplier.Supplier;
import com.kodilla.good.patterns.challenges.food2door.supplier.repository.SupplierRepository;
import com.kodilla.good.patterns.challenges.food2door.supplier.repository.SuppliersFileDatabase;
import com.kodilla.good.patterns.challenges.food2door.user.User;

public class OrderRetreiver {

    public Order getSampleOrder(String supplierName) {

        User user = new User("Jan","Kowalski","jkowalski@gmail.com");
        ShoppingCart cart = new ShoppingCart();
        SupplierRepository supplierRepository = new SuppliersFileDatabase();
        Supplier supplier = supplierRepository.getSupplier(supplierName);

        return new Order(user,cart.getSampleShoppingCart(),supplier);

    }
}
