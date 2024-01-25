package com.example.clientservice.controller;

//import client.Client;
import com.example.clientservice.client.Person;
import com.example.clientservice.repositories.ProductRepository;
import com.example.clientservice.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final PersonService personService;

    @Autowired
    private ProductRepository productRepository;

    public ClientController(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/all")
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }
//
//    @GetMapping("/all")
//    public List<Person> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Person getPersonById(@PathVariable int id) {
//        return productRepository.findById(id).orElse(null);
//    }
//
//
//    @PostMapping("/add")
//    public Person addPerson(@RequestBody Person person) {
//        return productRepository.save(person);
//    }
}