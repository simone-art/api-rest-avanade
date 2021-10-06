package com.example.projectApiRestAvanade.impl;

import com.example.projectApiRestAvanade.entity.Categoria;
import com.example.projectApiRestAvanade.repository.CategoriaRepository;
import com.example.projectApiRestAvanade.service.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> getAllCategorias() {
        return this.categoriaRepository.findAll();
    }

    @Override
    public Categoria getCategoriaById(String codigo) {
        return this.categoriaRepository.findById(codigo)
                .orElseThrow(()-> new IllegalArgumentException("Categoria não existe"));
    }

    @Override
    public Categoria createdCategoria(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public void deleteCategoria(String codigo) {
        categoriaRepository.deleteById(codigo);
    }

    @Override
    public Categoria updateCategoria(String codigo, Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {
        return this.categoriaRepository.save(categoria);
    }
}
