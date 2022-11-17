package com.sushil.service.impl;

import com.sushil.entity.Product;
import com.sushil.repo.ProductRepo;
import com.sushil.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return productRepo.findById(id).orElseThrow(()-> new RuntimeException("Id Not found") );
    }
}
