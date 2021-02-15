package com.artacademy.backend.models.service;

import java.util.List;

import com.artacademy.backend.models.dao.ObraDao;
import com.artacademy.backend.models.entity.Obra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ObraServiceImp implements ObraService {

    @Autowired
    private ObraDao obradao;
    @Transactional(readOnly = true)
    
    public List<Obra> listarObras() {
   
        return obradao.findAll();
    }


    @Transactional(readOnly = true)
    public Obra buscarObra(Long id) {
       
        return obradao.findById(id).orElse(null);
    }

    
    public void guardarObra(Obra obra) {
       obradao.save(obra);

    }

   
    
}
