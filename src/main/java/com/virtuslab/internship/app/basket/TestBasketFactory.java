package com.virtuslab.internship.app.basket;
import com.virtuslab.internship.app.product.ProductDb;

public class TestBasketFactory {

    public Basket testBasket1(){
        Basket basket = new Basket();
        var productDb = new ProductDb();
        var milk = productDb.getProduct("Milk");
        var bread = productDb.getProduct("Bread");
        var apple = productDb.getProduct("Apple");
        basket.addProduct(milk);
        basket.addProduct(milk);
        basket.addProduct(bread);
        basket.addProduct(apple);
        return basket;
    }

    public Basket testBasket2(){
        Basket basket = new Basket();
        var productDb = new ProductDb();
        var milk = productDb.getProduct("Milk");
        basket.addProduct(milk);
        basket.addProduct(milk);
        basket.addProduct(milk);
        return basket;
    }

    public Basket testBasket3(){
        Basket basket = new Basket();
        var productDb = new ProductDb();
        var milk = productDb.getProduct("Milk");
        basket.addProduct(milk);
        return basket;
    }
}
