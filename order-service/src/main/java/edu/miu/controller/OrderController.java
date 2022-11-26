package edu.miu.controller;

import edu.miu.dto.OrderDto;
import edu.miu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/user/{userId}")
    public List<OrderDto> getAllOrdersByUserId(@PathVariable int userId) {
        return orderService.getAllOrdersByUserId(userId);
    }

    @PostMapping
    public OrderDto addOrder(@RequestBody OrderDto orderDto) {
        return orderService.addOrder(orderDto);
    }

    @PutMapping("{id}")
    public OrderDto updateOrder(@PathVariable int id, @RequestBody OrderDto orderDto) {
        return orderService.updateOrder(id, orderDto);
    }

    @DeleteMapping("/{id}")
    public OrderDto deleteOrder(@PathVariable int id) {
        return orderService.remove(id);
    }
}
