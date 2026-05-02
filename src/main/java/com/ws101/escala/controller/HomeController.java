package com.ws101.escala.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Ito ay maghahanap ng landing.html sa static folder
        return "forward:/landing.html";
    }
}
