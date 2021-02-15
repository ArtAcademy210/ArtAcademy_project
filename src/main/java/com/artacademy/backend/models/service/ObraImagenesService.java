package com.artacademy.backend.models.service;

import java.util.List;

import com.artacademy.backend.models.entity.ObraImagenes;

public interface ObraImagenesService {
    public List<ObraImagenes> listarObraImagenes();
    public ObraImagenes buscarObraImagenes(Long id);
    public void guardarImagenes(ObraImagenes obraImagenes);
    public void eliminarImagenes(Long id);
    
}
