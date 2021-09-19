package com.example.projectApiRestAvanade.controller;

import com.example.projectApiRestAvanade.entity.Product;
import com.example.projectApiRestAvanade.repository.ProductRepository;
import com.example.projectApiRestAvanade.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Product createProduct(@RequestBody @Valid Product product){
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
        productService.saveProduct(existingProduct);
        return "Produto atualizado com sucesso";
    }

    //Metodo que retorna mensagems de erro caso ocorra um bad request e valida
    //@ResponseStatus(HttpStatus.BAD_GATEWAY) intercepta toda bad request pra devolver as mensagens
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            //Pega nomes dos campos
            String fieldName = ((FieldError)error).getField();
            //Pega as mensagens de erro
            String errorMensage = error.getDefaultMessage();
            //Devolve os campos com suas respectivas mensagens de erros já definidas
            errors.put(fieldName, errorMensage);
        });
        return errors;
    }





}
