package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingClientController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/greetings-client")
    public String greet(@RequestParam("name") String name, @RequestParam(value = "lang", defaultValue = "EN") String lang) {
        try {
            Greeting response = restTemplate.getForEntity("http://spring-cloud-contract-producer/greetings/" + lang,
                    Greeting.class).getBody();
            return response.getValue() + " " + name + "!";
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                return "Hi " + name;
            }
            throw new RuntimeException(e);
        }
    }

}
