package edu.miu.controllers;

import edu.miu.entities.Product;
import edu.miu.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    List<Product> getAll() {
        return productService.getAll();
    }
}
