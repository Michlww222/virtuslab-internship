package com.virtuslab.internship.app.discount;

import com.virtuslab.internship.app.receipt.Receipt;

import java.math.BigDecimal;

public abstract class percentDiscount implements Discount {


    @Override
    public Receipt calculateApply(Receipt receipt, String name, double dsc){
        var totalPrice = receipt.totalPrice().multiply(BigDecimal.valueOf(dsc));
        var discounts = receipt.discounts();
        discounts.add(name);
        return new Receipt(receipt.entries(), discounts, totalPrice);
    }


}
