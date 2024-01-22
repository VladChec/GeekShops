package controller;

import client.Client;
import client.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Client> getAllProducts() {
        return productRepository.findAll();
    }
}