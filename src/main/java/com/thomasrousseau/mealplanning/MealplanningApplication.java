package com.thomasrousseau.mealplanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "com.thomasrousseau")
public class MealplanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(MealplanningApplication.class, args);
    }

}
