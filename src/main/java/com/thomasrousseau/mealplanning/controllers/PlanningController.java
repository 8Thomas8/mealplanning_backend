package com.thomasrousseau.mealplanning.controllers;

import com.thomasrousseau.mealplanning.controllers.base.BaseRestController;
import com.thomasrousseau.mealplanning.database.repositories.PlanningRepository;
import com.thomasrousseau.mealplanning.models.Planning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for Accompaniment.
 */
@RestController
@RequestMapping("/api/planning")
public class PlanningController extends BaseRestController<Planning, Integer> {
    public PlanningController(@Autowired PlanningRepository repository) {
        super(repository);
    }
}
