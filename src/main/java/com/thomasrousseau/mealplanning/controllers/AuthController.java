package com.thomasrousseau.mealplanning.controllers;

import com.thomasrousseau.mealplanning.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/getLogged")
    public UserDetails loginSuccess(Principal principal) {
        return userService.loadUserByUsername(principal.getName());
    }
}
