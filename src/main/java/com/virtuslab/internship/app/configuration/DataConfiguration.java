package com.virtuslab.internship.app.configuration;
import com.virtuslab.internship.app.basket.Basket;
import com.virtuslab.internship.app.basket.TestBasketFactory;
import com.virtuslab.internship.app.controller.BasketRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(BasketRepository repository){
        TestBasketFactory factory = new TestBasketFactory();
        return args -> {
            Basket basket1 = factory.testBasket1();

            repository.saveAll(
                    List.of(basket1)
            );
        };
    }
}
