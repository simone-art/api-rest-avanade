package com.example.projectApiRestAvanade.controller;

import com.example.projectApiRestAvanade.entity.Product;
import com.example.projectApiRestAvanade.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

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

}
