package edu.miu.controller;

import edu.miu.entity.Product;
import edu.miu.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Iterable<Product> getAll(){
        System.out.println ("running");
        return productService.getAll ();

    }
    @GetMapping(path = "/{id}")
    public Product getById(@PathVariable("id") Integer id){
        return productService.getById (id);

    }



}
