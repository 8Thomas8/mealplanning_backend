package com.thomasrousseau.mealplanning.controllers;

import com.thomasrousseau.mealplanning.controllers.base.BaseRestController;
import com.thomasrousseau.mealplanning.database.repositories.MealRepository;
import com.thomasrousseau.mealplanning.models.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for Accompaniment.
 */
@RestController
@RequestMapping("/api/meal")
public class MealController extends BaseRestController<Meal, Integer> {
    public MealController(@Autowired MealRepository repository) {
        super(repository);
    }
}
