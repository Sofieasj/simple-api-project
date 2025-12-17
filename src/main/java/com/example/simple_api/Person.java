package com.example.simple_api;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Person {
    private @Id
    @GeneratedValue int id;
    private String name;

    // konstruktør - forces us to declare these upon object initiation
    public Person(String name) {
        this.name = name;
    }

    // tom konstruktør
    public Person() {}

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getId() {
        return this.id;
    }
}
