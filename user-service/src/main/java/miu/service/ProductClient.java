package miu.service;

import miu.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "PRODUCT-SERVICE", url = "http://localhost:9090")
//@FeignClient("PRODUCT-SERVICE") //find this service
public interface ProductClient {

    @GetMapping("/products")
    List<ProductDTO> getAllProducts();
}
