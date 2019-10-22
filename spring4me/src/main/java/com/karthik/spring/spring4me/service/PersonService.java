package com.karthik.spring.spring4me.service;

import com.karthik.spring.spring4me.model.Person;
import com.karthik.spring.spring4me.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    // private final ApplicationEventPublisher publisher;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
        // this.publisher = publisher;
    }

    public Flux<Person> getPersonByName(final String name) {
        return personRepository.findByName(name);
    }

}
