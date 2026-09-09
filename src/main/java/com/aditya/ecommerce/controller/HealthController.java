package com.aditya.ecommerce.controller;

import com.aditya.ecommerce.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    private final GreetingService greetingService;

    public HealthController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String health() {
        return "UP";
    }

    @GetMapping("/message")
    public String message() {
        return greetingService.getGreeting();
    }
}