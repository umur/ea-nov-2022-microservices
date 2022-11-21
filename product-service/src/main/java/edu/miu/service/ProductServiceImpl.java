package edu.miu.service;

import edu.miu.model.Product;
import edu.miu.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        productRepo.findAll().forEach(products::add);
        return products;
    }
}
