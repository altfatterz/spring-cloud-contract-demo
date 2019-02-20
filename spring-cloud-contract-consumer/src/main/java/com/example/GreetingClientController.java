package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/greeting-client")
    public String greet(@RequestParam("name") String name, @RequestParam("lang") String lang) {

        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/greeting?lang=" + lang, String.class);

        return entity.getBody() + " " + name;

    }

}
