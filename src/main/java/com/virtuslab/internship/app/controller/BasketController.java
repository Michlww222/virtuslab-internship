package com.virtuslab.internship.app.controller;

import com.virtuslab.internship.app.basket.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(path="api/v1/baskets")
public class BasketController {


    private final BasketService basketService;

    @Autowired
    BasketController(BasketService basketService){
        this.basketService = basketService;
    }

    @PostMapping
    void newBasket(@RequestBody Basket newBasket) {
        this.basketService.newBasket(newBasket);
    }

    @GetMapping("/{id}")
    @ResponseBody
    BigDecimal getPrice(@PathVariable long id) {
        return basketService.getPrice(id);
    }
    @PutMapping("/{id}")
    @ResponseBody
    Basket replaceBasket(@RequestBody Basket newBasket, @PathVariable long id) {
        return basketService.replaceBasket(newBasket,id);
    }


}
