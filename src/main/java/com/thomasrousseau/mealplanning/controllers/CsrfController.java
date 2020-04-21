package com.thomasrousseau.mealplanning.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for getting a new CSRF token when comming on the front.
 */
@RestController
public class CsrfController {
    @GetMapping("/api/getToken")
    public void getToken() {}
}
