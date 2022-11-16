package edu.miu.services;

import edu.miu.dtos.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name = "product-service", url = "http://localhost:9090")
@FeignClient("product-service")
public interface ProductClient {
    @GetMapping("/products")
    List<ProductDto> getAllProducts();
}
