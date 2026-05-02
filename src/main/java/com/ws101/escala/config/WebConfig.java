package com.ws101.escala.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Para kahit localhost:8080 lang i-type, landing.html agad ang lalabas
        registry.addViewController("/").setViewName("forward:/landing.html");
    }
}
