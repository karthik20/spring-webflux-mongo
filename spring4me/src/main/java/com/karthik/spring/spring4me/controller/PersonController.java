package com.karthik.spring.spring4me.controller;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

import com.karthik.spring.spring4me.model.Person;
import com.karthik.spring.spring4me.service.PersonService;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/{name}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Publisher<Person> getPerson(@PathVariable(name = "name") final String personName) {
        return personService.getPersonByName(personName).doOnNext(person -> System.out.println(person.getAge()));
    }

    @GetMapping(value = "/num/inc")
    public Flux<String> increment() {
        return Flux.fromStream(Stream.generate(() -> "Time right now : " + Instant.now()))
                .delayElements(Duration.ofSeconds(1));
    }
}