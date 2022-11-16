package com.example.service.impl;

import com.example.entity.Product;
import com.example.repo.IProductRepo;
import com.example.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductRepo repo;

    @Override
    public Iterable<Product> getAll() {
        return repo.findAll();
    }

    @Override
    public Product findById(long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }
}
