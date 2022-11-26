package edu.miu.service;


import edu.miu.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAll();

    ProductDto getProductById(int id);
}
