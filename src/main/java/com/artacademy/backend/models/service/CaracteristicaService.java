package com.artacademy.backend.models.service;

import java.util.List;

import com.artacademy.backend.models.entity.ObraCaracteristica;

public interface CaracteristicaService {
	public List<ObraCaracteristica> listarObrasCaracteristicas();
    public void guardarCaracteristica(ObraCaracteristica obraCaracteristica);
    
}
