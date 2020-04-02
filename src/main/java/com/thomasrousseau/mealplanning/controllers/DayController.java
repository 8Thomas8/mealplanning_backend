package com.thomasrousseau.mealplanning.controllers;

import com.thomasrousseau.mealplanning.controllers.base.BaseRestController;
import com.thomasrousseau.mealplanning.database.repositories.DayRepository;
import com.thomasrousseau.mealplanning.models.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for Accompaniment.
 */
@RestController
@RequestMapping("/api/day")
public class DayController extends BaseRestController<Day, Integer> {
    public DayController(@Autowired DayRepository repository) {
        super(repository);
    }
}
