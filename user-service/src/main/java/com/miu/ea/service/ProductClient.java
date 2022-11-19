package com.miu.ea.service;

import com.miu.ea.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name = "PRODUCT-SERVICE", url = "http://localhost:9090")
@FeignClient("PRODUCT-SERVICE")
public interface ProductClient {

    @GetMapping("/products")
    List<ProductDto> getAllProducts();
}
