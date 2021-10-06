package com.example.projectApiRestAvanade.repository;

import com.example.projectApiRestAvanade.entity.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {
}
