package com.hosystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hyh
 * @Createdate 2022/10/30 14:21
 */
@RestController
@RequestMapping("/health")
public class HealthCheck {

    @GetMapping("/ok")
    public String sayHello(){
        return "hello";
    }
}
