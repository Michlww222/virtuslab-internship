package com.virtuslab.internship.app.discount;

import com.virtuslab.internship.app.receipt.Receipt;

public interface Discount {

    Receipt apply(Receipt receipt);

    boolean shouldApply(Receipt receipt);

    Receipt calculateApply(Receipt receipt, String name, double dsc);
}
