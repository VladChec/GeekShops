package com.example.clientservice.services;

import com.example.clientservice.client.Person;

import java.util.List;

public interface PersonService {
    Person getPersonById(int id);
    List<Person> getAllPeople();
    Person addPerson(Person person);
    // Add other methods as needed
}
