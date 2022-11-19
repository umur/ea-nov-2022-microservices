package edu.miu.controller;

import edu.miu.Service.ProductService;
import edu.miu.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public Iterable<Product> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id){
        return service.findById(id);
    }
}
