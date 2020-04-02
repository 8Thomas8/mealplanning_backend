package com.thomasrousseau.mealplanning.controllers;

import com.thomasrousseau.mealplanning.controllers.base.BaseRestController;
import com.thomasrousseau.mealplanning.database.repositories.MeatRepository;
import com.thomasrousseau.mealplanning.models.Meat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for Accompaniment.
 */
@RestController
@RequestMapping("/api/meat")
public class MeatController extends BaseRestController<Meat, Integer> {
    public MeatController(@Autowired MeatRepository repository) {
        super(repository);
    }
}
