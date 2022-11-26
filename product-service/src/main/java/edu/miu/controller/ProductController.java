package edu.miu.controller;

import edu.miu.dto.ProductDto;
import edu.miu.entity.Product;
import edu.miu.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDto addProduct(@RequestParam ProductDto productDto) {
        return productService.addProduct(productDto);
    }

    @PutMapping("/{id}")
    public ProductDto updateProduct(@PathVariable int id, @RequestParam ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @DeleteMapping("{id}")
    public ProductDto addProduct(@PathVariable int id) {
        return productService.remove(id);
    }
}
