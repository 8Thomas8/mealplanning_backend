package com.thomasrousseau.mealplanning.controllers;

import com.thomasrousseau.mealplanning.controllers.base.BaseRestController;
import com.thomasrousseau.mealplanning.database.repositories.MomentRepository;
import com.thomasrousseau.mealplanning.models.Moment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for Accompaniment.
 */
@RestController
@RequestMapping("/api/moment")
public class MomentController extends BaseRestController<Moment, Integer> {
    public MomentController(@Autowired MomentRepository repository) {
        super(repository);
    }
}
