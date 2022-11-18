package edu.miu.service.impl;

import edu.miu.dto.ProductDto;
import edu.miu.entity.Product;
import edu.miu.repository.ProductRepository;
import edu.miu.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    @Override
    public ProductDto getProductById(int id) {
        return modelMapper.map(this.getProduct(id), ProductDto.class);
    }

    private Product getProduct(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product is not exist."));
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        return modelMapper.map(productRepository.save(modelMapper.map(productDto, Product.class)), ProductDto.class);
    }

    @Override
    public ProductDto updateProduct(int id, ProductDto productDto) {
        Product product = this.getProduct(id);

        if (StringUtils.isNotBlank(productDto.getName())) {
            product.setName(productDto.getName());
        }

        if (StringUtils.isNotBlank(productDto.getColor())) {
            product.setColor(productDto.getColor());
        }

        if (productDto.getPrice() > 0) {
            product.setPrice(productDto.getPrice());
        }

        if (productDto.getRating() > 0) {
            product.setRating(productDto.getRating());
        }

        return modelMapper.map(productRepository.save(product), ProductDto.class);
    }

    @Override
    public ProductDto remove(int id) {
        ProductDto productDto = this.getProductById(id);
        productRepository.deleteById(id);
        return productDto;
    }
}
