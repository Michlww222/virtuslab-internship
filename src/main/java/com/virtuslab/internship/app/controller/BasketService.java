package com.virtuslab.internship.app.controller;

import com.virtuslab.internship.app.analyzer.BasketAnalyzer;
import com.virtuslab.internship.app.basket.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BasketService {


    private final BasketRepository basketRepository;

    @Autowired
    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @GetMapping
    List<Basket> getBaskets() {
        return basketRepository.findAll();
    }

    void newBasket(Basket basket){
        basketRepository.save(basket);
    }


    public Basket replaceBasket(Basket newBasket, long id) {
        return basketRepository.findById(id)
                .map(basket -> {
                    basket.setProducts(newBasket.getProducts());
                    return basketRepository.save(basket);
                })
                .orElseGet(() -> {
                    newBasket.setId(id);
                    return basketRepository.save(newBasket);
                });
    }

    public BigDecimal getPrice(long id) {
        Basket tempBasket = basketRepository.findById(id)
                .orElseThrow(() -> new BasketNotFoundException(id));
        BasketAnalyzer basketAnalyzer = new BasketAnalyzer(tempBasket);
        return basketAnalyzer.getReceipt().totalPrice();
    }
}
