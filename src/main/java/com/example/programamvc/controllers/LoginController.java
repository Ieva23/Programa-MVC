package com.example.programamvc.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class LoginController {
    @GetMapping("/login")
    public ModelAndView login(@RequestParam(required = false) String currentCity) throws IOException {

        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }
}