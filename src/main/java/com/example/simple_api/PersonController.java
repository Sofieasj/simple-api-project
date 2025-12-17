package com.example.simple_api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:63342", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
class PersonController {
    private final PersonRepository repository;

    // konstruktør - link the database/repository
    PersonController(PersonRepository repository) {
        this.repository = repository;
    }

    // READ - spesifikk person - on id
    @GetMapping("/persons/{id}")
    Person one(@PathVariable int id) {
        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    // READ - get all persons
    @GetMapping("/persons")
    ResponseEntity<List<Person>> all() {
        return ResponseEntity.ok(repository.findAll());
    }

    // CREATE - create new person
    @PostMapping("/persons")
    Person  newPerson(@RequestBody Person newPerson) {
        return repository.save(newPerson);
    }

    // UPDATE
    @PutMapping("/persons/{id}")
    Person replacePerson(@RequestBody Person newPerson,@PathVariable Integer id) {
        return repository.findById(id)
                .map(person -> {
                    person.setName(newPerson.getName());
                    return repository.save(person);
                })
                .orElseGet(() -> {
                    return repository.save(newPerson);
                });
    }

    // DELETE
    @DeleteMapping("/persons/{id}")
    void deletePerson(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
