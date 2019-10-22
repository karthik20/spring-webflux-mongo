package com.karthik.spring.spring4me.repository;

import com.karthik.spring.spring4me.model.Person;

import org.springframework.data.mongodb.repository.Tailable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface PersonRepository extends ReactiveSortingRepository<Person, String> {

    @Tailable
    Flux<Person> findByName(String name);
}