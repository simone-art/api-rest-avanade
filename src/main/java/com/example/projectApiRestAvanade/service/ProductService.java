package com.example.projectApiRestAvanade.service;

import com.example.projectApiRestAvanade.entity.Categoria;
import com.example.projectApiRestAvanade.entity.Product;

import java.util.List;

public interface ProductService {

        public List<Product> getAllProducts();

        public Product getProductById(String codigo);

        public Product createProduct(Product product);

        public void deleteProduct(String codigo);

        public Product updateProduct(String codigo, Product product);

        public Product saveProduct(Product product);

//        public List<Categoria> getAllCategoria();
//
//        public Categoria getCategoriaById(String codigo);
//
//        public Categoria createCategoria(Categoria categoria);
//
//        public void deleteCategoria(String codigo);
//
//        public Categoria updateCategoria(String codigo, Categoria categoria);
//
//        public Categoria saveProduct(Categoria categoria);


}
