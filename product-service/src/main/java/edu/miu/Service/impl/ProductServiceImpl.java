package edu.miu.Service.impl;

import edu.miu.Service.ProductService;
import edu.miu.entity.Product;
import edu.miu.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo repo;

    @Override
    public Iterable<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return repo.findById(id);
    }
}
