package com.example.service;

import com.example.entity.Product;

public interface IProductService {

    Iterable<Product> getAll();

    Product findById(long id);
}
