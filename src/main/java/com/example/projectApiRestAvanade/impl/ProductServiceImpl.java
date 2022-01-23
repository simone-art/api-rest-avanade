package com.example.projectApiRestAvanade.impl;

import com.example.projectApiRestAvanade.entity.Categoria;
import com.example.projectApiRestAvanade.entity.Product;
import com.example.projectApiRestAvanade.repository.CategoriaRepository;
import com.example.projectApiRestAvanade.repository.ProductRepository;
import com.example.projectApiRestAvanade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired

    private CategoriaRepository categoriaRepository;
    
    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(String codigo) {
        Product produtos = new Product();
        produtos.getCategoria().getCodigo();
        return this.productRepository.findById(codigo)
                .orElseThrow(()-> new IllegalArgumentException("Produto nao existe"));
    }

    @Override
    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public void deleteProduct(String codigo) {
        productRepository.deleteById(codigo);
    }

    @Override
    public Product updateProduct(String codigo, Product product){
        return this.productRepository.save(product);
    }

    public Product saveProduct(Product product){
        return this.productRepository.save(product);
    }

//    @Override
//    public List<Categoria> getAllCategoria() {
//        return this.categoriaRepository.findAll();
//    }
//
//    @Override
//    public Categoria getCategoriaById(String codigo) {
//        Categoria categorias = new Categoria();
//        categorias.getCodigo();
//        return this.categoriaRepository.findById(codigo)
//        .orElseThrow(() -> new IllegalArgumentException("Categoria não existe"));
//    }
//
//    @Override
//    public Categoria createCategoria(Categoria categoria) {
//        return this.categoriaRepository.save(categoria);
//    }
//
//    @Override
//    public void deleteCategoria(String codigo) {
//       categoriaRepository.deleteById(codigo);
//    }
//
//    @Override
//    public Categoria updateCategoria(String codigo, Categoria categoria) {
//        categoriaRepository.findById(codigo);
//        return categoriaRepository.save(categoria);
//    }
//
//    @Override
//    public Categoria saveProduct(Categoria categoria) {
//        return categoriaRepository.save(categoria);
//    }


}
