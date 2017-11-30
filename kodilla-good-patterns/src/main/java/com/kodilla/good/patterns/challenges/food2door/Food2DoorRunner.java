package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.supplier.Supplier;
import com.kodilla.good.patterns.challenges.food2door.supplier.repository.SupplierRepository;
import com.kodilla.good.patterns.challenges.food2door.supplier.repository.SuppliersFileDatabase;

public class Food2DoorRunner {

    public static void main(String[] args) {
        SupplierRepository supplierRepository = new SuppliersFileDatabase();
        Supplier supplier = supplierRepository.getSupplier("HealthyShop");
        supplier.showAllProducts();

        System.out.println("end");

    }


}
