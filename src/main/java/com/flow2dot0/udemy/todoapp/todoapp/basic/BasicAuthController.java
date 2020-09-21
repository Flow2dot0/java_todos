package com.flow2dot0.udemy.todoapp.todoapp.basic;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthController {

    @GetMapping(path = "/basicauth")
    public BasicAuthenticationBean basicAuthenticationBean() {
        return new BasicAuthenticationBean("You are authenticated !");
    }
}
