package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greet(@RequestParam(defaultValue = "EN") String lang) {
        if (lang.equals("DE")) {
            return "Hallo";
        } else if (lang.equals("HU")) {
            return "Szia";
        }
        return "Hi";
    }

}
