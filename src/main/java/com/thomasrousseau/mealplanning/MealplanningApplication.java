package com.thomasrousseau.mealplanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class MealplanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(MealplanningApplication.class, args);
    }

}
