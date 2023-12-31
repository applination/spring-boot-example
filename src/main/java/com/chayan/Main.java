package com.chayan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        GreetResponse response =  new GreetResponse(
                "Hello",
                List.of("Java", "Julia", "Python", "JavaScript"),
                new Person(
                        "John Doe",
                        24,
                        false,
                        30_000
                )
        );
        return response;
    }

    record Person(String name, int age, Boolean is_prime, double points ){}

    // record: to achieve immutability
    record GreetResponse(
            String greet,
            List<String> languages,
            Person person
    ) {}
}
