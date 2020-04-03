package com.thomasrousseau.mealplanning.controllers;

import com.thomasrousseau.mealplanning.controllers.base.BaseRestController;
import com.thomasrousseau.mealplanning.database.repositories.UserRepository;
import com.thomasrousseau.mealplanning.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for Accompaniment.
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseRestController<User, Integer> {
    public UserController(@Autowired UserRepository repository) {
        super(repository);
    }
}
