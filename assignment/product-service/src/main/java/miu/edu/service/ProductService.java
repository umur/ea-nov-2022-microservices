package miu.edu.service;

import miu.edu.entity.Product;

public interface ProductService {
    Iterable<Product> getAll();
    Product getById(int id);
}
