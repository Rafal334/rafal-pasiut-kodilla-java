package com.kodilla.good.patterns.challenges.food2door.supplier;

import com.kodilla.good.patterns.challenges.food2door.product.Product;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class SupplierClassCreator {

    private String className;

    public SupplierClassCreator(String className) {
        this.className = className;
    }

    public Supplier constructClass(ArrayList<Product> products) throws SupplierNotFoundException {
        Object object;
        try {
            Class<?> clazz = Class.forName("com.kodilla.good.patterns.challenges.food2door.supplier." + className);
            Constructor<?> ctor = clazz.getConstructor(ArrayList.class);
            object = ctor.newInstance(new Object[]{products});
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new SupplierNotFoundException();
        }
        return (Supplier) object;
    }
}
