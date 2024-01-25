package com.example.clientservice.services;

import com.example.clientservice.client.Person;
import com.example.clientservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final ProductRepository personRepository;

    @Autowired
    public PersonServiceImpl(ProductRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPersonById(int id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }
    // Implement other methods as needed
}