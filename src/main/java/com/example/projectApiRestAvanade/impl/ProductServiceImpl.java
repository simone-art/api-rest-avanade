package com.example.projectApiRestAvanade.impl;

import com.example.projectApiRestAvanade.entity.Product;
import com.example.projectApiRestAvanade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    
    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductFromId(Long codigo) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
