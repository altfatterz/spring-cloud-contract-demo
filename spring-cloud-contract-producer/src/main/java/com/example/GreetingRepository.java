package com.example;

import org.springframework.data.repository.CrudRepository;

interface GreetingRepository extends CrudRepository<Greeting, String> {

    Greeting findByLang(String lang);
}
