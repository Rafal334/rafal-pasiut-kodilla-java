package com.kodilla.good.patterns.challenges.food2door.supplier.repository;

import com.kodilla.good.patterns.challenges.food2door.supplier.Supplier;

public interface SupplierRepository {
    Supplier getSupplier(String name);
}
