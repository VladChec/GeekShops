package com.example.clientservice.repositories;

import com.example.clientservice.client.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Person, Integer> {
}
