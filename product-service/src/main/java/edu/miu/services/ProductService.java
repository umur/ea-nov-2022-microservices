package edu.miu.services;

import edu.miu.entities.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAll();
}
