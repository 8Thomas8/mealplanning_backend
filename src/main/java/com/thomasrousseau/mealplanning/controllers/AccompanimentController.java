package com.thomasrousseau.mealplanning.controllers;

import com.thomasrousseau.mealplanning.controllers.base.BaseRestController;
import com.thomasrousseau.mealplanning.database.repositories.AccompanimentRepository;
import com.thomasrousseau.mealplanning.models.Accompaniment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for Accompaniment.
 */
@RestController
@RequestMapping("/api/accompaniment")
public class AccompanimentController extends BaseRestController<Accompaniment, Integer> {
    public AccompanimentController(@Autowired AccompanimentRepository repository) {
        super(repository);
    }
}
