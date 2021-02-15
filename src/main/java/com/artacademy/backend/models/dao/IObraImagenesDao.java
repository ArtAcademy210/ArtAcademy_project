package com.artacademy.backend.models.dao;

import com.artacademy.backend.models.entity.ObraImagenes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IObraImagenesDao extends JpaRepository<ObraImagenes, Long>{
    
}
