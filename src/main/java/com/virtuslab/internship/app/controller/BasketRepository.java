package com.virtuslab.internship.app.controller;

import com.virtuslab.internship.app.basket.Basket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BasketRepository extends JpaRepository<Basket, Long> {

}