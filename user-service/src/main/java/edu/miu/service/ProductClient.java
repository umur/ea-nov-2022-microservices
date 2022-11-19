package edu.miu.service;

import edu.miu.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:9090")
//@FeignClient(name = "product-service") // will check from service discovery with load balanced
public interface ProductClient {
    @GetMapping("/products")
    List<ProductDto> getAllProducts();
}
