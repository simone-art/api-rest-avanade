package com.example.projectApiRestAvanade.controller;

import com.example.projectApiRestAvanade.entity.Categoria;
import com.example.projectApiRestAvanade.entity.Product;
import com.example.projectApiRestAvanade.repository.CategoriaRepository;
import com.example.projectApiRestAvanade.repository.ProductRepository;
import com.example.projectApiRestAvanade.service.CategoriaService;
import com.example.projectApiRestAvanade.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Product> getAllProduct(){
     return this.productService.getAllProducts();
    }

    //OPTIONAL é um container que pode estar nulo ou conter algum dado
    //O optional extrai o que está dentro do cliente e se não tiver nada retorna nulo
    @GetMapping("/{codigo}")
    public ResponseEntity<Product> buscarProdutoId(@PathVariable String codigo) {
        Optional<Product>  product = productRepository.findById(codigo);
        if(product.isPresent()){
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody @Valid Product product){
        return productService.saveProduct(product);

    }


    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String codigo){
        if(productRepository.existsById(codigo)){
            ResponseEntity.notFound().build();
        }
        productService.deleteProduct(codigo);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{codigo}")
    public ResponseEntity<Product> updateProduct(@Valid @PathVariable String codigo, @RequestBody Product product){
        if(!productRepository.existsById(codigo)){
            ResponseEntity.notFound().build();
        }
        product.setCodigo(codigo);
        product = productService.saveProduct(product);
        return ResponseEntity.ok(product);
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
