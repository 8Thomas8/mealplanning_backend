package com.thomasrousseau.mealplanning.controllers;

import com.thomasrousseau.mealplanning.controllers.base.BaseRestController;
import com.thomasrousseau.mealplanning.database.repositories.SlotRepository;
import com.thomasrousseau.mealplanning.models.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for Accompaniment.
 */
@RestController
@RequestMapping("/api/slot")
public class SlotController extends BaseRestController<Slot, Integer> {
    public SlotController(@Autowired SlotRepository repository) {
        super(repository);
    }
}
