package miu.edu.service;

import miu.edu.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//@FeignClient(name = "PRODUCT-SERVICE",url = "http://localhost:44961")
@FeignClient("PRODUCT-SERVICE")
public interface ProductClient {
    @GetMapping("/products")
    List<ProductDto> getAllProduct();
}
