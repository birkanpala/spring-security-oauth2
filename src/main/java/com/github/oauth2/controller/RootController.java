package com.github.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class RootController {

    @GetMapping("/")
    public String root(Principal principal) {
        return "Hello " + principal.getName();
    }
}
