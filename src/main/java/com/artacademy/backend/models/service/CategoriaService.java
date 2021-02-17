package com.artacademy.backend.models.service;

import java.util.List;

import com.artacademy.backend.models.entity.Categoria;

public interface CategoriaService {

    public List <Categoria> ListaCategoria();
    public void GuardarCategoria(Categoria categoria);
}
