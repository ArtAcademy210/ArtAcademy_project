package com.artacademy.backend.models.service;

import java.util.List;

import com.artacademy.backend.models.entity.Obra;

public interface ObraService {
    public List<Obra> listarObras();
    public Obra buscarObra(Long id);
    public void guardarObra(Obra obra);
    
    
}
