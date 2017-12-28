package com.kodilla.hibernate.invoice.item.dao;

import com.kodilla.hibernate.invoice.item.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemDao extends CrudRepository<Item, Integer> {
}
