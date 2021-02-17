package com.artacademy.backend.models.dao;

import com.artacademy.backend.models.entity.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaDao  extends JpaRepository<Categoria, Long>{
    
}
