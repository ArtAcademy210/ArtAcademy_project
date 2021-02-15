package com.artacademy.backend.models.service;

import com.artacademy.backend.models.dao.IObraCaracteristicaDao;

import com.artacademy.backend.models.entity.ObraCaracteristica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CaracteristicaServiceImp implements CaracteristicaService {
    @Autowired
    private IObraCaracteristicaDao obracara;
    
    
    @Transactional(readOnly=true)
	public List<ObraCaracteristica> listarObrasCaracteristicas() {
		// TODO Auto-generated method stub
		return obracara.findAll();
	}
    @Transactional
    public void guardarCaracteristica(ObraCaracteristica obraCaracteristica) {
       obracara.save(obraCaracteristica);

    }
    

    
 
    
    
}