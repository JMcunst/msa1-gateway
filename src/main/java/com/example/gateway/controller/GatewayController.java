package com.example.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class GatewayController {
    Environment env;

    @Autowired
    public GatewayController(Environment env) {
        this.env = env;
    }

    @GetMapping("/health-check")
    public String status(){
        return String.format("It's Working in Gateway on PORT %s", env.getProperty("local.server.port"));
    }
}
