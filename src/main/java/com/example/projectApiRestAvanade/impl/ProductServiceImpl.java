package com.example.projectApiRestAvanade.impl;

import com.example.projectApiRestAvanade.entity.Product;
import com.example.projectApiRestAvanade.repository.ProductRepository;
import com.example.projectApiRestAvanade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(Long codigo) {
        return this.productRepository.findById(codigo)
                .orElseThrow(()-> new IllegalArgumentException("Produto nao existe"));
    }

    @Override
    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }
}
