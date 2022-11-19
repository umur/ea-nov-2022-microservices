package edu.miu.Service;

import edu.miu.entity.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}
