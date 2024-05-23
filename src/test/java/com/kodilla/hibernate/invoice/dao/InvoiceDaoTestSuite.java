package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @Test
    @Transactional
    public void testInvoiceDaoSave() {
        // Given
        Product product1 = new Product(0, "Product 1");
        Product product2 = new Product(0, "Product 2");
        productDao.saveAll(Arrays.asList(product1, product2));

        Item item1 = new Item(0, product1, new BigDecimal(100), 2, new BigDecimal(200));
        Item item2 = new Item(0, product2, new BigDecimal(50), 4, new BigDecimal(200));

        Invoice invoice = new Invoice(0, "001", Arrays.asList(item1, item2));

        // When
        invoiceDao.save(invoice);
        int invoiceId = invoice.getId();

        // Then
        assertNotNull(invoiceId);
        invoiceDao.deleteById(invoiceId);
    }
}