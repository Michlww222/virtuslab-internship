package com.virtuslab.internship.app.receipt;

import com.virtuslab.internship.app.basket.Basket;
import com.virtuslab.internship.app.product.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ReceiptGenerator {

    public Receipt generate(Basket basket) {
        var receipt = getReceipt(basket);
        return receipt;
    }

    private Receipt getReceipt(Basket basket) {
        List<ReceiptEntry> receiptEntries = new ArrayList<>();
        List<Product> products = basket.getProducts();
        while(products.size() > 0){
            Product product = products.get(0);
            int quantity = countProduct(product,products);
            List<Product> toRemove = new ArrayList<Product>();
            toRemove.add(product);
            products.removeAll(toRemove);
            receiptEntries.add(new ReceiptEntry(product,quantity));
        }

        return new Receipt(receiptEntries);
    }

    private int countProduct(Product product,List<Product> productList){
        int counter = 0;
        for (Product p : productList) {
            if(p.equals(product)){
                counter += 1;
            }
        }
        return counter;
    }


}
