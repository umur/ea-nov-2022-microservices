package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.client.UserClient;
import miu.edu.dto.ProductDTO;
import miu.edu.model.Category;
import miu.edu.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl service;

    private final UserClient userClient;

    @GetMapping()
    public List<ProductDTO> getAll() {
        List<Object> users = userClient.getUsers();
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> get(@PathVariable Long id) {
        return service.findOne(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ProductDTO create(@RequestBody ProductDTO product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductDTO product) {
        product.setId(id);
        return service.save(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("min-price")
    public List<ProductDTO> getByMinPrice(@RequestParam Double price) {
        return service.findAllWithMinPrice(price);
    }

    @PostMapping("category-and-max-price")
    public List<ProductDTO> getByCategoryAndMaxPrice(@RequestBody Category category, @RequestParam Double price) {
        return service.findAllWithCategoryAndMaxPrice(category, price);
    }

    @GetMapping("keyword/{keyword}")
    public List<ProductDTO> getByName(@PathVariable String keyword) {
        return service.findAllWithNameContains(keyword);
    }
}