package com.oguiller.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/", method = RequestMethod.GET)
public class HelloWorldController {
    @GetMapping("/")
    public String hello() {
        return "Hello World, from Spring Boot 2!";
    }
}