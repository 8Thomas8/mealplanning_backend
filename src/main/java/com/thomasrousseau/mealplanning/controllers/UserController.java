package com.thomasrousseau.mealplanning.controllers;

import com.thomasrousseau.mealplanning.controllers.base.BaseRestController;
import com.thomasrousseau.mealplanning.database.repositories.UserRepository;
import com.thomasrousseau.mealplanning.models.User;
import com.thomasrousseau.mealplanning.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Rest controller for Accompaniment.
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseRestController<User, Integer> {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository repository;

    public UserController(@Autowired UserRepository repository) {
        super(repository);
    }

    @PostMapping(value = {"", "/", "/register"})
    public User register(@RequestBody User user) {
        User account = new User();
        account.setUsername(user.getUsername());
        account.setEmail(user.getEmail());
        account.setRole(user.getRole());
        account.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.save(account);
    }

    @PutMapping(value = "{id}/update")
    public User update(@Valid @RequestBody User updatedUser, @PathVariable int id) {
        User user = this.repository.getOne(id);
        updatedUser.setPassword(user.getPassword());
        return this.save(updatedUser);
    }
}
