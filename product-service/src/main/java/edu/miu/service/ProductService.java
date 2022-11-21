package edu.miu.service;

import edu.miu.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product getProductById(int id);

    List<Product> getAll();
}
