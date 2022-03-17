package com.virtuslab.internship.app.basket;

import com.virtuslab.internship.app.converter.ProductListConverter;
import com.virtuslab.internship.app.product.Product;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Convert(converter = ProductListConverter.class)
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(id);
    }

    @Convert(converter = ProductListConverter.class)
    public List<Product> getProducts() {
        return products;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    public long getId() {
        return id;
    }

    @Convert(converter = ProductListConverter.class)
    public void setProducts(List<Product> newProducts){
        this.products = newProducts;
    }
}
