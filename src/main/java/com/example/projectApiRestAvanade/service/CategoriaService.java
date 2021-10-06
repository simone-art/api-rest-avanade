package com.example.projectApiRestAvanade.service;

import com.example.projectApiRestAvanade.entity.Categoria;


import java.util.List;

public interface CategoriaService {

    public List<Categoria> getAllCategorias();

    public Categoria getCategoriaById(String codigo);

    public Categoria createdCategoria(Categoria categoria);

    public void deleteCategoria(String codigo);

    public Categoria updateCategoria(String codigo, Categoria categoria);

    public Categoria saveCategoria(Categoria categoria);
}
