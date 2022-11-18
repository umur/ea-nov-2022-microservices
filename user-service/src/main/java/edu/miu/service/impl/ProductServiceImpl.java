package edu.miu.service.impl;

import edu.miu.dto.ProductDto;
import edu.miu.service.ProductService;
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
public class ProductServiceImpl implements ProductService {

    @Value("${product.service.url:http://localhost:9090/products/}")
    private String productServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<ProductDto> getAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<List<ProductDto>> entity = new HttpEntity<>(headers);
        var result = restTemplate.exchange(
                productServiceUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<ProductDto>>() {});
        return result.getBody();
    }

    @Override
    public ProductDto getProductById(int id) {
        var result = restTemplate.getForObject(String.format("%s%s", productServiceUrl, id), ProductDto.class);
        return result;
    }
}
