package com.example.simple_api;

// id not found exception handling
class PersonNotFoundException extends RuntimeException {
    PersonNotFoundException(int id) {
        super("Could not find person " + id);
    }
}
