package com.artacademy.backend.models.service;

import java.util.List;

import com.artacademy.backend.models.dao.IObraImagenesDao;
import com.artacademy.backend.models.entity.ObraImagenes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ObraImagenesServiceImp implements ObraImagenesService {
	@Autowired
	private IObraImagenesDao imgdao;

	@Transactional
	
	public void guardarImagenes(ObraImagenes obraImagenes) {
		imgdao.save(obraImagenes);

	}
	@Transactional(readOnly = true)
	
	public List<ObraImagenes> listarObraImagenes() {
		// TODO Auto-generated method stub
		return imgdao.findAll();
	}
	@Transactional
	
	public void eliminarImagenes(Long id) {
		imgdao.deleteById(id);
		
	}
	@Transactional(readOnly = true)
	
	public ObraImagenes buscarObraImagenes(Long id) {
		// TODO Auto-generated method stub
		return imgdao.findById(id).orElse(null);
	}
    
}
