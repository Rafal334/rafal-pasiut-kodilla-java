package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.item.Item;
import com.kodilla.hibernate.invoice.product.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {

        //Given
        String invoiceNumber = "2017/12/A645";

        Product pencil = new Product("Pencil");
        Product pen = new Product("Pen");
        Product notebook = new Product("Notebook");
        Product rubber = new Product("Rubber");

        Item item1 = new Item(pencil, new BigDecimal(1.99), 100);
        Item item2 = new Item(pen, new BigDecimal(3.45), 50);
        Item item3 = new Item(notebook, new BigDecimal(6.89), 60);
        Item item4 = new Item(rubber, new BigDecimal(0.99), 100);

        pencil.addItemToList(item1);
        pen.addItemToList(item2);
        notebook.addItemToList(item3);
        rubber.addItemToList(item4);

        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        Invoice invoice = new Invoice(invoiceNumber, items);

        items.forEach(item -> item.setInvoice(invoice));
        invoiceDao.save(invoice);

        //When
        int itemsCount = invoiceDao.findByNumber(invoiceNumber).get(0).getItems().size();

        //Then
        Assert.assertEquals(4, itemsCount);
        //CleanUp
        invoiceDao.delete(invoice.getId());
    }
}
