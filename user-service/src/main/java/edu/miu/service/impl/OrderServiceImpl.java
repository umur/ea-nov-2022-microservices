package edu.miu.service.impl;

import edu.miu.dto.OrderDto;
import edu.miu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Value("${order.service.url:http://localhost:9091/orders/}")
    private String orderServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<OrderDto> getAllOrdersByUserId(int userId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<OrderDto>> entity = new HttpEntity<>(headers);
        var result = restTemplate.exchange(
                String.format("%suser/%s", orderServiceUrl, userId),
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<OrderDto>>() {});
        return result.getBody();
    }

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDto> entity = new HttpEntity<>(orderDto, headers);

        return restTemplate.exchange(orderServiceUrl, HttpMethod.POST, entity, OrderDto.class).getBody();
    }

    @Override
    public OrderDto updateOrder(int id, OrderDto orderDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDto> entity = new HttpEntity<>(orderDto, headers);

        return restTemplate.exchange(
                String.format("%s%s", orderServiceUrl, id),
                HttpMethod.PUT,
                entity,
                OrderDto.class
            ).getBody();
    }

    @Override
    public OrderDto deleteOrder(int id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<OrderDto> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                String.format("%s%s", orderServiceUrl, id),
                HttpMethod.DELETE,
                entity,
                new ParameterizedTypeReference<OrderDto>() {}).getBody();
    }
}
