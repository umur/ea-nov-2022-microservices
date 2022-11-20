package edu.miu.serivce;

import edu.miu.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@FeignClient("PRODUCT-SERVICE")
public interface ProductClient {
    @GetMapping("/products")
    List <ProductDto> getAllProducts();
}
