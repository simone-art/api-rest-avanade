package com.example.projectApiRestAvanade.controller;

import com.example.projectApiRestAvanade.entity.Product;
import com.example.projectApiRestAvanade.repository.ProductRepository;
import com.example.projectApiRestAvanade.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProduct(){
     return this.productService.getAllProducts();
    }

    @GetMapping("/{codigo}")
    public Product getProductById(@PathVariable String codigo){
        return this.productService.getProductById(codigo);

    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return  this.productService.createProduct(product);

    }

    @DeleteMapping("/{codigo}")
    public String deleteProduct(@PathVariable String codigo){
        productService.deleteProduct(codigo);
        System.out.println("Producto deletado com sucesso");
        return "Deletado com sucesso";
    }

    @PutMapping("/{codigo}")
    public String updateProduct(@PathVariable String codigo, @RequestBody Product product){
        Product existingProduct = productService.getProductById(codigo);
        BeanUtils.copyProperties(product, existingProduct, "product_id");
        System.out.println("Produto atualizado com sucesso");
        productRepository.save(existingProduct);
        return "Produto atualizado com sucesso";
    }



}
