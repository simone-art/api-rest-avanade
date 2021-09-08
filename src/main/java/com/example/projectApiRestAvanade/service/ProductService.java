package com.example.projectApiRestAvanade.service;

import com.example.projectApiRestAvanade.entity.Product;

import java.util.List;

public interface ProductService {

        public List<Product> getAllProducts();

        public Product getProductFromId(Long codigo);

        public Product createProduct(Product product);


}
