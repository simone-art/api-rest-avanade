package com.example.projectApiRestAvanade.repository;

import com.example.projectApiRestAvanade.entity.Categoria;
import com.example.projectApiRestAvanade.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
