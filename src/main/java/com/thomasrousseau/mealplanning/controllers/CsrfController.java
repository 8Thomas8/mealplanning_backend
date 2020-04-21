package com.thomasrousseau.mealplanning.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController {
    @GetMapping("/api/getToken")
    public void getToken() {}
}
