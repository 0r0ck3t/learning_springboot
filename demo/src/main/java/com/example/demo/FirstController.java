package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class FirstController {
    private final GreetingService greetingService;

    @Autowired //This annotation tells Spring: "Look in your container for a bean of type GreetingService and 'inject' (pass) it in here."
    public FirstController(GreetingService greetingService) 
    {
        this.greetingService = greetingService; //Dependency Injection: Spring will inject the GreetingService instance into the FirstController constructor.
    }
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }
    @GetMapping("/hello")
    // public String hello(@RequestParam(name = "name", defaultValue = "World") String name) {
    //     return "Hello," + name + "!";
    // }
    public Greeting sayHello(@RequestParam(value = "name", defaultValue = "World") String name) 
    {
        //return new Greeting("Hello, " + name + "!");
        String message = greetingService.createGreeting(name);
        return new Greeting(message);
    }
}