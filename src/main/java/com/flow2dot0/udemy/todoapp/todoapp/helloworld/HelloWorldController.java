package com.flow2dot0.udemy.todoapp.todoapp.helloworld;

import org.springframework.web.bind.annotation.*;

/**
 * User: flow2dot0-osx
 * Date: 15/09/2020
 * Time: 16:43
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HelloWorldController {

//    @RequestMapping(method= RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
//        throw new RuntimeException("Something wrong");
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

//    Basic dXNyOnB3ZA==
}
