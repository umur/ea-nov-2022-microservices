package miu.edu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "product-service", url = "http://product-service:8080")
public interface ProductClient {

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    Object getProduct(@PathVariable Long id);
}