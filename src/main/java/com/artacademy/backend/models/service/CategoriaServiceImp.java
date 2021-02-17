package com.artacademy.backend.models.service;

import java.util.List;

import com.artacademy.backend.models.dao.ICategoriaDao;
import com.artacademy.backend.models.entity.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImp implements CategoriaService{
    @Autowired

    private ICategoriaDao DAO;
	@Override
	public List<Categoria> ListaCategoria() {
		
		return DAO.findAll();
	}

	@Override
	public void GuardarCategoria(Categoria categoria) {
        DAO.save(categoria);
		
	}

}
    

