package com.artacademy.backend.models.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ObraImagenes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlimagen;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "obra_id")
    private Obra obra;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlimagen() {
        return this.urlimagen;
    }

    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }

    public Obra getObra() {
        return this.obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }
    
}
