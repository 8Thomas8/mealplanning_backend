package com.thomasrousseau.mealplanning.controllers;

import com.thomasrousseau.mealplanning.controllers.base.BaseRestController;
import com.thomasrousseau.mealplanning.database.repositories.UserRepository;
import com.thomasrousseau.mealplanning.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for Accompaniment.
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseRestController<User, Integer> {
    @Autowired
    PasswordEncoder passwordEncoder;

    public UserController(@Autowired UserRepository repository) {
        super(repository);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        User account = new User();
        account.setUsername(user.getUsername());
        account.setEmail(user.getEmail());
        account.setRole(user.getRole());
        account.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.save(account);
    }
}
