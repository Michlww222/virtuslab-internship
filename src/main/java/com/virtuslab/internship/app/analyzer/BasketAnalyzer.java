package com.virtuslab.internship.app.analyzer;

import com.virtuslab.internship.app.basket.Basket;
import com.virtuslab.internship.app.discount.TenPercentDiscount;
import com.virtuslab.internship.app.receipt.Receipt;
import com.virtuslab.internship.app.receipt.ReceiptGenerator;

import java.math.BigDecimal;

public class BasketAnalyzer {

    private BigDecimal price;
    private Receipt receipt;

    public BasketAnalyzer(Basket basket){
        var receiptGenerator = new ReceiptGenerator();
        var tempReceipt = receiptGenerator.generate(basket);
        var discount10 = new TenPercentDiscount();
        var discount15 = new TenPercentDiscount();
        var receiptAfterDiscount = discount10.apply(discount15.apply(tempReceipt));
        this.receipt = receiptAfterDiscount;
        this.price = receiptAfterDiscount.totalPrice();
    }

    public BigDecimal getPrice(){
        return price;
    }

    public Receipt getReceipt(){
        return receipt;
    }

}
