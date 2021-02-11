package com.artacademy.backend.models.dao;

import com.artacademy.backend.models.entity.Obra;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraDao extends JpaRepository<Obra, Long> {
    
}
