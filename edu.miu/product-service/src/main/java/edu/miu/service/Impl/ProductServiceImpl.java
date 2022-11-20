package edu.miu.service.Impl;

import edu.miu.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import edu.miu.repo.ProductRepo;
import edu.miu.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;
    @Override
    public Iterable <Product> getAll () {
        return productRepo.findAll ();
    }


    public Product getById (int id) {
        return productRepo.findById (id).get ();
    }
}
