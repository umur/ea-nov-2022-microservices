package edu.miu.services.impl;

import edu.miu.entities.Product;
import edu.miu.repos.ProductRepo;
import edu.miu.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }


}
