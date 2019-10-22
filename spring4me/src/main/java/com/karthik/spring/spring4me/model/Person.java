package com.karthik.spring.spring4me.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "employees")
public class Person {
    @Id
    private String id;
    private String name;
    private int age;
    private List<String> childrenNames;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}