package com.kodilla.hibernate.invoice.product;

import com.kodilla.hibernate.invoice.item.Item;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    private int id;
    private String name;
    private List<Item> items = new ArrayList<>();

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "PRODUCT_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    @OneToMany(targetEntity = Item.class, mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Item> getItems() {
        return items;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItemToList(Item item){
        items.add(item);
    }
}
