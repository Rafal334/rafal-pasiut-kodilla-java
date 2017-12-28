package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceDao extends CrudRepository<Invoice, Integer> {

    List<Invoice> findByNumber(String number);
}
