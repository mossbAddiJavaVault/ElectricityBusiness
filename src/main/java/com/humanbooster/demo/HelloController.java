package com.humanbooster.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String hello() {
        return "Accueil à l'application de démonstration !";
    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "<h1>Bonjour monde lalalaa !</h1>";
    }
    
}
