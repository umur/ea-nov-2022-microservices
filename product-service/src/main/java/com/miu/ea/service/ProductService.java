package com.miu.ea.service;

import com.miu.ea.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getById(int id);
}
