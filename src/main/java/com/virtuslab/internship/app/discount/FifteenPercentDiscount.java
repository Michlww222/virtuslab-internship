package com.virtuslab.internship.app.discount;

import com.virtuslab.internship.app.receipt.Receipt;
import com.virtuslab.internship.app.receipt.ReceiptEntry;


public class FifteenPercentDiscount extends percentDiscount {

    public static String NAME = "FifteenPercentDiscount";
    private double dsc = 0.85;

    public Receipt apply(Receipt receipt){
        if (shouldApply(receipt)) {
            receipt = super.calculateApply(receipt,this.NAME,this.dsc);
        }
        return receipt;
    }

    @Override
    public boolean shouldApply(Receipt receipt) {
        int counter = 0;
        for(ReceiptEntry re : receipt.entries()){
            counter += re.quantity();
        }
        return counter>=3;
    }


}
