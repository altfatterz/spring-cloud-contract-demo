package com.example;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class GreetingController {

    private final GreetingRepository greetingRepository;

    public GreetingController(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @GetMapping("/greetings/{lang}")
    public ResponseEntity<Greeting> findGreeting(@PathVariable String lang) {
        Greeting greeting = greetingRepository.findByLang(lang);
        if (greeting == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(greeting, HttpStatus.OK);
        }
    }

    @GetMapping("/greetings")
    public Iterable<Greeting> allGreetings() {
        return greetingRepository.findAll();
    }

    @PostMapping("/greetings")
    @ResponseStatus(HttpStatus.CREATED)
    public void createGreeting(@RequestBody Greeting greeting) {
        greetingRepository.save(greeting);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public void handleConstraintViolation(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.CONFLICT.value(), "Greeting with this language already exists");
    }

}

