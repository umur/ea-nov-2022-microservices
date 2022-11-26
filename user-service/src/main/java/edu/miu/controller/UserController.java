package edu.miu.controller;

import edu.miu.dto.OrderDto;
import edu.miu.dto.ProductDto;
import edu.miu.entity.User;
import edu.miu.service.OrderService;
import edu.miu.service.ProductClient;
import edu.miu.service.ProductService;
import edu.miu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    private final ProductClient productClient;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return productService.getAll();
    }

    @GetMapping("/products/{id}")
    public ProductDto getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/test/products")
    public List<ProductDto> getAllProducts() {
        return productClient.getAllProducts();
    }

    @GetMapping("/test/products/{id}")
    public ProductDto getProductByProductId(@PathVariable int id) {
        return productClient.getProductById(id);
    }

    @GetMapping("/products/test")
    public List<ProductDto> getAllProducts1() {
        return productClient.getAllProducts();
    }

    @GetMapping("/{id}/orders")
    public List<OrderDto> getAllOrdersByUserId(@PathVariable int id) {
        return orderService.getAllOrdersByUserId(id);
    }

    @PostMapping("/{id}/orders")
    public OrderDto addAnOrder(@PathVariable int id, @RequestBody OrderDto orderDto) {
        User user = userService.getUserById(id);
        orderDto.setUserId(user.getId());

        orderDto.getOrderItems().stream().forEach(orderItemDto -> {
            ProductDto productDto = productService.getProductById(orderItemDto.getProductId());
            orderItemDto.setPrice(productDto.getPrice());
        });

        return orderService.addOrder(orderDto);
    }

    @PutMapping("/orders/{id}")
    public OrderDto updateAnOrder(@PathVariable int id, @RequestBody OrderDto orderDto) {
        return orderService.updateOrder(id, orderDto);
    }

    @DeleteMapping("/orders/{id}")
    public OrderDto deleteOrder(@PathVariable int id) {
        return orderService.deleteOrder(id);
    }
}
