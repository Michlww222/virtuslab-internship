package com.virtuslab.internship.discount;

import com.virtuslab.internship.app.discount.FifteenPercentDiscount;
import com.virtuslab.internship.app.product.ProductDb;
import com.virtuslab.internship.app.receipt.Receipt;
import com.virtuslab.internship.app.receipt.ReceiptEntry;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FifteenPercentDiscountTest {

    @Test
    void shouldApplyDiscount() {
        var productDb = new ProductDb();
        var cheese = productDb.getProduct("Cheese");
        var steak = productDb.getProduct("Steak");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(cheese, 1));
        receiptEntries.add(new ReceiptEntry(steak, 2));

        var receipt = new Receipt(receiptEntries);
        var discount = new FifteenPercentDiscount();
        var receiptAfterDiscount = discount.apply(receipt);
        var expectedTotalPrice = cheese.price().add(steak.price().multiply(BigDecimal.valueOf(2))).multiply(BigDecimal.valueOf(0.85));
        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(1, receiptAfterDiscount.discounts().size());
    }

    @Test
    void shouldNotApplyDiscount() {
        var productDb = new ProductDb();
        var cheese = productDb.getProduct("Cheese");
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        receiptEntries.add(new ReceiptEntry(cheese, 2));

        var receipt = new Receipt(receiptEntries);
        var discount = new FifteenPercentDiscount();
        var receiptAfterDiscount = discount.apply(receipt);
        var expectedTotalPrice = cheese.price().multiply(BigDecimal.valueOf(2));

        assertEquals(expectedTotalPrice, receiptAfterDiscount.totalPrice());
        assertEquals(0, receiptAfterDiscount.discounts().size());
    }
}
