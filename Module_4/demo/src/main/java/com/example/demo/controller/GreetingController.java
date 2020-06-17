package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GreetingController {

    @GetMapping(value="/greeting")
    public ModelAndView greeting() {
        ModelAndView modelAndView = new ModelAndView("greeting.html");
        return modelAndView;
    }

    @GetMapping(value="/greeting2")
    public String greeting2() {
        return "My name is Spring Boot";
    }
}
