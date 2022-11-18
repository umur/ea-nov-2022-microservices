package edu.miu.service.impl;

import edu.miu.dto.OrderDto;
import edu.miu.dto.OrderItemDto;
import edu.miu.entity.Order;
import edu.miu.entity.OrderItem;
import edu.miu.repository.OrderRepository;
import edu.miu.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<OrderDto> getAllOrdersByUserId(int userId) {
        List<Order> orders = orderRepository.findAllByUserId(userId);
        return orders.stream().map(o -> modelMapper.map(o, OrderDto.class)).toList();
    }

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);
        order.getOrderItems().stream().forEach(orderItem -> {
            orderItem.setOrder(order);
        });
        return modelMapper.map(orderRepository.save(order), OrderDto.class);
    }

    @Override
    public OrderDto updateOrder(int id, OrderDto orderDto) {
        OrderDto result = null;
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null)  {
            if (orderDto.getComment() != null) {
                order.setComment(orderDto.getComment());
            }

            List<OrderItemDto> orderItemDtos = orderDto.getOrderItems();
            if (orderItemDtos != null && !orderItemDtos.isEmpty()) {
                List<OrderItem> newItems = orderItemDtos.stream()
                        .filter(dto -> !order.getOrderItems().stream()
                                .filter(i -> i.getProductId() == dto.getProductId())
                                .findAny()
                                .isPresent())
                        .map(dto -> {
                            OrderItem item = modelMapper.map(dto, OrderItem.class);
                            item.setOrder(order);
                            return item;
                        })
                        .toList();

                List<OrderItem> removedItems = order.getOrderItems().stream()
                        .filter(dto -> !orderItemDtos.stream()
                                .filter(i -> i.getProductId() == dto.getProductId())
                                .findAny()
                                .isPresent())
                        .toList();

                // Updated items
                order.getOrderItems().forEach(item -> {
                    OrderItemDto orderItemDto = orderItemDtos.stream()
                            .filter(i -> i.getProductId() == item.getProductId())
                            .findAny()
                            .orElse(null);
                    if (orderItemDto != null) {
                        if (orderItemDto.getQuantity() != item.getQuantity()) {
                            item.setQuantity(orderItemDto.getQuantity());
                        }
                        if (orderItemDto.getPrice() != item.getPrice()) {
                            item.setPrice(orderItemDto.getPrice());
                        }
                    }
                });
                // Remove items
                order.getOrderItems().removeAll(removedItems);
                // Add new items
                order.getOrderItems().addAll(newItems);
            } else {
                order.getOrderItems().removeAll(order.getOrderItems());
            }
            result = modelMapper.map(orderRepository.save(order), OrderDto.class);
        }
        return result;
    }

    @Override
    public OrderDto remove(int id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            orderRepository.delete(order);
        }
        return modelMapper.map(order, OrderDto.class);
    }
}
