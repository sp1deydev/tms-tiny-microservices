package com.thientdk.be_tms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/health")
public class HealthCheckController {

    @GetMapping
    String healthCheck() {
        return "Application is running successfully";
    }
}
