package com.example.controller;

import com.example.entity.Product;
import com.example.repo.IProductRepo;
import com.example.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService service;

    @GetMapping
    public Iterable<Product> findAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable long id) {
        return service.findById(id);
    }
}
