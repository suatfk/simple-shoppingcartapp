package com.sc.app.boundary.service;

import com.sc.app.boundary.dto.ProductDto;
import com.sc.app.boundary.mapper.ProductMapper;
import com.sc.app.domain.product.Product;
import com.sc.app.domain.product.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto findById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return productMapper.map(product);
    }

    @Transactional
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.map(productDto);
        product = productRepository.save(product);
        return productMapper.map(product);
    }
}
