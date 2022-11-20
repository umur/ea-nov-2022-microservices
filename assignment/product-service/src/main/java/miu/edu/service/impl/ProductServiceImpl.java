package miu.edu.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.entity.Product;
import miu.edu.repo.ProductRepo;
import miu.edu.service.ProductService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    @Override
    public Iterable<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepo.findById(id).get();
    }
}
