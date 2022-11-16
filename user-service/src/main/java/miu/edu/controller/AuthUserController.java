package miu.edu.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.client.ProductClient;
import miu.edu.dto.UserDTO;
import miu.edu.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class AuthUserController {

    private final UserServiceImpl service;

    private final ProductClient productClient;

    @GetMapping()
    public List<UserDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("products/{id}")
    public Object getProductId(@PathVariable Long id) {
        return productClient.getProduct(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable Long id) {
        return service.findOne(id).map(ResponseEntity::ok).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public UserDTO create(@RequestBody UserDTO user) {
        return service.save(user);
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO user) {
        user.setId(id);
        return service.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}