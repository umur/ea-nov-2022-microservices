package com.miu.ea.controller;

import com.miu.ea.entity.Product;
import com.miu.ea.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<Product> getAllUsers(){
        return productService.getAllProducts();
    }

    @GetMapping("id/{id}")
    public Product getById(@PathVariable int id){
        return productService.getById(id);
    }
}
