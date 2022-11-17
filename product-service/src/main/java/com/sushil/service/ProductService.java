package com.sushil.service;

import com.sushil.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product findById(Long id);
}
