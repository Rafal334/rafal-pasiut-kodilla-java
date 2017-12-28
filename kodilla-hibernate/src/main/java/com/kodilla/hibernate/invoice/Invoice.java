package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.invoice.item.Item;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "INVOICES")
public class Invoice {

    private int id;
    private String number;
    private List<Item> items;

    public Invoice() {
    }

    public Invoice(String number, List<Item> items) {
        this.number = number;
        this.items = items;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "INVOICE_ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "NUMBER")
    public String getNumber() {
        return number;
    }

    @OneToMany(targetEntity = Item.class, mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Item> getItems() {
        return items;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    private void setItems(List<Item> items) {
        this.items = items;
    }
}
