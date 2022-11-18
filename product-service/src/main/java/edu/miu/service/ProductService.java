package edu.miu.service;


import edu.miu.dto.ProductDto;
import edu.miu.entity.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAll();

    ProductDto getProductById(int id);

    ProductDto addProduct(ProductDto productDto);

    ProductDto updateProduct(int id, ProductDto productDto);

    ProductDto remove(int id);
}
