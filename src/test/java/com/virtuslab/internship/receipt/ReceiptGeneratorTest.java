package com.virtuslab.internship.receipt;

import com.virtuslab.internship.app.basket.Basket;
import com.virtuslab.internship.app.product.ProductDb;
import com.virtuslab.internship.app.receipt.ReceiptGenerator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ReceiptGeneratorTest {

    @Test
    void testReceiptGeneration() throws Exception {
        var productDb = new ProductDb();
        var cart = new Basket();
        var milk = productDb.getProduct("Milk");
        var bread = productDb.getProduct("Bread");
        var apple = productDb.getProduct("Apple");
        var expectedTotalPrice = milk.price().multiply(BigDecimal.valueOf(2)).add(bread.price()).add(apple.price());

        cart.addProduct(milk);
        cart.addProduct(milk);
        cart.addProduct(bread);
        cart.addProduct(apple);
        System.out.println(expectedTotalPrice);

        var receiptGenerator = new ReceiptGenerator();
        var receipt = receiptGenerator.generate(cart);
        assertEquals(3, receipt.entries().size());
        assertEquals(expectedTotalPrice, receipt.totalPrice());
        assertEquals(0, receipt.discounts().size());
    }

}