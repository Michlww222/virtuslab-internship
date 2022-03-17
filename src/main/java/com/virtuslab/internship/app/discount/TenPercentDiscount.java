package com.virtuslab.internship.app.discount;

import com.virtuslab.internship.app.receipt.Receipt;

import java.math.BigDecimal;

public class TenPercentDiscount extends percentDiscount {

    public static String NAME = "TenPercentDiscount";
    private double dsc = 0.9;

    public Receipt apply(Receipt receipt){
        if (shouldApply(receipt)) {
            receipt = super.calculateApply(receipt,this.NAME,this.dsc);
        }
        return receipt;
    }

    public boolean shouldApply(Receipt receipt) {
        return receipt.totalPrice().compareTo(BigDecimal.valueOf(50)) > 0;
    }

}
