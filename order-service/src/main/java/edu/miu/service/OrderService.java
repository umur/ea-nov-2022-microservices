package edu.miu.service;

import edu.miu.dto.OrderDto;

import java.util.List;

public interface OrderService {

    List<OrderDto> getAllOrdersByUserId(int userId);

    OrderDto addOrder(OrderDto orderDto);

    OrderDto updateOrder(int id, OrderDto orderDto);

    OrderDto remove(int id);
}
