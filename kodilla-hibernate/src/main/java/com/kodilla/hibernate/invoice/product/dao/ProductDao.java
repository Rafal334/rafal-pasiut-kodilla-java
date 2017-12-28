package com.kodilla.hibernate.invoice.product.dao;

import com.kodilla.hibernate.invoice.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
}
