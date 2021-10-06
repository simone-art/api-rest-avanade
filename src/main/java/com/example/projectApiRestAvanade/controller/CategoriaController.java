package com.example.projectApiRestAvanade.controller;


import com.example.projectApiRestAvanade.entity.Categoria;
import com.example.projectApiRestAvanade.entity.Product;
import com.example.projectApiRestAvanade.repository.CategoriaRepository;
import com.example.projectApiRestAvanade.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> getAllCategoria(){
        return this.categoriaService.getAllCategorias();
    }

    @GetMapping("/codigo")
    public Categoria getCategoriaById(@PathVariable String codigo){
        return this.categoriaService.getCategoriaById(codigo);
    }

    @PostMapping
    public Categoria createdCategoria(@RequestBody @Valid Categoria categoria){
        return this.categoriaService.createdCategoria(categoria);
    }

    @DeleteMapping("/{codigo}")
    public String deleteCategoria(@PathVariable String codigo){
        categoriaService.deleteCategoria(codigo);
        System.out.println("Categoria deletada com sucesso");
        return "Categoria deletada com sucesso";
    }

    @PutMapping("{codigo}")
    public String updateCategoria(@PathVariable String codigo, @RequestBody Categoria categoria){
        Categoria existingCategoria = categoriaService.getCategoriaById(codigo);
        BeanUtils.copyProperties(categoria, existingCategoria, "categoria_id");
        System.out.println("Categoria atualizada com sucesso");
        categoriaService.saveCategoria(existingCategoria);
        return "Categoria atualizada com sucesso";
    }


}
